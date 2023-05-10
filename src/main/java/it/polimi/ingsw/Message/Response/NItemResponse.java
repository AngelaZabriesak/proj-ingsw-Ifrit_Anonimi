package it.polimi.ingsw.Message.Response;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class NItemResponse extends Message {

    private String nItem;

    public NItemResponse(String nItem) {
        super(MessageType.N_ITEM_RESPONSE);
        this.nItem = nItem;
    }

    public String getnItem() {
        return nItem;
    }
}
