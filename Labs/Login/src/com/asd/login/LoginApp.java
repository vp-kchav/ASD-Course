package com.asd.login;

import com.asd.gui.Splash;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LoginApp extends Application{
	static Splash splash;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

	
		
		primaryStage.setTitle("Login Form");
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("com/asd/gui/LoginView.fxml"));

		Scene scene = new Scene(root, 500,350 );
		String css = getClass().getClassLoader().getResource("com/asd/gui/css.css").toExternalForm();
		scene.getStylesheets().add(css);
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(new Image("com/asd/gui/icon.png"));
		
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		splash =new Splash(2000); // duration = 8 seconds
        splash.showSplash(); // show splash screen
		launch(args);

	}
	
}
