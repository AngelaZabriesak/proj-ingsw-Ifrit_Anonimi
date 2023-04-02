package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.ColorItem;
import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Token;

// common goal 1:
// four tiles of the same type in the four corners of the bookshelf

public class CommonGoal1 extends Cgoal {

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];
    private final int numOfCond = 0;                 // for this goal >0 at the end

    public CommonGoal1() {
        setDescription("common goal 1:four tiles of the same type in the four corners of the bookshelf\n");
        setIndex(1);
        myItemGoal[0][0] = myItemGoal[0][4] = myItemGoal[5][0] = myItemGoal[5][4];
    }

}
