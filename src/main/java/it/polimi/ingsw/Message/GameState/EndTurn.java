package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class EndTurn extends Message {
    public EndTurn() {
        super(MessageType.END_TURN);
    }
}
