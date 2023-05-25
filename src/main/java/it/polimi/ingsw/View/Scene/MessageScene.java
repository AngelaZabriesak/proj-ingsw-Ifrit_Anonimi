package it.polimi.ingsw.View.Scene;


import it.polimi.ingsw.Observer.InputObservable;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class MessageScene extends InputObservable implements GenericScene {
    private final Stage stage;
    @FXML
    private AnchorPane pane;
    @FXML
    private StackPane rootPane;
    @FXML
    private Label messageLbl;
    @FXML
    private Button okBtn;

    /**
     * Default constructor.
     */
    public MessageScene() {
        stage = new Stage();
        stage.initOwner(ChangeScene.getActiveScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);
    }

    @FXML
    public void initialize() {
        okBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onOkBtnClick);
    }

    /**
     * Handles the click on the Ok button.
     * An alert message will be shown.
     *
     * @param event the mouse click event.
     */
    private void onOkBtnClick(MouseEvent event) {
        stage.close();
    }

    /**
     * Sets the message of the Alert Scene.
     *
     * @param str message of the Alert Scene.
     */
    public void setAlertMessage(String str) {
        messageLbl.setText(str);
    }

    /**
     * Displays Alert Message Pop-Up
     */
    public void displayAlert() {
        stage.showAndWait();
    }

    /**
     * Sets the scene of the stage.
     *
     * @param scene the scene to be set.
     */
    public void setScene(Scene scene) {
        stage.setScene(scene);
    }

}