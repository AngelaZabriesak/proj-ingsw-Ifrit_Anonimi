package it.polimi.ingsw.Message.Response;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Position;

public class Item2PositionResponse extends Message {
    private Position p1,p2;
    private int row,col;

    public Item2PositionResponse(Position p1, Position p2) {
        super(MessageType.ITEM_2POSITION_RESPONSE);
        this.p1 = p1;
        this.p2 = p2;
    }

    public int getCol() {
        setCol(p2.getCol());
        return col;
    }

    private void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        setRow(p2.getRow());
        return row;
    }

    private void setRow(int row) {
        this.row = row;
    }

    public Position getP1() {
        return p1;
    }

    public Position getP2() {
        return p2;
    }
}
