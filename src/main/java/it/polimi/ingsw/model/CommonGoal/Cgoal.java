package it.polimi.ingsw.model.CommonGoal;

import it.polimi.ingsw.Enumerations.ActionType;
import it.polimi.ingsw.Exception.ActionException;
import it.polimi.ingsw.model.Game.Game;
import it.polimi.ingsw.model.Goal;

import java.util.ArrayList;

public abstract class Cgoal extends Goal {
    private int index;
    private Game game;
    private String description;
    private final ArrayList<ActionType> usePhase;
    private ActionType endPhase;
    private boolean available;
    private boolean used;

    public Cgoal(){
        this.usePhase = new ArrayList<>();
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

    public void setDescription(String description){this.description=description;}

    public String getDescription() {
        return description;
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

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

}
