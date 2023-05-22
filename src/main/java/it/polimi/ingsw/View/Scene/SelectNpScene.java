package it.polimi.ingsw.View.Scene;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectNpScene {

    @FXML
    private Button fourPlayerButton;

    @FXML
    private Button threePlayerButton;

    @FXML
    private Button twoPlayerButton;

    @FXML
    private AnchorPane pane;

    @FXML
    private Label textLabel;



    @FXML

    private void nPlayerButtonClick(Event event) {
        try {
            // push FXML file of new scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("wait_scene.fxml"));
            Parent waitSceneRoot = loader.load();

            // create a new scene by the root of the new scene
            Scene waitScene= new Scene(waitSceneRoot);

            // get the current window
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // set new scene as current
            stage.setScene(waitScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
