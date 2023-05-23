package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Observer.InputObservable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class SelectNpScene extends InputObservable implements GenericScene {

    @FXML
    private Button fourPlayerButton;
    @FXML
    private Button threePlayerButton;
    @FXML
    private Button twoPlayerButton;
    @FXML
    private AnchorPane selectNpPane;
    @FXML
    private Label textLabel;

    @FXML

    public void initialize() {
        twoPlayerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onPlayButtonClick);
        threePlayerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onPlayButtonClick);
        fourPlayerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onPlayButtonClick);
    }

    private void onPlayButtonClick(MouseEvent event) {
        System.out.println(event.getPickResult().getIntersectedNode().toString());
        if(event.getButton().toString().equals("twoPlayerButton"))
            notifyInObserver(obs->obs.onUpdateNPlayers("2"));
        //ChangeScene.changeRootPane(observers, event, "game_scene.fxml");

    }

}
