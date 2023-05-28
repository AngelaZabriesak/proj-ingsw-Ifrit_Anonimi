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
        twoPlayerButton.setAccessibleText("2");
        threePlayerButton.setAccessibleText("3");
        fourPlayerButton.setAccessibleText("4");
        twoPlayerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onPlayButtonClick);
        threePlayerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onPlayButtonClick);
        fourPlayerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onPlayButtonClick);
    }

    private void onPlayButtonClick(MouseEvent event) {
        String btn = ((Button) event.getSource()).getAccessibleText();
        notifyInObserver(obs->obs.onUpdateNPlayers(btn));
    }

}
