package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class ItemPositionRequest extends Message {

    private int nItemToMove;

    public ItemPositionRequest(int nItemToMove) {
        super(MessageType.ITEM_POSITION_REQUEST);
        this.nItemToMove = nItemToMove;
    }

    public int getnItemToMove() {
        return nItemToMove;
    }
}
