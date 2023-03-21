package it.polimi.ingsw;

import java.util.ArrayList;

public class Game {
    private static final int NGOAL = 2;
    private ArrayList<Player> players = new ArrayList<>();
    private Board myBoard;
    //private CGoal[NGOAL] myGoal;

    public Game(){
        myBoard = new Board();
    }

    /**
     *  Fill the board and prepare the players
     */
    public void initialize(){

    }
}
