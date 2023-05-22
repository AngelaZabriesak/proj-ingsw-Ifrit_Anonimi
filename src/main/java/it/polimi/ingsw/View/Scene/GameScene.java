package it.polimi.ingsw.View.Scene;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GameScene {

    @FXML
    private ImageView arrowCol0;

    @FXML
    private ImageView arrowCol1;

    @FXML
    private ImageView arrowCol2;

    @FXML
    private ImageView arrowCol3;

    @FXML
    private ImageView arrowCol4;

    @FXML
    private GridPane boardGrid;

    @FXML
    private ImageView boardImg;

    @FXML
    private TextField chatInserText;

    @FXML
    private Label chatLabel;

    @FXML
    private HBox commonGoalBoxDx;

    @FXML
    private HBox commonGoalBoxSx;

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
    private VBox personalGolBox;

    @FXML
    private StackPane gamePane;

    @FXML
    private ImageView uselessArrow;

}