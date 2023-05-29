package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.Goal.CommonGoal.Cgoal;
import it.polimi.ingsw.Model.Goal.PersonalGoal.Pgoal;

import java.util.ArrayList;

public class GameStart extends Message {

    private final ArrayList<Player> players;
    private final Pgoal pgoal;
    private final ArrayList<Cgoal> cgoals;

    public GameStart(ArrayList<Player> players, ArrayList<Cgoal> cgoals, Pgoal pgoal) {
        super(MessageType.START);
        this.players = players;
        this.pgoal = pgoal;
        this.cgoals = cgoals;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Pgoal getPgoal() {
        return pgoal;
    }

    public ArrayList<Cgoal> getCgoals() {
        return cgoals;
    }
}
