package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class EndGame extends Message {
    public EndGame() {
        super(MessageType.END);
    }
}
