package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class NPlayer extends Message {

    private final String nPlayer;

    public NPlayer(String nPLayer) {
        super(MessageType.N_PLAYER_RESPONSE);
        this.nPlayer=nPLayer;
    }

    public String getnPlayer() {
        return nPlayer;
    }
}
