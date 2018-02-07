package com.asd.creditcard;

import java.net.URL;
import java.util.ResourceBundle;

import com.asd.ccard.domain.CreditAccountFactory;
import com.asd.ccard.view.CreditCardView;
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

import controller.Test;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class AccountController implements Initializable {

	@FXML
	private TextField col1;

	@FXML
	private TextField col2;

	@FXML
	private TextField col3;

	@FXML
	private TextField col4;

	@FXML
	private TextField col5;

	@FXML
	private TextField col6;

	@FXML
	private TextField col7;

	@FXML
	private TextField col8;

	@FXML
	private ToggleGroup type;

	@FXML
	private TableView<Test> table;

	private CreditCardController addlist;

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

	@FXML
	public void add(ActionEvent event) {
		RadioButton selectedRadioButton = (RadioButton) type.getSelectedToggle();
		String accountType = selectedRadioButton.getText();

		Address address = new Address();
		address.setCity(col4.getText());
		address.setZip(col6.getText());
		address.setState(col5.getText());
		address.setStreet(col3.getText());
		Customer customer = new Individaul();
		customer.setName(col2.getText());
		customer.setAddress(address);

//		String accountTypeSelected = accountType.equals("gold") ? "GOLD" : (accountType.equals("silver") ? "SILVER" : "BRONZE");
//		if(accountType.equals("gold")){
//			accountTypeSelected=
//		}
		
		AccountFactory accountFactory = new CreditAccountFactory();
		AccountDAO ma = new AccountDAOImpl();

		//CreditCardView ca = new CreditCardView(accountService);

		ma.saveAccount(accountFactory.create(customer, accountType.toUpperCase(), col2.getText(), 0.0));
		//accountView.createAccount(customer, accountType.toUpperCase(), col2.getText(), 0.0);

		addlist = new CreditCardController();
		addlist.addList(col2.getText(), col1.getText(), col7.getText(), accountType.toUpperCase(), 0.0);

	}

	public AccountView getAccountView() {
		return accountView;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		AccountFactory accountFactory = new CreditAccountFactory();
		AccountDAO accountDao = new AccountDAOImpl();

		AccountService accountService = new AccountServiceImpl(accountDao, accountFactory);

		BalanceChangeObserver observer = new EmailSender();
		accountService.addBalanceChangeObserver(observer);

		CreditCardView ca = new CreditCardView(accountService);
		accountView = ca;
	}
}