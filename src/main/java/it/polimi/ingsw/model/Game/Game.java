package it.polimi.ingsw.model.Game;

import it.polimi.ingsw.Exception.WinException;
import it.polimi.ingsw.model.Bag.*;
import it.polimi.ingsw.model.CommonGoal.*;
import it.polimi.ingsw.model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Game {
    private static final int N_COMMON_GOAL = 2;
    private static final int N_GOAL = 12;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private ArrayList<Goal> personalGoal;
    private ArrayList<Goal> commonGoal;
    private Board myBoard;
    private Bag myBag;
    private ArrayList<Goal> myGoal = new ArrayList<>();

    public Game(ArrayList<Player> players){
        this.players = players;
        myBoard = new Board();
        myBag = new Bag();
        for(int i = 0; i<N_GOAL; i++) {
            Pgoal pg = new Pgoal();
            personalGoal.add(pg.CreatePgoal(i));
            //commonGoal.add(new CgoalFactory(i++));
        }
        for(int i = 0; i<N_COMMON_GOAL; i++)
            myGoal.add(getRandomGoal(commonGoal));
        orderPlayer();
    }

    /**
     *  Fill the board and distributes the cards to the players
     */
    public void initialize(){
        fillBoard();
        for(Player p : players){
            p.setMyGoal(getRandomGoal(personalGoal));
        }
    }

    /**
     * define the order of players
     */
    public void orderPlayer(){
        Collections.shuffle(players);
    }

    /**
     * manages the endgame by calculating each player's points
     */
    public void endGame(){
        for(Player p : players){
            if(p.getMyShelf().getNEmpty()==0){
                new WinException(p.getNickname());
            }
        }
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

    /**
     * @param myGoals is the array of goals enables (personal/common)
     * @return the random goal
     */
    public Goal getRandomGoal(ArrayList<Goal> myGoals){
        int pos = (int)Math.random()* myGoals.size();
        Goal myGoal = myGoals.get(pos);
        myGoals.remove(pos);
        return myGoal;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }
}
