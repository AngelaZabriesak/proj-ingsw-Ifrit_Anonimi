package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Token;

// common goal 0 :
// six groups each containing at least 2 tiles of the same type,
// the tiles pf one group can be different from those of another group

public class CommonGoal0 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];
    private int numOfCond = 0;                 // for this goal >5 at the end



    public CommonGoal0(){
        setDescription("common goal 0: six groups each containing at least 2 tiles of the same type,the tiles pf one group can be different from those of another group\n");
        setIndex(0);
    }

    public boolean CheckCondition() {
        if (numOfCond>5) {
            return true;
        }
        else return false;
    }

    @Override
    public Token getToken() {
        return super.getToken();
    }
}
