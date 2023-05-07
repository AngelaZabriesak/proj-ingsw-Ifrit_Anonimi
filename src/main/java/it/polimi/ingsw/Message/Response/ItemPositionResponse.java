package it.polimi.ingsw.Message.Response;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.*;

public class ItemPositionResponse extends Message {
    private int row,col;
    private Position position;
    public ItemPositionResponse(Position position) {
        super(MessageType.ITEM_POSITION_RESPONSE);
        this.position = position;
    }

    public int getCol() {
        setCol(position.getCol());
        return col;
    }

    private void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        setRow(position.getRow());
        return row;
    }

    private void setRow(int row) {
        this.row = row;
    }
}
