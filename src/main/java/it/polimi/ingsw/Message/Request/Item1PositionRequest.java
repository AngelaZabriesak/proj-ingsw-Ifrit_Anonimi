package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Game.Board;
import it.polimi.ingsw.Model.Goal.CommonGoal.Cgoal;
import it.polimi.ingsw.Model.Goal.PersonalGoal.Pgoal;
import it.polimi.ingsw.Model.Position;
import it.polimi.ingsw.Model.Shelf;

import java.util.ArrayList;

public class Item1PositionRequest extends Message {

    private final Board board;
    private final ArrayList<Cgoal> commonGoals;
    private final Pgoal myPgoal;
    private final Shelf shelf;
    private final String error;
    private final ArrayList<Position> availablePosition;
    public Item1PositionRequest(String error, Board board, Shelf shelf, ArrayList<Cgoal> commonGoals, Pgoal myPgoal, ArrayList<Position> positionAvailable) {
        super(MessageType.ITEM_1POSITION_REQUEST);
        this.board = board;
        this.shelf = shelf;
        this.commonGoals = commonGoals;
        this.myPgoal = myPgoal;
        this.error = error;
        this.availablePosition = positionAvailable;
    }

    public Pgoal getMyPgoal() {
        return myPgoal;
    }

    public Board getBoard() {
        return board;
    }

    public Shelf getShelf() {
        return shelf;
    }


    public ArrayList<Cgoal> getCommonGoals() {
        return commonGoals;
    }

    public String getError(){
        return error;
    }

    public ArrayList<Position> getAvailablePosition() {
        return availablePosition;
    }

}
