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
/* @FXML


     comenti

   
        try {
            // push FXML file of new scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("select_ip_scene.fxml"));
            Parent ipSceneRoot = loader.load();

            // create a new scene by the root of the new scene
            Scene ipScene= new Scene(ipSceneRoot);

            // get the current window
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // set new scene as current
            stage.setScene(ipScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
<<<<<<< HEAD


}
=======
}
>>>>>>> 44f557f2011e4c0fa37a526ed980dce93ff92f97


*/