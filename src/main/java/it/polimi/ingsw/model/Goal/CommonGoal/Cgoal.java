package it.polimi.ingsw.Model.Goal.CommonGoal;

import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.Goal.*;
import it.polimi.ingsw.Model.*;

import java.io.Serializable;
import java.util.*;

/**
 *
 * class that define the CGoal
 *
 */

public abstract class Cgoal extends Goal implements Serializable {
    private int index;
    private Game game;

    public ArrayList<Token> tokens = new ArrayList<>();

    public Cgoal(){}

    public void setIndex(int index) {
        this.index = index;
    }

    /**
     *
     * @return the cGoal index
     *
     */

    public int getIndex() {return this.index;}

    public void setGame(Game game) {
        this.game = game;
    }

    /**
     *
     * @return the game
     *
     */

    public Game getGame() {
        return game;
    }
    
    public void setToken(ArrayList<Token> tokens){
        this.tokens = tokens;
    }

    /**
     *
     * @return the player tokens
     *
     */

    public ArrayList<Token> getMyTokens(){
        return tokens;
    }

    public abstract Token getToken();

    public Item[][] getGoal(){
        return null;
    }

    public abstract boolean isTaken(Shelf myShelf);

}
