package it.polimi.ingsw.Message.Response;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class ColumnResponse extends Message {

    private final String column;

    public ColumnResponse(String column) {
        super(MessageType.COLUMN_RESPONSE);
        this.column = column;
    }

    public String getColumn(){
        return column;
    }
}
