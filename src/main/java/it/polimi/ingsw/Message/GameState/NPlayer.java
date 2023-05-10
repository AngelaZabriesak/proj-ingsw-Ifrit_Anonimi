package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class NPlayer extends Message {

    private String nPlayer;

    public NPlayer(String nPLayer) {
        super(MessageType.N_PLAYER_RESPONSE);
        this.nPlayer=nPLayer;
    }

    public int getnPlayer() {
        return Integer.parseInt(nPlayer);
    }
}
