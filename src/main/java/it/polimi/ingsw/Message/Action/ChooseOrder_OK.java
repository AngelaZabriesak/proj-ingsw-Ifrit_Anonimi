package it.polimi.ingsw.Message.Action;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Model.Bag.*;

import java.util.*;

public class ChooseOrder_OK extends ActionMessage{

    private final ArrayList<Item> itemOrder;

    public ChooseOrder_OK(String description, ArrayList<Item> itemOrder) {
        super(description, MessageType.CHOOSEORDER_OK);
        this.itemOrder = itemOrder;
    }

    public ArrayList<Item> getItemOrder(){
        return itemOrder;
    }
}
