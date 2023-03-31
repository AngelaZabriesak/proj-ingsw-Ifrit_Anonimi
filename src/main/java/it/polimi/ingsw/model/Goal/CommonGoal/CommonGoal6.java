package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;

//common goal 6:
//five tiles of the same type forming a diagonal

public class CommonGoal6 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    public CommonGoal6(){
        setDescription("common goal 6");
        setIndex(6);
    }


}
