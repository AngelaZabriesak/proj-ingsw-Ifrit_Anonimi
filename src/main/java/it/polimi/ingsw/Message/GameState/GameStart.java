package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.Game.Board;
import it.polimi.ingsw.Model.Goal.CommonGoal.Cgoal;

import java.util.ArrayList;

public class GameStart extends Message {

    private ArrayList<Player> players;

    public GameStart(ArrayList<Player> players) {
        super(MessageType.START);
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
