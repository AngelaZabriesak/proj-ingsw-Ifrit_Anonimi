package it.polimi.ingsw.Message.Response;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.*;

public class ShelfResponse extends Message {
    private final Shelf shelf;
    private final Player player;
    public ShelfResponse(Shelf shelf,Player player) {
        super(MessageType.SHELF_RESPONSE);
        this.shelf = shelf;
        this.player=player;
    }

    public Player getPlayer() {
        return player;
    }

    public Shelf getShelf(){
        return shelf;
    }
}
