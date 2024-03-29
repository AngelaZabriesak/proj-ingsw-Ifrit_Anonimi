package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Game.Board;
import it.polimi.ingsw.Model.Position;

import java.util.ArrayList;

public class Item2PositionRequest extends Message {

    private final Board board;
    private final Position p1;
    private final ArrayList<Position> positionAvailable;
    private final String error;

    public Item2PositionRequest(Board board,String error,Position p1,ArrayList<Position> positionAvailable) {
        super(MessageType.ITEM_2POSITION_REQUEST);
        this.p1 = p1;
        this.positionAvailable = positionAvailable;
        this.error = error;
        this.board=board;
    }

    public Board getBoard(){
        return board;
    }

    public Position getP1() {
        return p1;
    }

    public ArrayList<Position> getPositionAvailable(){
        return positionAvailable;
    }

    public String getError(){
        return error;
    }
}
