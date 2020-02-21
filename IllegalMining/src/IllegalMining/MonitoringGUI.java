package IllegalMining;

import javafx.application.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.fxml.*;

import java.io.IOException;
/**
 * Monitoring Graphical User Interface class
 */
public class MonitoringGUI extends Application {
    public Scene scene1, scene2, scene3, scene4;
    Parent root1, root2, root3, root4;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Sets the stage(window) for GUI creation
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
         root1 = FXMLLoader.load(getClass().getResource("DBScene.fxml"));
         /*root2 = FXMLLoader.load(getClass().getResource("GalamseyScene.fxml"));
         root3 = FXMLLoader.load(getClass().getResource("ObservatoryScene.fxml"));
         root4 = FXMLLoader.load(getClass().getResource("MenuScene.fxml"));*/

        Scene scene = new Scene(root1);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
