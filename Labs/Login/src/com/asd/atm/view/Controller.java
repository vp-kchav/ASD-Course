package com.asd.atm.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.asd.atm.ATMMachine;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller implements Initializable {
	ATMMachine atmMachine = new ATMMachine();
	Stage primaryStage = new Stage();
	@FXML
	private Button deposit;
	 @FXML
	    private Button cancel;
	@FXML
	private Button withdraw;

	  @FXML
	    private TextArea output;
	@FXML
	private Button insert;

	@FXML
	private Button eject;
	@FXML
	private TextField pin;

	@FXML
	private TextField amount;

	@FXML
	void deposit(ActionEvent event) {
		output.setText("ATM");
	}

	@FXML
	void display(ActionEvent event) {

	}

	@FXML
	void requestCash(ActionEvent event) {
		
				
		if(!(pin.getText().isEmpty() && amount.getText().isEmpty())){
		
		atmMachine.insertPin(Integer.parseInt(pin.getText()));
		
		
		output.setText(atmMachine.requestCash(Integer.parseInt(amount.getText())));
		// pin.setText("");
		//output.setText("");

		} else{
			output.setText("Wrong pin or amount");
			
		}
	}

	@FXML
	void ejectCard(ActionEvent event) {
		output.setText("");
		output.setText(atmMachine.ejectCard());
	}

	@FXML
	void insertCard(ActionEvent event) {

		output.setText(atmMachine.insertCard());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	
	 @FXML
	    void exit(ActionEvent event) {
		 primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.close();
	    }


}
