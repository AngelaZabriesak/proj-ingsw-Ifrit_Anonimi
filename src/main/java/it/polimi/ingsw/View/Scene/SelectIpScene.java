package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Observer.*;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class SelectIpScene extends InputObservable implements GenericScene {

    @FXML
    private TextField ipTextField;

    @FXML
    private Label label;

    @FXML
    private AnchorPane selectIpPane;

    @FXML
    private Button connectButton;


    public void initialize() {
        connectButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onConnectButtonClick);

    }


    private void onConnectButtonClick(Event event) {
        String defaultAddress = "127.0.0.1";
        if(ipTextField!=null){
            defaultAddress = ipTextField.getText();
        }


        connectButton.setDisable(true);

        String finalDefaultAddress = defaultAddress;
        new Thread(() -> notifyInObserver(obs -> obs.onUpdateServerInfo(finalDefaultAddress, 16847))).start();
        ChangeScene.changeRootPane(observers, event, "login_scene.fxml");
    }

}



















































      /*private void okButtonClick(Event event) {
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


      */