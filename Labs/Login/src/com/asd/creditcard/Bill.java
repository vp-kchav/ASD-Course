package com.asd.creditcard;

import java.net.URL;
import java.util.ResourceBundle;

import com.asd.ccard.domain.CreditAccount;
import com.asd.ccard.domain.CreditAccountFactory;
import com.asd.ccard.domain.CreditCardAccountVisitor;
import com.asd.ccard.view.CreditCardView;
import com.asd.domain.Account;
import com.asd.domain.AccountFactory;
import com.asd.domain.Address;
import com.asd.domain.Customer;
import com.asd.domain.DebitAccountFactory;
import com.asd.domain.Individaul;
import com.asd.repository.AccountDAO;
import com.asd.repository.AccountDAOImpl;
import com.asd.repository.MockAccountDAO;
import com.asd.service.AccountService;
import com.asd.service.AccountServiceImpl;
import com.asd.service.BalanceChangeObserver;
import com.asd.service.EmailSender;
import com.asd.view.AccountView;
import com.asd.view.BankView;
import com.asd.visitor.ReportVisitor;

import controller.Test;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class Bill implements Initializable {

	@FXML
	private TextField bill;
	
	@FXML
	private Label label;

	private CreditCardController addlist = new CreditCardController();
	int id = addlist.id;
	
	@FXML
	public void Exit(ActionEvent event) {
		final Node source = (Node) event.getSource();
		final Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

	AccountFactory accountFactory = new CreditAccountFactory();
	AccountDAO accountDao = new AccountDAOImpl();

	AccountService accountService = new AccountServiceImpl(accountDao, accountFactory);
	AccountView accountView;

	public void setAccountView(AccountView accountView) {
		this.accountView = accountView;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		AccountFactory accountFactory = new CreditAccountFactory();
		MockAccountDAO accountDao = new MockAccountDAO();

		AccountService accountService = new AccountServiceImpl(accountDao, accountFactory);

//		BalanceChangeObserver observer = new EmailSender();
//		accountService.addBalanceChangeObserver(observer);

//		CreditCardView ca = new CreditCardView(accountService);
//		accountView = ca;
//		System.out.println(accountService.toString());
		
		CreditCardView l = new CreditCardView(accountService);
		
		CreditAccount ca;
		


		String ano = addlist.getList().get(id).getCol2();
		Account account = l.getAccount(ano);
		
		//l.visit(ca.getAccount(ano));
		//System.out.println(ca.getAccount(ano));
//		CreditCardAccountVisitor r = new CreditCardAccountVisitor();

		//System.out.println("===" + l.getAccount(ano));
		//r.visit(l.getAccount(ano));
		//System.out.println(l.getAccount(ano).toString());

		CreditCardAccountVisitor cc = new CreditCardAccountVisitor();

		cc.visit(account);
		System.out.println(cc.getReport());
if (cc!=null) {

//cc.visit(accountDao.loadAccount(ano));
//	cc.visit(accountDao.loadAccount(ano));
	System.out.println(cc.getReport());
//System.out.println(accountDao.loadAccount(ano));

		label.setText(cc.getReport());
}
//		addlist.setBalance(id, old + Double.parseDouble(amount.getText()));
	}
}