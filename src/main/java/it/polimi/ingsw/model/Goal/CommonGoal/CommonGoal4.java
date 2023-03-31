package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;

// common goal 4:
// three columns each formed by 6 tiles maximum three different types.
// one column can show the same or a different combination of another column

public class CommonGoal4 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    public CommonGoal4(){
        setDescription("common goal 4");
    }


}
