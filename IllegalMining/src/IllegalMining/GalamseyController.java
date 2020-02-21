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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GalamseyController {
    private Connection conn;
    Statement stmt;
    /**
   	 * Creating instance variables from javafx fxml file
   	 */
    @FXML
    private Button store;
    
    /**
   	 * Creating instance variables from javafx fxml file
   	 */
    @FXML
    private Button back;
    
    /**
   	 * Creating instance variables from javafx fxml file
   	 */
    @FXML
    public TextField vegColor;
    
    /**
   	 * Creating instance variables from javafx fxml file
   	 */
    @FXML
    public TextField vegColorValue;
    
    /**
   	 * Creating instance variables from javafx fxml file
   	 */
    @FXML
    public TextField yearofEvent;
    
    /**
   	 * Creating instance variables from javafx fxml file
   	 */
    @FXML
    public TextField latitude;
    
    /**
   	 * Creating instance variables from javafx fxml file
   	 */
    @FXML
    public TextField longitude;
    
    /**
   	 * Creating instance variables from javafx fxml file
   	 */
    @FXML
    public TextField newObsName;

    /**
     * retrieves vegetation color  from textfield object in the GUI
     */
    public void getvegColor(){
        vegColor.getText();
    }
    
    /**
     * retrieves vegetation color value from textfield object in the GUI
     */
    public void getvegColorValue(){
        vegColorValue.getText();
    }
    
    /**
     * retrieves year of galamsey event from textfield object in the GUI
     */
    public void getyearofEvent(){
        yearofEvent.getText();
    }
    
    /**
     * retrieves latitude from textfield object in the GUI
     */
    public void getLatitude(){
        latitude.getText();
    }
    
    /**
     * retrieves longitude from textfield object in the GUI
     */
    public void getLongitude(){
        longitude.getText();
    }
    
    /**
     * retrieves Observatory name from textfield object in the GUI
     */
    public void getnObsName(){ newObsName.getText(); }
    
    /**
     * retrieves data from textfield objects in the GUI
     * and stores the data into a database
     */
    public void setStore(){
        Mining database = new Mining();
        conn = database.getDbConnection();

        String query = "INSERT INTO Galamsey(vegetation_color, color_value, latitude, longitude, yearofevent, obsName)" +
                "VALUES ('"+vegColor.getText()+"','"+vegColorValue.getText()+"','"+yearofEvent.getText()+"','"+latitude.getText()+"','"+longitude.getText()+"','"+newObsName.getText()+"')";

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
    public void setBack(ActionEvent event) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("MenuScene.fxml"));
        Scene viewScene = new Scene(viewParent);

        //Get stage(Window) Information
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();


        window.setScene(viewScene);
        window.show();
    }


}
