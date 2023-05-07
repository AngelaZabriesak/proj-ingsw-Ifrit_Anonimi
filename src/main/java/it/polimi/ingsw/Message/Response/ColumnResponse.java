package it.polimi.ingsw.Message.Response;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class ColumnResponse extends Message {

    private int column;

    public ColumnResponse(int column) {
        super(MessageType.COLUMN_RESPONSE);
        this.column = column;
    }

    public int getColumn(){
        return column;
    }
}
