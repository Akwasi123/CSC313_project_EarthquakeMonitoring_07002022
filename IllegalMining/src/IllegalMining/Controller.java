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
	
	/**
	 * Creating instance variables from javafx fxml file
	 */
    @FXML
    public TextField dbUsername;
    
    
    /**
	 * Creating instance variables from javafx fxml file
	 */
    @FXML
    public TextField jdbcDriver;
    
    /**
	 * Creating instance variables from javafx fxml file
	 */
    @FXML
    public TextField  dbUrl;

    /**
	 * Creating instance variables from javafx fxml file
	 */
    @FXML
    public PasswordField dbPassword;
    
    /**
	 * Creating instance variables from javafx fxml file
	 */
    @FXML
    public Button dbRegisterbt, exitScreen;

    /**
     * retrieves Username from textfield object in the GUI
     */
    public void getdbUsername(){
        dbUsername.getText();
    }
    
    /**
     * retrieves jdbc Driver from textfield object in the GUI
     */
    public void getJdbcDriver(){
        System.out.println(jdbcDriver.getText());
    }
    
    /**
     * retrieves Password from passwordfield object in the GUI
     */
    public void getdbPassword(){
        dbPassword.getText();
    }
    
    /**
     * retrieves database url from textfield object in the GUI
     */
    public void getdbUrl(){
        dbUrl.getText();
    }
    
    /**
     * Button that allows database connection to be registered
     */
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
    
    /**
     * Button that closes GUI screen when pressed
     */
    public void setExitScreen(ActionEvent event) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("DBScene.fxml"));
        Scene viewScene = new Scene(viewParent);

        //Get stage(Window) Information
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();

        window.close();

    }
}
