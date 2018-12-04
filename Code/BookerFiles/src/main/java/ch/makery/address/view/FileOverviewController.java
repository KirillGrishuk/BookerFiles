package ch.makery.address.view;

import ch.makery.address.MainApp;
import ch.makery.address.model.FileM;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.controlsfx.dialog.Dialogs;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileOverviewController {
    @FXML
    private TableView<FileM> FilesTable;
    @FXML
    private TableColumn<FileM, String> DateColumn;
    @FXML
    private TableColumn<FileM, String> nameColumn;

    @FXML
    private Label dateLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label organization;
    @FXML
    private Label Tapping;
    @FXML
    private Label Path;


	String query = "select  * from mainwin";
	MysqlConnect mysqlConnect = new MysqlConnect();
	PreparedStatement statement = mysqlConnect.connect().prepareStatement(query);

    private MainApp mainApp;

    public FileOverviewController() throws SQLException {
    }

    @FXML
    private void initialize() throws SQLException {

        DateColumn.setCellValueFactory(
        		cellData -> cellData.getValue().dateProperty());
        nameColumn.setCellValueFactory(
        		cellData -> cellData.getValue().nameProperty());

        showPersonDetails(null);

		FilesTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> {
					try {
						showPersonDetails(newValue);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				});
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        FilesTable.setItems(mainApp.getPersonData());
    }

    private void showPersonDetails(FileM person) throws SQLException {
    	if (person != null) {
			FileM selectedString = FilesTable.getSelectionModel().getSelectedItem();
			String t = selectedString.getDate();
			String setlabel = "select * from mainwin where date = '" + t +"' ";
			PreparedStatement statement = mysqlConnect.connect().prepareStatement(setlabel);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()){
			dateLabel.setText(resultSet.getString("date"));
			nameLabel.setText(resultSet.getString("name"));
			organization.setText(resultSet.getString("firma"));
			Tapping.setText(resultSet.getString("content"));
			Path.setText(resultSet.getString("file"));
				 }

    	} else {
    		dateLabel.setText("");
    		nameLabel.setText("");
    		organization.setText("");
    		Tapping.setText("");
    		Path.setText("");
    	}
    }

    @FXML
	private void openfile() throws SQLException, IOException {
		FileM selectedString = FilesTable.getSelectionModel().getSelectedItem();
		String t = selectedString.getDate();
		String setlabel = "select * from mainwin where date = '" + t +"' ";
		PreparedStatement statement = mysqlConnect.connect().prepareStatement(setlabel);
		ResultSet resultSet = statement.executeQuery();
		String op = null;
		while (resultSet.next())
			op = resultSet.getString("file");
		Desktop.getDesktop().open(new File(op));

	}


	@FXML
	private void handleDeletePerson() throws SQLException {
		int selectedIndex = FilesTable.getSelectionModel().getSelectedIndex();

		FileM selectedString = FilesTable.getSelectionModel().getSelectedItem();
		String stodel = selectedString.getName();
		String SQL = "DELETE FROM mainwin WHERE name = '"+stodel+"' ";

		statement.executeUpdate(SQL);

		if (selectedIndex >= 0) {
			FilesTable.getItems().remove(selectedIndex);
		} else {
			// Nothing selected.
			Dialogs.create()
		        .title("No Selection")
		        .masthead("No File Selected")
		        .message("Please select a file in the table.")
		        .showWarning();
		}
	}

	@FXML
	private void handleNewPerson() throws SQLException {
		FileM tempPerson = new FileM();
		boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
		if (okClicked) {
			mainApp.getPersonData().add(tempPerson);
		}
	}

}