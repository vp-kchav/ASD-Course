package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.asd.domain.AccountFactory;
import com.asd.domain.Address;
import com.asd.domain.Customer;
import com.asd.domain.DebitAccountFactory;
import com.asd.domain.Individaul;
import com.asd.repository.AccountDAO;
import com.asd.repository.AccountDAOImpl;
import com.asd.service.AccountService;
import com.asd.service.AccountServiceImpl;
import com.asd.service.BalanceChangeObserver;
import com.asd.service.EmailSender;
import com.asd.view.AccountView;
import com.asd.view.BankView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class PersonalController implements Initializable {

	@FXML
	private TextField account;

	@FXML
	private TextField name;

	@FXML
	private TextField street;

	@FXML
	private TextField city;

	@FXML
	private TextField state;

	@FXML
	private TextField zip;

	@FXML
	private TextField birthdate;

	@FXML
	private TextField email;

	@FXML
	private ToggleGroup type;

	@FXML
	private TableView<Test> table;

	private Controller addlist;

	@FXML
	public void Exit(ActionEvent event) {
		final Node source = (Node) event.getSource();
		final Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

	AccountFactory accountFactory = new DebitAccountFactory();
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
		address.setCity(city.getText());
		address.setZip(zip.getText());
		address.setState(state.getText());
		address.setStreet(street.getText());

		Customer customer = new Individaul();
		customer.setName(name.getText());
		customer.setAddress(address);

		String accountTypeSelected = accountType.equals("Check") ? "CHECKING" : "SAVING";
		accountView.createAccount(customer, accountTypeSelected, account.getText(), 0.0);

		addlist = new Controller();
		addlist.addList(account.getText(), name.getText(), "Personal", city.getText(), accountTypeSelected, 0.0);

	}

	public AccountView getAccountView() {
		return accountView;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		AccountFactory accountFactory = new DebitAccountFactory();
		AccountDAO accountDao = new AccountDAOImpl();

		AccountService accountService = new AccountServiceImpl(accountDao, accountFactory);

		BalanceChangeObserver observer = new EmailSender();
		accountService.addBalanceChangeObserver(observer);

		BankView ca = new BankView(accountService);
		accountView = ca;
	}
}