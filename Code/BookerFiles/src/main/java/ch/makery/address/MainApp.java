/*
*http://qaru.site/questions/3506/connect-java-to-a-mysql-database - для базы данных вне класса
* https://stackoverflow.com/questions/19009117/creating-a-database-in-mysql-from-java - создание бд
*https://ru.stackoverflow.com/questions/690602/java-%D0%97%D0%B0%D0%BF%D0%B8%D1%81%D1%8C-%D0%B4%D0%B0%D0%BD%D0%BD%D1%8B%D1%85-%D0%B2-%D0%91%D0%94 - обавление данных
 */
//new java.sql.Date(2009, 12, 11)); - дата

package ch.makery.address;

import ch.makery.address.model.FileM;
import ch.makery.address.view.FileEditDialogController;
import ch.makery.address.view.FileOverviewController;
import ch.makery.address.view.MysqlConnect;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class MainApp extends Application {

    public String datef, namef;
    public int colel = 0;

    private Stage primaryStage;
    private BorderPane rootLayout;

    public ObservableList<FileM> personData = FXCollections.observableArrayList();
    public ArrayList<String> datel = new ArrayList();
    public ArrayList<String> namel = new ArrayList();

    String query = "select  * from mainwin";
    MysqlConnect mysqlConnect = new MysqlConnect();
    PreparedStatement statement = mysqlConnect.connect().prepareStatement(query);
    ResultSet resultSet = statement.executeQuery(query);

    public void fill() throws SQLException {
        while (resultSet.next())
        {
            datef = resultSet.getString(2);
            datel.add(datef);
            namef = resultSet.getString(3);
            namel.add(namef);
            colel++;
        }
        System.out.println("Колличество файлов --- " + colel);
    }

    public MainApp() throws SQLException {
        fill();
        for(int i = 0; i<colel; i++) {
            personData.add(new FileM(datel.get(i), namel.get(i)));
        }
    }


    @Override
    public void start(Stage primaryStage) throws SQLException {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");
        initRootLayout();

        showPersonOverview();
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPersonOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(personOverview);
            FileOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showPersonEditDialog(FileM person) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit File");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            FileEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setFileM(person);

            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ObservableList<FileM> getPersonData() {
        return personData;
    }
    public static void main(String[] args) throws SQLException {
        MysqlConnect mysqlConnect = new MysqlConnect();
        mysqlConnect.IfNotCreate();

        launch(args);
    }
}