package it.polimi.ingsw.Model.Goal.PersonalGoal;

import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.Goal.*;

import java.io.Serializable;

public abstract class Pgoal extends Goal implements Serializable {
    private Game game;
    final int[] scores = {1,2,4,6,9,12};

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public int[] getScores(){
        return scores;
    }

    public abstract Item[][] getGoal();
}
