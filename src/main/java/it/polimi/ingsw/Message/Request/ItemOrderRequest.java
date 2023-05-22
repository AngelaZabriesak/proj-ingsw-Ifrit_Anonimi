package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Shelf;

import java.util.ArrayList;

public class ItemOrderRequest extends Message {

    private final ArrayList<Item> items;
    private final String error;
    private final Shelf shelf;
    public ItemOrderRequest(String error,ArrayList<Item> items,Shelf shelf) {
        super(MessageType.ITEM_ORDER_REQUEST);
        this.items=items;
        this.error = error;
        this.shelf = shelf;
    }

    public ArrayList<Item> getItems(){
        return items;
    }
    public String getError(){
        return error;
    }
    public Shelf getShelf(){
        return shelf;
    }
}
