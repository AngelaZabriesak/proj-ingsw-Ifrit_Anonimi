package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Token;

// common goal 8:
// two columns each formed by 6 different types of tiles

public class CommonGoal8 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];
    private int numOfCond = 0;                 // for this goal >1 at the end

    public CommonGoal8(){
        setDescription("common goal 8:two columns each formed by 6 different types of tiles\n");
        setIndex(8);
    }

}
