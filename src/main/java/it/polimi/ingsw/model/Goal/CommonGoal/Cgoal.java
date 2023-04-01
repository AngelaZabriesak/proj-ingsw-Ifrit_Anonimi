package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Game.*;
import it.polimi.ingsw.model.Goal.*;
import it.polimi.ingsw.model.*;

import java.util.*;

public abstract class Cgoal extends Goal {
    private int index;
    private Game game;
    private boolean used;

    private ArrayList<Token> tokens = new ArrayList<Token>();

    public Cgoal(){
        this.used = false;
    }

    public int getIndex() {
        return index;
    }

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

    public Token getToken(){
        Token t = null;
        if(tokens.size()>0) {
            t = tokens.get(tokens.size() - 1);
            tokens.remove(tokens.size() - 1);
        }
        return t;
    }

}
