package it.polimi.ingsw;

import java.util.ArrayList;

public class Game {
    private static final int NGOAL = 2;
    private ArrayList<Player> players = new ArrayList<>();
    private Board myBoard;
    private Bag myBag;
    //private CGoal[NGOAL] myGoal;

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

    }
}
