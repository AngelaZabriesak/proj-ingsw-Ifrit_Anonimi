package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;

public class GameStart extends Message {
    public GameStart() {
        super(MessageType.START);
    }
}
