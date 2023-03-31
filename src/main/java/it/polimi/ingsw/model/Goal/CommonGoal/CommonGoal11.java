package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;

// common goal 11:
// five columns of increasing on decreasing height
//starting from the first column on the left or the right
// each next column must be made of exactly one more tile
//tiles can be of any type

public class CommonGoal11 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    public CommonGoal11(){
        setDescription("common goal 11");
        setIndex(11);
    }


}
