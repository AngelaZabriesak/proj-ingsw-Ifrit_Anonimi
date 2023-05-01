package it.polimi.ingsw.Message;

import it.polimi.ingsw.Enumerations.MessageType;

public class NItem extends Message{

    private int nItem;

    public NItem(int nItem) {
        super(MessageType.N_ITEM);
        this.nItem = nItem;
    }

    public int getnItem() {
        return nItem;
    }
}
