package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Win extends Message {

    private ArrayList<Player> players;
    public Win(ArrayList<Player> players) {
        super(MessageType.WIN);
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
