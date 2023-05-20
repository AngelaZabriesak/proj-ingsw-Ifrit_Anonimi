package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Player;

import java.util.*;

public class Win extends Message {

    private final ArrayList<Player> players;
    public Win(ArrayList<Player> players) {
        super(MessageType.WIN);
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
