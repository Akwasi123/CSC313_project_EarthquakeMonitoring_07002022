package IllegalMining;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MenuController {

    @FXML
    private Button galamBt;

    @FXML
    private Button menClose;

    @FXML
    private Button ObserveBt;

    public void setGalamBt(Event event) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("GalamseyScene.fxml"));
        Scene viewScene = new Scene(viewParent);

        //Get stage(Window) Information
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();


        window.setScene(viewScene);
        window.show();
    }

    public void setObserveBt(ActionEvent event) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("ObservatoryScene.fxml"));
        Scene viewScene = new Scene(viewParent);

        //Get stage(Window) Information
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();


        window.setScene(viewScene);
        window.show();
    }

    public void setmenClose(ActionEvent event) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("DBScene.fxml"));
        Scene viewScene = new Scene(viewParent);

        //Get stage(Window) Information
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();

        window.close();

    }

}
