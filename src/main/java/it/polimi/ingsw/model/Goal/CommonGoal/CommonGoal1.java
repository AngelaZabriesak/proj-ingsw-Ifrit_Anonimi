package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;

// common goal 1:
// four tiles of the same type in the four corners of the bookshelf

public class CommonGoal1 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];


    public CommonGoal1(){
        setDescription("common goal 1");
        setIndex(1);
    }


}
