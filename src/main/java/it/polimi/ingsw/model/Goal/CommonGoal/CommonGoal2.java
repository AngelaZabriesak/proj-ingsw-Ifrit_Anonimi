package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Token;

// common goal 2:
// four groups each containing at least 4 tiles of the same type,
// the tiles of one group can be different from those of another group

public class CommonGoal2 extends Cgoal {
    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];
    private int numOfCond = 0;                 // for this goal >3 at the end


    public CommonGoal2() {
        setDescription("common goal 2: four groups each containing at least 4 tiles of the same type,the tiles of one group can be different from those of another group\n");
        setIndex(2);
    }
}


