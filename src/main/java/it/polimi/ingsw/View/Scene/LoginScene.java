package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Observer.InputObservable;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class LoginScene extends InputObservable implements GenericScene {
    @FXML
    private StackPane loginStackPane;

    @FXML
    private Button loginButton;

    @FXML
    private AnchorPane loginPane;

    @FXML
    private TextField nicknameField;

    @FXML
    private Label textLabel;

    @FXML

    public void initialize() {
        loginButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onPlayButtonClick);
    }

    private void onPlayButtonClick(Event event) {
        String nicknameFieldText = nicknameField.getText();
        loginButton.setDisable(true);
        notifyInObserver(obs -> obs.onUpdateNickname(nicknameFieldText));
        ChangeScene.changeRootPane(observers, event, "select_np_scene.fxml");
    }

}


