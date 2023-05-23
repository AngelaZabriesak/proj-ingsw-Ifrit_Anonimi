package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Observer.*;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class MenuScene extends InputObservable implements GenericScene {
    @FXML
    private Button exitButton;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button playButton;


    public void initialize() {
        playButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onPlayButtonClick);
        exitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> System.exit(0));
    }

    private void onPlayButtonClick(Event event) {
        ChangeScene.changeRootPane(observers, event, "select_ip_scene.fxml");
    }
}