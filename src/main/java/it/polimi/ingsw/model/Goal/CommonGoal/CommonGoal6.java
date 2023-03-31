package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Token;

//common goal 6:
//five tiles of the same type forming a diagonal

public class CommonGoal6 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];
    private int numOfCond = 0;                 // for this goal >0 at the end

    public CommonGoal6(){
        setDescription("common goal 6:five tiles of the same type forming a diagonal\n");
        setIndex(6);
    }

    public boolean CheckCondition() {
        if (numOfCond>0) {
            return true;
        }
        else return false;
    }

    @Override
    public Token getToken() {
        return super.getToken();
    }

}
