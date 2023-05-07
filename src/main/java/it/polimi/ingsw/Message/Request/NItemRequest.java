package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Game.Board;
import it.polimi.ingsw.Model.Goal.CommonGoal.Cgoal;
import it.polimi.ingsw.Model.Goal.PersonalGoal.Pgoal;

import java.util.ArrayList;

public class NItemRequest extends Message {
    private Board board;
    private ArrayList<Cgoal> commmonGoals;
    private Pgoal myPgoal;


    public NItemRequest(Board board, ArrayList<Cgoal> commmonGoals, Pgoal myPgoal){
        super(MessageType.N_ITEM_REQUEST);
        this.board = board;
        this.commmonGoals = commmonGoals;
        this.myPgoal = myPgoal;
    }



    public Pgoal getMyPgoal() {
        return myPgoal;
    }

    public Board getBoard() {
        return board;
    }

    public ArrayList<Cgoal> getCommmonGoals() {
        return commmonGoals;
    }
}
