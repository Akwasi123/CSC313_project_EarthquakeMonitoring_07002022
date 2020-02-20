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

    @FXML
    private Button store;

    @FXML
    private Button back;

    @FXML
    public TextField vegColor;

    @FXML
    public TextField vegColorValue;

    @FXML
    public TextField yearofEvent;

    @FXML
    public TextField latitude;

    @FXML
    public TextField longitude;

    public TextField newObsName;


    public void getvegColor(){
        vegColor.getText();
    }

    public void getvegColorValue(){
        vegColorValue.getText();
    }

    public void getyearofEvent(){
        yearofEvent.getText();
    }

    public void getLatitude(){
        latitude.getText();
    }

    public void getLongitude(){
        longitude.getText();
    }

    public void getnObsName(){ newObsName.getText(); }

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
     * 
     * @param event
     * @throws IOException
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
