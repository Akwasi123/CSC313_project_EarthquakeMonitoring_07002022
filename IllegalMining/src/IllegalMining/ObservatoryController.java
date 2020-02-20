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

    @FXML
    private Button store2;


    @FXML
    private Button back2;


    @FXML
    public TextField obsName;

    @FXML
    public TextField country;

    @FXML
    public TextField yearStarted;

    @FXML
    public TextField area;


    public void getObsName(){
        obsName.getText();
    }

    public void getCountry(){
        country.getText();
    }

    public void getyearStarted(){
        yearStarted.getText();
    }

    public void getArea(){
        area.getText();
    }

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
     * 
     * @param event
     * @throws IOException
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
