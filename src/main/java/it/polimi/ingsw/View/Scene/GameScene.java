package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Model.Bag.Item;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.Random;


public class GameScene extends InputObservable implements GenericScene {

    @FXML
    private Button arrowCol0;

    @FXML
    private Button arrowCol1;

    @FXML
    private Button arrowCol2;

    @FXML
    private Button arrowCol3;

    @FXML
    private Button arrowCol4;



    @FXML
    private GridPane boardGrid;

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
    public GameScene() {
        //btnItem = new Button();
    }

/*
    Image azure1 = new Image("../images/items/azureitem1.png");
    Image azure2 = new Image("../images/items/azureitem2.png");
    Image azure3 = new Image("../images/items/azureitem3.png");
    Image blue1 = new Image("../images/items/blueitem1.png");
    Image blue2 = new Image("../images/items/blueitem2.png");
    Image blue3 = new Image("../images/items/blueitem3.png");
    Image green1 = new Image("../images/items/greenitem1.png");
    Image green2 = new Image("../images/items/greenitem2.png");
    Image green3 = new Image("../images/items/greenitem3.png");
    Image pink1 = new Image("../images/items/pinkitem1.png");
    Image pink2 = new Image("../images/items/pinkitem2.png");
    Image pink3 = new Image("../images/items/pinkitem3.png");
    Image white1 = new Image("images/items/whiteitem1.png");
    Image white2 = new Image("../images/items/whiteitem2.png");
    Image white3 = new Image("../images/items/whiteitem3.png");
    Image yellow1 = new Image("../images/items/yellowitem1.png");
    Image yellow2 = new Image("../images/items/yellowitem2.png");
    Image yellow3 = new Image("../images/items/yellowitem3.png");
<<<<<<< HEAD




 */
    
    public  void setBoardGrid(Board board) {

        /*

            boardGrid.getChildren().clear(); // Rimuovi le celle esistenti

            for (int r = -1; r < 9; r++) {
                for (int c = -1; c < 9; c++) {
                    Node cell;
                    if (r == -1 && c == -1) {
                        cell = createCell("R\\C", null); // Cellula dell'intestazione
                    } else if (r == -1) {
                        cell = createCell(String.valueOf(c), null); // Cellula di intestazione della colonna
                    } else if (c == -1) {
                        cell = createCell(String.valueOf(r), null); // Cellula di intestazione della riga
                    } else {
                        Position position = new Position(r, c);
                        Item boardItem = board.getItem(position);
                        Image image = null;
                        if (boardItem != null) {
                            image = getImageForColor(boardItem.getColor()); // Ottieni l'immagine in base al colore
                        }
                        cell = createCell(null, image); // Cellula con immagine
                    }

                    GridPane.setRowIndex(cell, r + 1);
                    GridPane.setColumnIndex(cell, c + 1);

                    boardGrid.getChildren().add(cell);
                }
            }
        }

        private Node createCell(String text, Image image) {
            if (image != null) {
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(43);
                imageView.setFitHeight(43);
                imageView.setPreserveRatio(true);
                imageView.setSmooth(true);
                imageView.setCache(true);
                return imageView;
            } else {
                Label label = new Label(text);
                label.setStyle("-fx-border-color: black;");
                label.setPrefSize(43, 43);
                label.setAlignment(Pos.CENTER);
                return label;
            }
        }



        private Image getImageForColor(ColorItem color) {
            // Restituisci l'immagine corrispondente in base al colore
            // Esempio:
            Random random = new Random();
            int randomNumber = random.nextInt(3); // Genera un numero casuale tra 0 e 2


            if (color == ColorItem.AZURE) {
                if (randomNumber == 0) {
                    return azure1;
                }
                if (randomNumber == 1) {
                    return azure2;
                }
                return azure3;
            }

            if (color == ColorItem.BLUE) {
                if (randomNumber == 0) {
                    return blue1;
                }
                if (randomNumber == 1) {
                    return blue2;
                }
                return blue3;
            }
            if (color == ColorItem.GREEN) {
                if (randomNumber == 0) {
                    return green1;
                }
                if (randomNumber == 1) {
                    return green2;
                }
                return green3;
            }

            if (color == ColorItem.PINK) {
                if (randomNumber == 0) {
                    return pink1;
                }
                if (randomNumber == 1) {
                    return pink2;
                }
                return pink3;
            }

            if (color == ColorItem.WHITE) {
                if (randomNumber == 0) {
                    return white1;
                }
                if (randomNumber == 1) {
                    return white2;
                }
                return white3;
            }


            if (color == ColorItem.YELLOW) {
                if (randomNumber == 0) {
                    return yellow1;
                }
                if (randomNumber == 1) {
                    return yellow2;
                }
                return yellow3;
            }

            return null;


        }




        for(int r = 0; r<board.getRow(); r++){
            for(int c =0; c< board.getCol(); c++){
                if(board.getMyBoardItem()[r][c]!=null){
                    if(!board.getMyBoardItem()[r][c].getColor().equals(ColorItem.X)) {
                        btnItem.setStyle(
                                "-fx-background-image: url('images/items/azureitem1.png');\n" +
                                        "-fx-background-size: stretch;");
                        boardGrid.add(btnItem, r, c);
                    }
                }
            }
        */
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








