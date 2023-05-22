package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Observer.*;
// ricordarsi di importare la disconnessione
import it.polimi.ingsw.Message.Request.LoginRequest;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.*;

public class LoginScene {

    @FXML
    private Button loginButton;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField nicknameField;

    @FXML
    private Label textLabel;

    @FXML

    private void onLoginButtonClick(Event event) {
        try {
            // push FXML file of new scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("select_np_scene.fxml"));
            Parent nPSceneRoot = loader.load();

            // create a new scene by the root of the new scene
            Scene nPScene = new Scene(nPSceneRoot);

            // get the current window
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // set new scene as current
            stage.setScene(nPScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


