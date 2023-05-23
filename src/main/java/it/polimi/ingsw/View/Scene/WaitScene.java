package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Observer.InputObservable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class WaitScene extends InputObservable implements GenericScene {

    @FXML
    private StackPane waitSPane;

    @FXML
    private Label waitLabel;

    @FXML
    private AnchorPane waitPane;



}
