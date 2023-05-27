package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Model.Position;
import it.polimi.ingsw.Observer.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameScene extends InputObservable implements GenericScene {

    @FXML
    private Button arrowCol0, arrowCol1;

    @FXML
    private Button arrowCol2;

    @FXML
    private Button arrowCol3;

    @FXML
    private Button arrowCol4;

    @FXML
    private ImageView boardImg;

    @FXML
    private TextField chatInsertText;

    @FXML
    private Label chatLabel;

    @FXML
    private GridPane itemOrderGrid;

    @FXML
    private ImageView itemOrderImg;

    @FXML
    private GridPane myShelfGrid;

    @FXML
    private ImageView myShelfImg;

    @FXML
    private AnchorPane pane;

    @FXML
    private Label personalGoalLabel;

    @FXML
    private ImageView personalGoal;

    @FXML
    private ImageView commonGoalDx;

    @FXML
    private ImageView commonGoalSx;

    @FXML
    private StackPane gamePane;

    @FXML
    private ImageView uselessArrow;

    /**
     * Default constructor.
     */
    public GameScene(Stage fullStage, Board board, ArrayList<Position> availablePositions){
        //fullStage.setScene(scene);
        // Ottieni le dimensioni dello schermo
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        // Imposta la posizione orizzontale sulla destra dello Stage
        double stageWidth = fullStage.getWidth();
        double stageX = screenBounds.getMaxX() - stageWidth;

        fullStage.setX(stageX);
        fullStage.show();
    }
    @FXML
    public void initialize() {
        //Application.launch(BoardScene.class);
    }

    /**
     * Handles the click on the Ok button.
     * An alert message will be shown.
     *
     * @param event the mouse click event.
     */
    private void onOkBtnClick(MouseEvent event) {
    }
}