package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Model.Goal.Goal;
import it.polimi.ingsw.Observer.InputObservable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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


    public void setGoal() {


        Goal randomPGoal;
        Goal randomCGoalDx;
        Goal randomCGoalSx;


        Image pGoal0 = new Image("../images/personalgoals/personalgoal0.jpg");
        Image pGoal1 = new Image("../images/personalgoals/personalgoal1.jpg");
        Image pGoal2 = new Image("../images/personalgoals/personalgoal2.jpg");
        Image pGoal3 = new Image("../images/personalgoals/personalgoal3.jpg");
        Image pGoal4 = new Image("../images/personalgoals/personalgoal4.jpg");
        Image pGoal5 = new Image("../images/personalgoals/personalgoal5.jpg");
        Image pGoal6 = new Image("../images/personalgoals/personalgoal6.jpg");
        Image pGoal7 = new Image("../images/personalgoals/personalgoal7.jpg");
        Image pGoal8 = new Image("../images/personalgoals/personalgoal8.jpg");
        Image pGoal9 = new Image("../images/personalgoals/personalgoal9.jpg");
        Image pGoal10 = new Image("../images/personalgoals/personalgoal10.jpg");
        Image pGoal11 = new Image("../images/personalgoals/personalgoal11.jpg");


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


        // SET PGoal image

       /* if (randomPGoal == PersonalGoal0) {
            personalGoal.setImage(pGoal0);
        }
        if (randomPGoal == PersonalGoal1) {
            personalGoal.setImage(pGoal1);
        }
        if (randomPGoal == PersonalGoal2) {
            personalGoal.setImage(pGoal2);
        }
        if (randomPGoal == PersonalGoal3) {
            personalGoal.setImage(pGoal3);
        }
        if (randomPGoal == PersonalGoal4) {
            personalGoal.setImage(pGoal4);
        }
        if (randomPGoal == PersonalGoal5) {
            personalGoal.setImage(pGoal5);
        }
        if (randomPGoal == PersonalGoal6) {
            personalGoal.setImage(pGoal6);
        }
        if (randomPGoal == PersonalGoal7) {
            personalGoal.setImage(pGoal7);
        }
        if (randomPGoal == PersonalGoal8) {
            personalGoal.setImage(pGoal8);
        }
        if (randomPGoal == PersonalGoal9) {
            personalGoal.setImage(pGoal9);
        }
        if (randomPGoal == PersonalGoal10) {
            personalGoal.setImage(pGoal10);
        }
        if (randomPGoal == PersonalGoal11) {
            personalGoal.setImage(pGoal11);
        }


        // set dx  CGoal image
        if (randomCGoalDx == CommonGoal0) {
            commonGoalDx.setImage(cGoal0);
        }
        if (randomCGoalDx == CommonGoal1) {
            commonGoalDx.setImage(cGoal1);
        }
        if (randomCGoalDx == CommonGoal2) {
            commonGoalDx.setImage(cGoal2);
        }
        if (randomCGoalDx == CommonGoal3) {
            commonGoalDx.setImage(cGoal3);
        }
        if (randomCGoalDx == CommonGoal4) {
            commonGoalDx.setImage(cGoal4);
        }
        if (randomCGoalDx == CommonGoal5) {
            commonGoalDx.setImage(cGoal5);
        }
        if (randomCGoalDx == CommonGoal6) {
            commonGoalDx.setImage(cGoal6);
        }
        if (randomCGoalDx == CommonGoal7) {
            commonGoalDx.setImage(cGoal7);
        }
        if (randomCGoalDx == CommonGoal8) {
            commonGoalDx.setImage(cGoal8);
        }
        if (randomCGoalDx == CommonGoal9) {
            commonGoalDx.setImage(cGoal9);
        }
        if (randomCGoalDx == CommonGoal10) {
            commonGoalDx.setImage(cGoal10);
        }
        if (randomCGoalDx == CommonGoal11) {
            commonGoalDx.setImage(cGoal11);
        }


        // set sx CGoal image
        if (randomCGoalSx == CommonGoal0) {
            commonGoalSx.setImage(cGoal0);
        }
        if (randomCGoalSx == CommonGoal1) {
            commonGoalSx.setImage(cGoal1);
        }
        if (randomCGoalSx == CommonGoal2) {
            commonGoalSx.setImage(cGoal2);
        }
        if (randomCGoalSx == CommonGoal3) {
            commonGoalSx.setImage(cGoal3);
        }
        if (randomCGoalSx == CommonGoal4) {
            commonGoalSx.setImage(cGoal4);
        }
        if (randomCGoalSx == CommonGoal5) {
            commonGoalSx.setImage(cGoal5);
        }
        if (randomCGoalSx == CommonGoal6) {
            commonGoalSx.setImage(cGoal6);
        }
        if (randomCGoalSx == CommonGoal7) {
            commonGoalSx.setImage(cGoal7);
        }
        if (randomCGoalSx == CommonGoal8) {
            commonGoalSx.setImage(cGoal8);
        }
        if (randomCGoalSx == CommonGoal9) {
            commonGoalSx.setImage(cGoal9);
        }
        if (randomCGoalSx == CommonGoal10) {
            commonGoalSx.setImage(cGoal10);
        }
        if (randomCGoalSx == CommonGoal11) {
            commonGoalSx.setImage(cGoal11);
        }

        */
    }

}





