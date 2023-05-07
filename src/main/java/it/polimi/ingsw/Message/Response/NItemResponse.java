package it.polimi.ingsw.Message.Response;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class NItemResponse extends Message {

    private int nItem;

    public NItemResponse(int nItem) {
        super(MessageType.N_ITEM_RESPONSE);
        this.nItem = nItem;
    }

    public int getnItem() {
        return nItem;
    }
}
