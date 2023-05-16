package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Bag.Item;

import java.util.ArrayList;

public class ItemOrderRequest extends Message {

    private final ArrayList<Item> items;
    private final String error;
    public ItemOrderRequest(String error,ArrayList<Item> items) {
        super(MessageType.ITEM_ORDER_REQUEST);
        this.items=items;
        this.error = error;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public String getError(){
        return error;
    }
}
