package com.asd.gui;

import com.asd.login.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class LoginController {

	
	@FXML
	private Button login;

	@FXML
	private TextField username;

	@FXML
	private PasswordField password;

	@FXML
	private Label message;
	Stage primaryStage = new Stage();

	public void handle(ActionEvent event) throws Exception {
					
			if (username.getText().equals("user") && password.getText().equals("pass")) {
				CloseAction(event);
				((Node) event.getSource()).getScene().getWindow();

				primaryStage.setTitle("Bank Account");

				 Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("com/asd/view/Main.fxml"));

				
				 Scene scene = new Scene(root); 
				 String css = getClass().getResource("css.css").toExternalForm();
				 scene.getStylesheets().add(css);
				  primaryStage.setResizable(false);
				  primaryStage.setScene(scene); 
				  primaryStage.getIcons().add(new Image("com/asd/gui/icon.png"));
				  primaryStage.show();
				  CloseAction(event);
				 
			} else if (username.getText().equals("customer") && password.getText().equals("customer")) {

				((Node) event.getSource()).getScene().getWindow();

				// primaryStage.setTitle(SceneResource.APP_NAME);

				Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("com/asd/atm/view/View.fxml"));

				Scene scene = new Scene(root);
				String css = getClass().getResource("css.css").toExternalForm();
				scene.getStylesheets().add(css);
				primaryStage.setResizable(false);
				primaryStage.setScene(scene);
				primaryStage.getIcons().add(new Image("com/asd/gui/icon.png"));
				primaryStage.show();
				CloseAction(event);
			}
		 else {
			message.setText("Invalid Username/Password");
		}
	}

	@FXML
	private void CloseAction(ActionEvent event) {
		primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.close();
	}

	@FXML
	private void CloseAction1(KeyEvent event) {
		primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.close();
	}

	@FXML
	void enter(ActionEvent event) throws Exception {
        handle(event);
       	}

	 @FXML
	    void cancel(ActionEvent event) {
		 primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.close();
	    }


	// Start validation
	public boolean isEmpty(String txt) {
		if (txt.isEmpty())
			return false;
		return true;
	}

}