package it.polimi.ingsw.View.Scene;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectIpScene {

    @FXML
    private TextField ipTextField;

    @FXML
    private Label label;

    @FXML
    private AnchorPane selectIpPane;

    @FXML
    private Button okButton;


    private void okButtonClick(Event event) {
        try {
            // push FXML file of new scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login_scene.fxml"));
            Parent loginSceneRoot = loader.load();

            // create a new scene by the root of the new scene
            Scene loginScene= new Scene(loginSceneRoot);

            // get the current window
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // set new scene as current
            stage.setScene(loginScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}