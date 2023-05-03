package it.polimi.ingsw.Model.Goal.CommonGoal;

import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.Goal.*;
import it.polimi.ingsw.Model.*;

import java.util.*;

public abstract class Cgoal extends Goal {
    private int index;
    private Game game;

    public ArrayList<Token> tokens = new ArrayList<>();

    public Cgoal(){}

    public void setIndex(int index) {
        this.index = index;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
    
    public void setToken(ArrayList<Token> tokens){
        this.tokens =tokens;
    }

    public ArrayList<Token> getMyTokens(){
        return tokens;
    }

    public abstract Token getToken();

    public Item[][] getGoal(){
        return null;
    }

    public abstract boolean isTaken(Shelf myShelf);

}
