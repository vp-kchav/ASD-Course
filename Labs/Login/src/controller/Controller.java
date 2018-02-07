package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;


public class Controller implements Initializable {

	public static int id = -1;

	private final static ObservableList<Test> list = FXCollections.observableArrayList();

	@FXML
	private TableView<Test> table;

	@FXML
	public void Exit(ActionEvent event) {
		final Node source = (Node) event.getSource();
		final Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void AddPersonal(ActionEvent event) throws Exception {
		// addList(new Test("col12", "col2", "col3", "col4", "col5", "col6"));
		// System.out.println(getList());
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/com/asd/view/Personal.fxml"));
		
		Scene scene = new Scene(root, 600, 400);
		String css = getClass().getClassLoader().getResource("com/asd/gui/css.css").toExternalForm();
		scene.getStylesheets().add(css);
		primaryStage.setScene(scene);
	
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	public void AddCompany(ActionEvent event) throws Exception {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/com/asd/view/Company.fxml"));
		Scene scene = new Scene(root, 600, 400);
		String css = getClass().getClassLoader().getResource("com/asd/gui/css.css").toExternalForm();
		scene.getStylesheets().add(css);
		primaryStage.setScene(scene);
	
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	public void interest(ActionEvent event) {
		int id = 0;
		for (Test ac : getList()) {
			list.set(id, list.get(id).setCol6(Math.round(ac.getCol6() * 1.05 * 100.0) / 100.0));
			id++;
		}
	}

	@FXML
	public void Withdraw(ActionEvent event) throws Exception {

		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/com/asd/view/Withdraw.fxml"));
		Scene scene = new Scene(root, 257, 231);
		String css = getClass().getClassLoader().getResource("com/asd/gui/css.css").toExternalForm();
		scene.getStylesheets().add(css);
		primaryStage.setScene(scene);
	
		primaryStage.setScene(scene);
		
		
		primaryStage.show();
	}

	@FXML
	public void Deposit(ActionEvent event) throws Exception {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/com/asd/view/Deposit.fxml"));
		Scene scene = new Scene(root, 257, 231);
		String css = getClass().getClassLoader().getResource("com/asd/gui/css.css").toExternalForm();
		scene.getStylesheets().add(css);
		primaryStage.setScene(scene);
	
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		table.setItems(getList());
		table.getSelectionModel().selectedIndexProperty().addListener((num) -> {
			id = table.getSelectionModel().selectedIndexProperty().get();
		});
	}

	public void addList(String col1, String col2, String col3, String col4, String col5, Double col6) {
		list.add(new Test(col1, col2, col3, col4, col5, col6));
	}

	public void setBalance(int id, Double value) {
		list.set(id, list.get(id).setCol6(value));
	}

	public ObservableList<Test> getList() {
		return list;
	}
	 @FXML
	    void logoutBtn(ActionEvent event) throws Exception {
	    	Stage primaryStage = new Stage();
	    	primaryStage.setTitle("Login Form");
	        
	        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("com/asd/gui/LoginView.fxml"));

	        Scene scene = new Scene(root);
	        String css = getClass().getClassLoader().getResource("com/asd/gui/css.css").toExternalForm();
			scene.getStylesheets().add(css);
			
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			 
	        primaryStage.show();
	        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        primaryStage.close();
	    }
}