package it.polimi.ingsw.Message;

import it.polimi.ingsw.Enumerations.MessageType;

public class Column extends Message{

    private int column;

    public Column(int column) {
        super(MessageType.COLUMN);
        this.column = column;
    }

    public int getColumn(){
        return column;
    }
}
