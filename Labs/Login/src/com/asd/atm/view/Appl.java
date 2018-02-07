package com.asd.atm.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Appl extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ATM Form");
		Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));

		Scene scene = new Scene(root, 500,300 );
		primaryStage.setScene(scene);
		//primaryStage.getIcons().add(new Image("file:icon.png"));
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);

	}

}
