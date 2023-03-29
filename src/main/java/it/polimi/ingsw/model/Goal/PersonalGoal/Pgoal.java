package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.model.Game.*;
import it.polimi.ingsw.model.Goal.*;

import java.util.*;

public abstract class Pgoal extends Goal {
    private int index;
    private Game game;
    private boolean used;

    public Pgoal(){
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

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

}
