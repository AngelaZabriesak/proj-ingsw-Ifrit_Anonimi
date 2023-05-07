package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Bag.Item;

import java.util.ArrayList;

public class ItemOrderRequest extends Message {

    ArrayList<Item> items;
    public ItemOrderRequest(ArrayList<Item> items) {
        super(MessageType.ITEM_ORDER_REQUEST);
        this.items=items;
    }

    public ArrayList<Item> getItems(){
        return items;
    }
}
