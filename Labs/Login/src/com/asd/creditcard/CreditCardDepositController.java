package com.asd.creditcard;

import java.net.URL;
import java.util.ResourceBundle;

import com.asd.ccard.domain.CreditAccountFactory;
import com.asd.domain.AccountFactory;
import com.asd.repository.AccountDAO;
import com.asd.repository.AccountDAOImpl;
import com.asd.service.AccountService;
import com.asd.service.AccountServiceImpl;
import com.asd.view.AccountView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreditCardDepositController implements Initializable {
	@FXML
	private Button Cancel;

	@FXML
	private TextField account;

	@FXML
	private TextField amount;

	@FXML
	private TableView<Test> table;

	private CreditCardController addlist = new CreditCardController();
	int id = addlist.id;

	@FXML
	public void Exit(ActionEvent event) {
		final Node source = (Node) event.getSource();
		final Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void OK(ActionEvent event) {
		AccountFactory accountFactory = new CreditAccountFactory();
		AccountDAO accountDao = new AccountDAOImpl();

		AccountService accountService = new AccountServiceImpl(accountDao, accountFactory);
		AccountView accountView = null;
		
		
		Double old = addlist.getList().get(id).getCol5();
		Double bal = old + Double.parseDouble(amount.getText());
		addlist.setBalance(id, bal);
		System.out.println(addlist.getList().get(id).getCol2() + " " + bal);
		accountView.deposit(addlist.getList().get(id).getCol2(), bal);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		account.setText(Integer.toString(id));
	}
}