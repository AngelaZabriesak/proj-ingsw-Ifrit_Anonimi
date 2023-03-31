package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Token;

// common goal 10:
// five tiles of the same type forming an X

public class CommonGoal10 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];
    private int numOfCond = 0;                 // for this goal >0 at the end

    public CommonGoal10(){
        setDescription("common goal 10:five tiles of the same type forming an X\n");
        setIndex(10);
    }

    @Override
    public Token getToken() {
        return super.getToken();
    }

}
