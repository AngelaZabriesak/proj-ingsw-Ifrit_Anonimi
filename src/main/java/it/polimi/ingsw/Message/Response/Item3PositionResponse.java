package it.polimi.ingsw.Message.Response;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Position;

public class Item3PositionResponse extends Message {

    private Position p1,p2,p3;
    private int row,col;

    public Item3PositionResponse(Position p1, Position p2, Position p3) {
        super(MessageType.ITEM_3POSITION_RESPONSE);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public int getCol() {
        setCol(p3.getCol());
        return col;
    }

    private void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        setRow(p3.getRow());
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

    public Position getP3() {
        return p3;
    }
}
