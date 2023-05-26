package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Observer.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.*;

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
    private static GridPane boardGrid = new GridPane();
    @FXML
    private static ImageView IW_0_3;

    @FXML
    private static ImageView IW_0_4;

    @FXML
    private static ImageView IW_1_3;

    @FXML
    private static ImageView IW_1_4;

    @FXML
    private static ImageView IW_1_5;

    @FXML
    private static ImageView IW_2_2;

    @FXML
    private static ImageView IW_2_3;

    @FXML
    private static ImageView IW_2_4;

    @FXML
    private static ImageView IW_2_5;

    @FXML
    private static ImageView IW_2_6;

    @FXML
    private static ImageView IW_3_1;

    @FXML
    private static ImageView IW_3_2;

    @FXML
    private static ImageView IW_3_3;

    @FXML
    private static ImageView IW_3_4;

    @FXML
    private static ImageView IW_3_5;

    @FXML
    private static ImageView IW_3_6;

    @FXML
    private static ImageView IW_3_7;

    @FXML
    private static ImageView IW_3_8;

    @FXML
    private static ImageView IW_4_0;

    @FXML
    private static ImageView IW_4_1;

    @FXML
    private static ImageView IW_4_2;

    @FXML
    private static ImageView IW_4_3;

    @FXML
    private static ImageView IW_4_4;

    @FXML
    private static ImageView IW_4_5;

    @FXML
    private static ImageView IW_4_6;

    @FXML
    private static ImageView IW_4_7;

    @FXML
    private static ImageView IW_4_8;

    @FXML
    private static ImageView IW_5_0;

    @FXML
    private static ImageView IW_5_1;

    @FXML
    private static ImageView IW_5_2;

    @FXML
    private static ImageView IW_5_3;

    @FXML
    private static ImageView IW_5_4;

    @FXML
    private static ImageView IW_5_5;

    @FXML
    private static ImageView IW_5_6;

    @FXML
    private static ImageView IW_5_7;

    @FXML
    private static ImageView IW_6_2;

    @FXML
    private static ImageView IW_6_3;

    @FXML
    private static ImageView IW_6_4;

    @FXML
    private static ImageView IW_6_5;

    @FXML
    private static ImageView IW_6_6;

    @FXML
    private static ImageView IW_7_3;

    @FXML
    private static ImageView IW_7_4;

    @FXML
    private static ImageView IW_7_5;

    @FXML
    private static ImageView IW_8_4;

    @FXML
    private static ImageView IW_8_5;

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
    private static ImageView getNodeByIndex(GridPane grid,int r,int c){
        ImageView result;
        ObservableList<Node> children = grid.getChildren();

        for(Node node : children) {
            Integer col = GridPane.getColumnIndex(node);
            Integer row = GridPane.getRowIndex(node);
            if (col != null && row != null && col == c && row == r) {
                    return (ImageView)node;
            }
        }
        return null;
    }

    private static void addChildren(GridPane grid){
        grid.getChildren().add(IW_0_3);
        grid.getChildren().add(IW_0_4);
        grid.getChildren().add(IW_1_3);
        grid.getChildren().add(IW_1_4);
        grid.getChildren().add(IW_1_5);
        grid.getChildren().add(IW_2_2);
        grid.getChildren().add(IW_2_3);
        grid.getChildren().add(IW_2_4);
        grid.getChildren().add(IW_2_5);
        grid.getChildren().add(IW_2_6);
        grid.getChildren().add(IW_3_1);
        grid.getChildren().add(IW_3_2);
        grid.getChildren().add(IW_3_3);
        grid.getChildren().add(IW_3_4);
        grid.getChildren().add(IW_3_5);
        grid.getChildren().add(IW_3_6);
        grid.getChildren().add(IW_3_7);
        grid.getChildren().add(IW_3_8);
        grid.getChildren().add(IW_4_0);
        grid.getChildren().add(IW_4_1);
        grid.getChildren().add(IW_4_2);
        grid.getChildren().add(IW_4_3);
        grid.getChildren().add(IW_4_4);
        grid.getChildren().add(IW_4_5);
        grid.getChildren().add(IW_4_6);
        grid.getChildren().add(IW_4_7);
        grid.getChildren().add(IW_4_8);
        grid.getChildren().add(IW_5_0);
        grid.getChildren().add(IW_5_1);
        grid.getChildren().add(IW_5_2);
        grid.getChildren().add(IW_5_3);
        grid.getChildren().add(IW_5_4);
        grid.getChildren().add(IW_5_5);
        grid.getChildren().add(IW_5_6);
        grid.getChildren().add(IW_5_7);
        grid.getChildren().add(IW_6_2);
        grid.getChildren().add(IW_6_3);
        grid.getChildren().add(IW_6_4);
        grid.getChildren().add(IW_6_5);
        grid.getChildren().add(IW_6_6);
        grid.getChildren().add(IW_7_3);
        grid.getChildren().add(IW_7_4);
        grid.getChildren().add(IW_7_5);
        grid.getChildren().add(IW_8_4);
        grid.getChildren().add(IW_8_5);
    }

    public static void setBoardGrid(Board board) {
        addChildren(boardGrid);
        Image image = null;
        for(int r=0;r<9;r++) {
            for (int c = 0; c < 9; c++) {
                if(board.getMyBoardItem()[r][c]!=null) {
                    if (!board.getMyBoardItem()[r][c].getColor().equals(ColorItem.X)) {
                        ImageView node = getNodeByIndex(boardGrid, r, c);
                        image = getImageForColor(board.getMyBoardItem()[r][c].getColor()); // Ottieni l'immagine in base al colore
                        node.setImage(image);
                        node.setStyle("-fx-background-size: stretch;");
                        boardGrid.add(node, r, c);
                    }
                }
            }
        }
    }

    private static Image getImageForColor(ColorItem color) {
        // Restituisci l'immagine corrispondente in base al colore

        if (color.equals(ColorItem.AZURE)) {
            return new Image("images/items/azureitem1.png");
        }
        if (color.equals( ColorItem.BLUE)) {
            return new Image("images/items/blueitem1.png");
        }

        if (color == ColorItem.GREEN) {
            return new Image("images/items/greenitem1.png");
        }

        if (color == ColorItem.PINK) {
            return new Image("images/items/pinkitem1.png");
        }

        if (color == ColorItem.WHITE) {
            return new Image("images/items/whiteitem1.png");
        }

        if (color == ColorItem.YELLOW) {
            return new Image("images/items/yellowitem1.png");
        }
        return null;
    }
    @FXML
    public void initialize() {

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