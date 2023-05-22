package it.polimi.ingsw.View.Scene;
import it.polimi.ingsw.Observer.ViewObservable;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import java.io.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuScene {

    @FXML
    private Button exitButton;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button playButton;



        @FXML
        private void playButtonClick(Event event) {
            try {
                // push FXML file of new scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("game_scene.fxml"));
                Parent gameSceneRoot = loader.load();

                // create a new scene by the root of the new scene
                Scene gameScene= new Scene(gameSceneRoot);

                // get the current window
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                // set new scene as current
                stage.setScene(gameScene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
