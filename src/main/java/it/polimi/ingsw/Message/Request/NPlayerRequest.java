package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class NPlayerRequest extends Message {
    public NPlayerRequest() {
        super(MessageType.N_PLAYER_REQUEST);
    }
}
