package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;

// common goal 0 :
// six groups each containing at least 2 tiles of the same type,
// the tiles pf one group can be different from those of another group

public class CommonGoal0 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];


    public CommonGoal0(){
        setDescription();
    }

}
