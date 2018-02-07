package com.asd.creditcard;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreditCardChargeController implements Initializable {

	@FXML
	private Button Cancel;

	@FXML
	private TextField account;

	@FXML
	private TextField amount;

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
		Double old = addlist.getList().get(id).getCol5();
		if (old >= Integer.parseInt(amount.getText())) {
			addlist.setBalance(id, old - Double.parseDouble(amount.getText()));
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		account.setText(Integer.toString(id));
	}
}