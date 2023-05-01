package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;

public class ShelfRequest extends Message {

    public ShelfRequest() {
        super(MessageType.SHELF);
    }
}
