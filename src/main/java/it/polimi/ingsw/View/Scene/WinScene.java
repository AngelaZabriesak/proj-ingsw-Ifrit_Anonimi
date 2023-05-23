package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Observer.InputObservable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class WinScene extends InputObservable implements GenericScene {

    @FXML
    private Label endGameLabel;

    @FXML
    private Label endGameLabel2;

    @FXML
    private Label winnerLabel;

    @FXML
    private AnchorPane winPane;

}
