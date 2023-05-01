package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class ItemPositionRequest extends Message {
    public ItemPositionRequest() {
        super(MessageType.ITEM_POSITION);
    }
}
