package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
//commong goal 5:
//eight tiles of the same type
// There's no restriction about the position of these tiles
public class CommonGoal5 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    public CommonGoal5(){
        setDescription("common goal 5");
        setIndex(5);
    }


}
