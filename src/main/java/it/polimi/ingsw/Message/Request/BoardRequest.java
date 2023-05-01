package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;

public class BoardRequest extends Message {

    public BoardRequest() {
        super(MessageType.BOARD);
    }
}
