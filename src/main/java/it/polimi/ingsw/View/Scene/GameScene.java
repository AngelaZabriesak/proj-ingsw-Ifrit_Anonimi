package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Message.Response.Item1PositionResponse;
import it.polimi.ingsw.Message.Response.Item2PositionResponse;
import it.polimi.ingsw.Message.Response.Item3PositionResponse;
import it.polimi.ingsw.Model.Goal.CommonGoal.Cgoal;
import it.polimi.ingsw.Model.Goal.PersonalGoal.Pgoal;
import it.polimi.ingsw.Model.Bag.ColorItem;
import it.polimi.ingsw.Model.Game.Board;
import it.polimi.ingsw.Model.Goal.Goal;
import it.polimi.ingsw.Model.Position;
import it.polimi.ingsw.Observer.InputObservable;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.Random;


public class GameScene extends InputObservable implements GenericScene {

    // frecce sulle colonne
    @FXML
    private Button arrowCol0, arrowCol1, arrowCol2, arrowCol3, arrowCol4;

    //btn board
    @FXML
    private static Button myButtonItem_0_3, myButtonItem_0_4, myButtonItem_1_3, myButtonItem_1_4, myButtonItem_1_5, myButtonItem_2_2, myButtonItem_2_3, myButtonItem_2_4, myButtonItem_2_5, myButtonItem_2_6, myButtonItem_3_1, myButtonItem_3_2, myButtonItem_3_3, myButtonItem_3_4, myButtonItem_3_5, myButtonItem_3_6, myButtonItem_3_7, myButtonItem_3_8, myButtonItem_3_9, myButtonItem_4_0, myButtonItem_4_1, myButtonItem_4_2, myButtonItem_4_3, myButtonItem_4_4, myButtonItem_4_5, myButtonItem_4_6, myButtonItem_4_7, myButtonItem_4_8, myButtonItem_5_0, myButtonItem_5_1, myButtonItem_5_2, myButtonItem_5_3, myButtonItem_5_4, myButtonItem_5_5, myButtonItem_5_6, myButtonItem_5_7, myButtonItem_6_2, myButtonItem_6_3, myButtonItem_6_4, myButtonItem_6_5, myButtonItem_6_6, myButtonItem_7_3, myButtonItem_7_4, myButtonItem_7_5, myButtonItem_8_4, myButtonItem_8_5;

    private static Button[][] myBoard;

    @FXML
    private static GridPane boardGrid;

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

    //goals
    @FXML
    private ImageView personalGoal, commonGoalDx, commonGoalSx;

    @FXML
    private StackPane gamePane;

    @FXML
    private ImageView uselessArrow;

    /**
     * Default constructor.
     */
    public GameScene() {
        //btnItem = new Button();
    }


    Image azure1 = new Image("../images/items/azureitem1.png");
    Image blue2 = new Image("../images/items/blueitem2.png");
    Image green3 = new Image("../images/items/greenitem3.png");
    Image pink1 = new Image("../images/items/pinkitem1.png");
    Image white2 = new Image("../images/items/whiteitem2.png");
    Image yellow3 = new Image("../images/items/yellowitem3.png");












    public  void setBoardGrid(Board board) {

        /*funzione che scorre le ImageView della greed

    }

                        image = getImageForColor(boardItem.getColor()); // Ottieni l'immagine in base al colore

        }


       //
        private Image getImageForColor( Item item){

    ColorItem color= ColorItem.getColor();


            if (color == ColorItem.AZURE) {
                    return azure1;
            }

            if (color == ColorItem.BLUE) {
                return blue2;
            }

            if (color == ColorItem.GREEN) {
                return green3;
            }

            if (color == ColorItem.PINK) {
                return pink1;

            }

            if (color == ColorItem.WHITE) {
                return white2;
            }

            if (color == ColorItem.YELLOW) {
                return yellow3;
            }

            return null;


        }




        for(int r = 0; r<board.getRow(); r++){
            for(int c =0; c< board.getCol(); c++){
=======
    public static void setBoardGrid(Board board){
        myBoard =new Button[board.getRow()][board.getCol()];
        boardGrid = new GridPane();
        int i =0;
        for(int r =0;r< board.getRow(); r++){
            for(int c=0; c< board.getCol(); c++){
>>>>>>> Stashed changes
                if(board.getMyBoardItem()[r][c]!=null){
                    if(!board.getMyBoardItem()[r][c].getColor().equals(ColorItem.X)){
                        myBoard[r][c] = new Button(board.getMyBoardItem()[r][c].getColor()+" "+i%3);
                        boardGrid.add(myBoard[r][c],r,c);
                        i++;
                    }
                }
            }
<<<<<<< Updated upstream
        */
        }

