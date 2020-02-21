package IllegalMining;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;

import javafx.stage.Stage;

public class Controller {
    @FXML
    public TextField dbUsername;

    @FXML
    public TextField jdbcDriver;

    @FXML
    public TextField  dbUrl;

    @FXML
    public PasswordField dbPassword;

    @FXML
    public Button dbRegisterbt, exitScreen;

    public void getdbUsername(){
        dbUsername.getText();
    }

    public void getJdbcDriver(){
        System.out.println(jdbcDriver.getText());
    }

    public void getdbPassword(){
        dbPassword.getText();
    }

    public void getdbUrl(){
        dbUrl.getText();
    }

    public void setDbRegisterbt(ActionEvent aEvent) throws IOException {
        getdbUsername();
        getdbPassword();
        getJdbcDriver();
        getdbUrl();



        Parent viewParent = FXMLLoader.load(getClass().getResource("MenuScene.fxml"));
        Scene viewScene = new Scene(viewParent);

        //Get stage(Window) Information
        Stage window = (Stage)((Node) aEvent.getSource()).getScene().getWindow();


        window.setScene(viewScene);
        window.show();

    }

    public void setExitScreen(ActionEvent event) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("DBScene.fxml"));
        Scene viewScene = new Scene(viewParent);

        //Get stage(Window) Information
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();

        window.close();

    }
}
