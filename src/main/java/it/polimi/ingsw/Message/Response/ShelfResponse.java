package it.polimi.ingsw.Message.Response;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.*;

public class ShelfResponse extends Message {
    private final Shelf shelf;
    public ShelfResponse(Shelf shelf) {
        super(MessageType.SHELF_RESPONSE);
        this.shelf = shelf;
    }

    public Shelf getShelf(){
        return shelf;
    }
}
