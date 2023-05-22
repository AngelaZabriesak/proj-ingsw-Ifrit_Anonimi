package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Goal.*;

public class GoalTake extends Message {

    private final Goal goal;
    private final int score;

    public GoalTake(Goal goal, int score){
        super(MessageType.GOAL_TAKE);
        this.goal = goal;
        this.score = score;
    }

    public Goal getGoal() {
        return goal;
    }

    public int getScore() {
        return score;
    }
}
