package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Game.Board;
import it.polimi.ingsw.Model.Goal.CommonGoal.Cgoal;
import it.polimi.ingsw.Model.Goal.PersonalGoal.Pgoal;

import java.util.ArrayList;

public class Item1PositionRequest extends Message {

    private final Board board;
    private final ArrayList<Cgoal> commonGoals;
    private final Pgoal myPgoal;
    private final String error;


    public Item1PositionRequest(String error,Board board, ArrayList<Cgoal> commmonGoals, Pgoal myPgoal) {
        super(MessageType.ITEM_1POSITION_REQUEST);
        this.board = board;
        this.commonGoals = commmonGoals;
        this.myPgoal = myPgoal;
        this.error = error;
    }

    public Pgoal getMyPgoal() {
        return myPgoal;
    }

    public Board getBoard() {
        return board;
    }

    public ArrayList<Cgoal> getCommonGoals() {
        return commonGoals;
    }

    public String getError(){
        return error;
    }

}
