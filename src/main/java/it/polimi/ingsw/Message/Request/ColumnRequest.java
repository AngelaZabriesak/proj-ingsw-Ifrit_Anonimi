package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Model.Shelf;

import java.util.*;

public class ColumnRequest extends Message {

    private final ArrayList<Item> itemOrdered;
    private final Shelf shelf;
    private final String error;

    public ColumnRequest(String error,ArrayList<Item> itemOrdered,Shelf shelf){
        super(MessageType.COLUMN_REQUEST);
        this.itemOrdered = itemOrdered;
        this.shelf = shelf;
        this.error = error;
    }

    public ArrayList<Item> getItemOrdered() {
        return itemOrdered;
    }

    public Shelf getShelf(){
        return shelf;
    }
    public String getError(){
        return error;
    }
}
