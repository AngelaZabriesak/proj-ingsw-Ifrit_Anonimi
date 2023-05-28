package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Game.Board;
import it.polimi.ingsw.Model.Position;

import java.util.ArrayList;

public class ChoosePositionRequest extends Message {

    private final Position p1,p2;
    private Board board;
    private ArrayList<Position> availablePositions;

    public ChoosePositionRequest(Board board,Position p1, Position p2,ArrayList<Position> availablePositions){
        super(MessageType.CHOOSEITEM);
        this.board = board;
        this.p1 = p1;
        this.p2 = p2;
        this.availablePositions = availablePositions;
    }

    public Position getP1(){
        return p1;
    }

    public Position getP2(){
        return p2;
    }

    public Board getBoard() {
        return board;
    }

    public ArrayList<Position> getAvailable() {
        return availablePositions;
    }
}
