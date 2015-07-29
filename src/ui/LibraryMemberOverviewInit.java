package ui;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import business.LibraryMember;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class LibraryMemberOverviewInit {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableColumn<LibraryMember, String> colLastName;

	@FXML
	private TableColumn<LibraryMember, String> colPhoneNumber;

	@FXML
	private TableColumn<LibraryMember, ObservableValue<String>> colAddress;

	@FXML
	private TableColumn<LibraryMember, String> colFirstName;

	@FXML
	private TableView<LibraryMember> tblLibraryMember;

	@FXML
	private TableColumn<LibraryMember, String> colMemeberID;

	@FXML
	void initialize() {
		assert colLastName != null : "fx:id=\"colLastName\" was not injected: check your FXML file 'LibraryMemberOverview.fxml'.";
		assert colPhoneNumber != null : "fx:id=\"colPhoneNumber\" was not injected: check your FXML file 'LibraryMemberOverview.fxml'.";
		assert colAddress != null : "fx:id=\"colAddress\" was not injected: check your FXML file 'LibraryMemberOverview.fxml'.";
		assert tblLibraryMember != null : "fx:id=\"tblLibraryMember\" was not injected: check your FXML file 'LibraryMemberOverview.fxml'.";
		assert colFirstName != null : "fx:id=\"colFirstName\" was not injected: check your FXML file 'LibraryMemberOverview.fxml'.";
		assert colMemeberID != null : "fx:id=\"colMemeberID\" was not injected: check your FXML file 'LibraryMemberOverview.fxml'.";

	}

	@SuppressWarnings("unchecked")
	public void setMemberTable() {
		ObservableList<LibraryMember> memberData = FXCollections
				.observableArrayList();
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> map = da.readMemberMap();
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, LibraryMember> member = (Map.Entry) it.next();
			memberData.add(member.getValue());
		}
		tblLibraryMember.setItems(memberData);

		colMemeberID
				.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>(
						"memberID"));
		colMemeberID.setCellFactory(TextFieldTableCell.forTableColumn());

		colFirstName
				.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>(
						"firstName"));
		colFirstName.setCellFactory(TextFieldTableCell.forTableColumn());

		colLastName
				.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>(
						"lastName"));
		colLastName.setCellFactory(TextFieldTableCell.forTableColumn());

		colPhoneNumber
				.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>(
						"telephone"));
		colPhoneNumber.setCellFactory(TextFieldTableCell.forTableColumn());

		colAddress
				.setCellValueFactory(new PropertyValueFactory<LibraryMember, ObservableValue<String>>(
						"address"));

	}
}
