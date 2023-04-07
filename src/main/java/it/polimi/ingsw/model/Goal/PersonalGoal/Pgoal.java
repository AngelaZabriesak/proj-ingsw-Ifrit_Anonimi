package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.model.Game.*;
import it.polimi.ingsw.model.Goal.*;

import java.util.*;

public abstract class Pgoal extends Goal {
    private Game game;

    public Pgoal(){}

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    private int[] scores = {0,2,4,6,9,12};

}
