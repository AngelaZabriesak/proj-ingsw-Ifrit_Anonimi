package it.polimi.ingsw.Message.Action;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Model.Position;

public class ChooseItem_OK extends ActionMessage{
    private final Item item;
    private final int chosenRow,chosenCol;

    public ChooseItem_OK(String description,Item item,int chosenRow, int chosenCol) {
        super(description, MessageType.CHOOSEITEM_OK);
        this.item = item;
        this.chosenRow = chosenRow;
        this.chosenCol = chosenCol;
    }

    public Position getPosition(){
        return new Position(chosenRow,chosenCol);
    }

    public Item getItem(){
        return item;
    }
}
