package it.polimi.ingsw.model.Game;

import it.polimi.ingsw.model.Bag.*;
import it.polimi.ingsw.model.Board;
import it.polimi.ingsw.model.CommonGoal.*;
import it.polimi.ingsw.model.Player;

import java.util.ArrayList;

public class Game {
    private static final int NGOAL = 2;
    private ArrayList<Player> players = new ArrayList<>();
    private Board myBoard;
    private Bag myBag;
    private Cgoal[] myGoal = new Cgoal[NGOAL];

    public Game(){
        myBoard = new Board();
        myBag = new Bag();
    }

    /**
     *  Fill the board and distributes the cards to the players
     */
    public void initialize(){

    }

    /**
     * define the order of players
     */
    public void orderPlayer(){

    }

    /**
     * manages the endgame by calculating each player's points
     */
    public void endGame(){

    }

    /**
     * fills the board with item by drawing them at random from the bag
     */
    public void fillBoard(){

    }

    /**
     * manage the action of the players
     */
    public void setAction(){

    }

    /**
     * calculate the score of each player for every turn
     */
    public void calcScore(){


        // do check_p_score later and delete the initialization of check_p_score
        // do the same with c_card_score1 and c_card_score_2 ( the c_card are assigned during the game)

        int check_p_score=0;
        int c_card_score1=0;
        int c_card_score2=0;
         int p_score;
         int myScore;




        int[] p_points = new int[7];
        p_points[0] = 0;
        p_points[1] = 1 ;
        p_points[2] = 2;
        p_points[3] = 4;
        p_points[4] = 6;
        p_points[5] = 9;
        p_points[6] = 12;

        p_score= p_points[check_p_score];

        myScore= p_score+c_card_score1+c_card_score2;











    }
}
