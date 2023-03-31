package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;

// common goal 10:
// five tiles of the same type forming an X

public class CommonGoal10 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    public CommonGoal10(){
        setDescription("common goal 10");
        setIndex(10);
    }


}
