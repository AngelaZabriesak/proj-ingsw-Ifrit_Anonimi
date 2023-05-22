package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.*;

import java.util.ArrayList;

public class GameStart extends Message {

    private final ArrayList<Player> players;

    public GameStart(ArrayList<Player> players) {
        super(MessageType.START);
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
