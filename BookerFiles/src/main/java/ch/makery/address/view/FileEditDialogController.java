package ch.makery.address.view;

import ch.makery.address.model.FileM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.dialog.Dialogs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileEditDialogController {
    @FXML
    private TextField DateField;
    @FXML
    private TextField NameField;
    @FXML
    private TextField OrganizField;
    @FXML
    private TextField TapField;
    @FXML
    private TextField PathField;

    @FXML
    private void initialize() {

    }
    String sputh;
    String dataRes;
    String stringofformat = "*";
    String query = "select  * from mainwin";
    MysqlConnect mysqlConnect = new MysqlConnect();
    PreparedStatement statement;

    {
        try {
            statement = mysqlConnect.connect().prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Stage dialogStage;
    private FileM fileM;
    private boolean okClicked = false;

    private void save(String date,String firma,String name,String content,String file) {
        String sql = "insert into mainwin (" +
                "date, firma, name, content, file) values (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql)) {
            statement.setString(1, date);
            statement.setString(2, firma);
            statement.setString(3, name);
            statement.setString(4, content);
            statement.setString(5, file);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setFileM(FileM fileM) {
        this.fileM = fileM;
        DateField.setText(fileM.getDate());
        NameField.setText(fileM.getName());
        OrganizField.setText(fileM.getOrganization());
        TapField.setText(fileM.getTapping());
        PathField.setText(fileM.getPath());
    }

    @FXML
    void ChosePuth(ActionEvent event) throws SQLException, IOException {
        String dataRes;
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("BookerFiles", stringofformat));
        File file = fileChooser.showOpenDialog(null);
        BasicFileAttributes attributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
        if (file != null)
        {
            dataRes = String.valueOf(attributes.creationTime());
            dataRes = dataRes.substring(0, 10);
            OrganizField.setText(dataRes);
            sputh = file.getAbsolutePath();
            PathField.setText(sputh);
            DateField.setText(file.getName());
            NameField.setText(dataRes);
        }
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            fileM.setDate(DateField.getText());
            fileM.setName(NameField.getText());
            fileM.setOrganization(OrganizField.getText());
            fileM.setTapping(TapField.getText());
            fileM.setPath(sputh);

            save(DateField.getText(), NameField.getText(), OrganizField.getText(), TapField.getText(), sputh );

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    public boolean isOkClicked() {
        return okClicked;
    }
    private boolean isInputValid() {
        String errorMessage = "";

        if (DateField.getText() == null || DateField.getText().length() == 0) {
            //errorMessage += "No valid date!\n";
            DateField.setText("No");
        }
        if (NameField.getText() == null || NameField.getText().length() == 0) {
            //errorMessage += "No valid name!\n";
            NameField.setText(dataRes);
        }
        if (OrganizField.getText() == null || OrganizField.getText().length() == 0) {
            //errorMessage += "No valid organization!\n";
            OrganizField.setText("No");
        }

        if (TapField.getText() == null || TapField.getText().length() == 0) {
            //errorMessage += "No valid Mark!\n";
            TapField.setText("No");
        }

        if (PathField.getText() == null || PathField.getText().length() == 0) {
            //errorMessage += "No valid path!\n";
            PathField.setText("No");
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Dialogs.create().title("Invalid Fields").masthead("Please correct invalid fields").message(errorMessage).showError();
            return false;
        }
    }
}