package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class ItemOrderRequest extends Message {
    public ItemOrderRequest() {
        super(MessageType.ITEM_ORDER);
    }
}
