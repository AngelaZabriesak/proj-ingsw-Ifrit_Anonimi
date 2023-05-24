package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Model.Game.Game;
import it.polimi.ingsw.Observer.InputObservable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.stage.Stage;

public class GameScene extends InputObservable implements GenericScene {

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
    private TextField chatInsertText;

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







        /*   funzione che implementa la matrice gui

    public class BoardGui extends InputObservable{
        private int[][] boardGui;

        public BoardGui(int[][] boardGui){
            this.boardGui = boardGui;
        }



        public void start(Stage primaryStage){

            GridPane gridPane = new GridPane();

            for (int i=0; i<boardGui.length; i++){
                for (int j=0; j<boardGui[i].length; j++)  {
                    int value = boardGui[i][j];

                    Label label= new Label(Integer.toString(value));
                gridPane.add(label,j,i);

                }
            }

            altra prova


            public class GuiBoard extends Application {
        private int[][] guiBoard;

        private void fillGuiBoard() {

            guiBoard = fillBoard();
        }

        @Override
        public void start(Stage primaryStage){
            fillGuiBoard();

                }
    }





         */



