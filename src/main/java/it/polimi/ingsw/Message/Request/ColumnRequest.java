package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Model.Shelf;

import java.util.*;

public class ColumnRequest extends Message {

    private ArrayList<Item> itemOrdered;
    private Shelf shelf;

    public ColumnRequest(ArrayList<Item> itemOrdered,Shelf shelf){
        super(MessageType.COLUMN_REQUEST);
        this.itemOrdered = itemOrdered;
        this.shelf = shelf;
    }

    public ArrayList<Item> getItemOrdered() {
        return itemOrdered;
    }

    public Shelf getShelf(){
        return shelf;
    }
}
