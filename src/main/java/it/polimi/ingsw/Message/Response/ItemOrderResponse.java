package it.polimi.ingsw.Message.Response;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Bag.*;

import java.util.*;

public class ItemOrderResponse extends Message {

    private ArrayList<Item> items;
    private String order;

    public ItemOrderResponse(String order, ArrayList<Item> items) {
        super(MessageType.ITEM_ORDER_RESPONSE);
        this.order = order;
        this.items=items;
    }

    public String getOrder() {
        return order;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
}
