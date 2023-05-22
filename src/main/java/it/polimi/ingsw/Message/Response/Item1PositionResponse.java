package it.polimi.ingsw.Message.Response;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.*;

public class Item1PositionResponse extends Message {
    private int row,col;
    private final Position position;
    public Item1PositionResponse(Position position) {
        super(MessageType.ITEM_1POSITION_RESPONSE);
        this.position = position;
    }

    public Position getP(){
        return position;
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
