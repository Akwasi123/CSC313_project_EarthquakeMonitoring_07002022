package IllegalMining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.*;


public class ObservatoryController {

    Statement stmt;

    private Connection conn;
    
    /**
	 * Creating instance variables from javafx fxml file
	 */
    @FXML
    private Button store2;

    /**
	 * Creating instance variables from javafx fxml file
	 */
    @FXML
    private Button back2;

    /**
	 * Creating instance variables from javafx fxml file
	 */
    @FXML
    public TextField obsName;
    
    /**
	 * Creating instance variables from javafx fxml file
	 */
    @FXML
    public TextField country;
    
    /**
	 * Creating instance variables from javafx fxml file
	 */
    @FXML
    public TextField yearStarted;
    
    /**
	 * Creating instance variables from javafx fxml file
	 */
    @FXML
    public TextField area;

    /**
     * retrieves Observatory name from textfield object in the GUI
     */
    public void getObsName(){
        obsName.getText();
    }
    
    /**
     * retrieves country from textfield object in the GUI
     */
    public void getCountry(){
        country.getText();
    }
    
    /**
     * retrieves year observatory events started  from textfield object in the GUI
     */
    public void getyearStarted(){
        yearStarted.getText();
    }
    
    /**
     * retrieves area from textfield object in the GUI
     */
    public void getArea(){
        area.getText();
    }
    
    /**
     * retrieves data from textfield objects in the GUI
     * and stores the data into a database
     */
    public void setObsStore() {

        Mining database = new Mining();
        conn = database.getDbConnection();

        String query = "INSERT INTO Observatory(ObsName, country, year_started, area_covered)" +
                "VALUES ('"+obsName.getText()+"','"+country.getText()+"','"+yearStarted.getText()+"','"+area.getText()+"')";

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    
    /**
     * Allows a user to return to previous screen
     */
    public void setObsBack(ActionEvent event) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("MenuScene.fxml"));
        Scene viewScene = new Scene(viewParent);

        //Get stage(Window) Information
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();


        window.setScene(viewScene);
        window.show();
    }
}