    @FXML
    public void initialize() {
        boardGrid.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onSpaceClick);
    }


    private void onSpaceClick(MouseEvent event) {
        Node clickedNode = event.getPickResult().getIntersectedNode();
        Integer row = GridPane.getRowIndex(clickedNode);
        Integer col = GridPane.getColumnIndex(clickedNode);
        Position p = new Position(row,col);

        /*if(p1==null)
            notifyInObserver(obs -> obs.onUpdateChooseItem(new Item1PositionResponse(p)));
        else if (p2==null)
            notifyInObserver(obs -> obs.onUpdateChooseItem(new Item2PositionResponse(p1,p)));
        else
            notifyInObserver(obs -> obs.onUpdateChooseItem(new Item3PositionResponse(p1,p2,p)));*/
        System.out.println("row: "+p.getRow()+" col: "+p.getCol());
    }

    /**
     * Handles the click on the Ok button.
     * An alert message will be shown.
     *
     * @param event the mouse click event.
     */
    private void onOkBtnClick(MouseEvent event) {
    }

    /**
     * Sets the message of the Alert Scene.
     *
     * @param str message of the Alert Scene.
     */
    public void setAlertMessage(String str) {
    }

    /**
     * Displays Alert Message Pop-Up
     */
    public void displayAlert() {
    }

    /**
     * Sets the scene of the stage.
     *
     * @param scene the scene to be set.
     */
    public void setScene(Scene scene) {
    }



    private ArrayList<Cgoal> cGoals;
    private ArrayList<Pgoal> pGoal;

    public void setGuiCGoals(ArrayList<Cgoal> myGoals){
        this.cGoals=myGoals;}

    public void setGuiPGoal(ArrayList<Pgoal> myGoals){
        this.pGoal=myGoals;}



    public void fillGuiBoard() {

        /*
            int numRows = 9;
            int numCols = 9;

            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++) {
                    Image item = new Image("path/to/your/image.png");
                    ImageView imageView = new ImageView(item);
                    imageView.setFitWidth(43); // Imposta la larghezza dell'ImageView
                    imageView.setFitHeight(43); // Imposta l'altezza dell'ImageView

                    boardGrid.setMargin(imageView, new Insets(0.5)); // Imposta i margini dell'ImageView

                    boardGrid.add(imageView, col, row);
                }
            }


         */

    }


        @FXML
        public void showCGoal() {


            Image cGoal0 = new Image("../images/commongoals/commongoal0.jpg");
            Image cGoal1 = new Image("..images/commongoals/commongoal1.jpg");
            Image cGoal2 = new Image("..images/commongoals/commongoal2.jpg");
            Image cGoal3 = new Image("..images/commongoals/commongoal3.jpg");
            Image cGoal4 = new Image("..images/commongoals/commongoal4.jpg");
            Image cGoal5 = new Image("..images/commongoals/commongoal5.jpg");
            Image cGoal6 = new Image("..images/commongoals/commongoal6.jpg");
            Image cGoal7 = new Image("..images/commongoals/commongoal7.jpg");
            Image cGoal8 = new Image("..images/commongoals/commongoal8.jpg");
            Image cGoal9 = new Image("..images/commongoals/commongoal9.jpg");
            Image cGoal10 = new Image("..images/commongoals/commongoal10.jpg");
            Image cGoal11 = new Image("..images/commongoals/commongoal11.jpg");


            // set dx  CGoal image
            if (cGoals.get(0).getIndex()==0) {
                commonGoalDx.setImage(cGoal0);
            }
            if ( cGoals.get(0).getIndex()==1) {
                commonGoalDx.setImage(cGoal1);
            }
            if (cGoals.get(0).getIndex()==2) {
                commonGoalDx.setImage(cGoal2);
            }
            if (cGoals.get(0).getIndex()==3) {
                commonGoalDx.setImage(cGoal3);
            }
            if (cGoals.get(0).getIndex()==4) {
                commonGoalDx.setImage(cGoal4);
            }
            if (cGoals.get(0).getIndex()==5) {
                commonGoalDx.setImage(cGoal5);
            }
            if (cGoals.get(0).getIndex()==6) {
                commonGoalDx.setImage(cGoal6);
            }
            if (cGoals.get(0).getIndex()==7) {
                commonGoalDx.setImage(cGoal7);
            }
            if (cGoals.get(0).getIndex()==8) {
                commonGoalDx.setImage(cGoal8);
            }
            if (cGoals.get(0).getIndex()==9) {
                commonGoalDx.setImage(cGoal9);
            }
            if (cGoals.get(0).getIndex()==10) {
                commonGoalDx.setImage(cGoal10);
            }
            if (cGoals.get(0).getIndex()==11) {
                commonGoalDx.setImage(cGoal11);
            }


            // set sx CGoal image
            if (cGoals.get(1).getIndex()==0) {
                commonGoalSx.setImage(cGoal0);
            }
            if (cGoals.get(1).getIndex()==1) {
                commonGoalSx.setImage(cGoal1);
            }
            if (cGoals.get(1).getIndex()==2) {
                commonGoalSx.setImage(cGoal2);
            }
            if (cGoals.get(1).getIndex()==3) {
                commonGoalSx.setImage(cGoal3);
            }
            if (cGoals.get(1).getIndex()==4) {
                commonGoalSx.setImage(cGoal4);
            }
            if (cGoals.get(1).getIndex()==5) {
                commonGoalSx.setImage(cGoal5);
            }
            if (cGoals.get(1).getIndex()==6) {
                commonGoalSx.setImage(cGoal6);
            }
            if (cGoals.get(1).getIndex()==7) {
                commonGoalSx.setImage(cGoal7);
            }
            if (cGoals.get(1).getIndex()==8) {
                commonGoalSx.setImage(cGoal8);
            }
            if (cGoals.get(1).getIndex()==9) {
                commonGoalSx.setImage(cGoal9);
            }
            if (cGoals.get(1).getIndex()==10) {
                commonGoalSx.setImage(cGoal10);
            }
            if (cGoals.get(1).getIndex()==11) {
                commonGoalSx.setImage(cGoal11);
            }

    }


        public void showPGoal(){

        Image pGoal0=new Image("../images/personalgoals/personalgoal0.jpg");
        Image pGoal1=new Image("../images/personalgoals/personalgoal1.jpg");
        Image pGoal2=new Image("../images/personalgoals/personalgoal2.jpg");
        Image pGoal3=new Image("../images/personalgoals/personalgoal3.jpg");
        Image pGoal4=new Image("../images/personalgoals/personalgoal4.jpg");
        Image pGoal5=new Image("../images/personalgoals/personalgoal5.jpg");
        Image pGoal6=new Image("../images/personalgoals/personalgoal6.jpg");
        Image pGoal7=new Image("../images/personalgoals/personalgoal7.jpg");
        Image pGoal8=new Image("../images/personalgoals/personalgoal8.jpg");
        Image pGoal9=new Image("../images/personalgoals/personalgoal9.jpg");
        Image pGoal10=new Image("../images/personalgoals/personalgoal10.jpg");
        Image pGoal11=new Image("../images/personalgoals/personalgoal11.jpg");


        // SET PGoal image

        if(pGoal.get(0).getIndex()==0){
        personalGoal.setImage(pGoal0);
        }
        if(pGoal.get(0).getIndex()==1){
        personalGoal.setImage(pGoal1);
        }
        if(pGoal.get(0).getIndex()==2){
        personalGoal.setImage(pGoal2);
        }
        if(pGoal.get(0).getIndex()==3){
        personalGoal.setImage(pGoal3);
        }
        if(pGoal.get(0).getIndex()==4){
        personalGoal.setImage(pGoal4);
        }
        if(pGoal.get(0).getIndex()==5){
        personalGoal.setImage(pGoal5);
        }
        if(pGoal.get(0).getIndex()==6){
        personalGoal.setImage(pGoal6);
        }
        if(pGoal.get(0).getIndex()==7){
        personalGoal.setImage(pGoal7);
        }
        if(pGoal.get(0).getIndex()==8){
        personalGoal.setImage(pGoal8);
        }
        if(pGoal.get(0).getIndex()==9){
        personalGoal.setImage(pGoal9);
        }
        if(pGoal.get(0).getIndex()==10){
        personalGoal.setImage(pGoal10);
        }
        if(pGoal.get(0).getIndex()==11){
        personalGoal.setImage(pGoal11);
        }

        }
}








