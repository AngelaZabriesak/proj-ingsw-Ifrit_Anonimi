package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Observer.InputObservable;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

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
        String defaultAddress = "127.0.0.1";
        if(nicknameField!=null){
            defaultAddress = nicknameField.getText();
        }
        loginButton.setDisable(true);

        String finalDefaultAddress = defaultAddress;
        new Thread(() -> notifyInObserver(obs -> obs.onUpdateServerInfo(finalDefaultAddress, 16847))).start();
        ChangeScene.changeRootPane(observers, event, "select_np_scene.fxml");
    }

}


