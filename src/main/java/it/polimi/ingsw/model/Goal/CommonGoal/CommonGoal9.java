package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Token;

// common goal 9:
// two lines each formed by 5 different types of tiles
// one line can show the same or a different combination of other line

public class CommonGoal9 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];
    private int numOfCond = 0;                 // for this goal >1 at the end

    public CommonGoal9(){
        setDescription("common goal 9: two lines each formed by 5 different types of tiles. One line can show the same or a different combination of other line\n");
        setIndex(9);
    }

    @Override
    public Token getToken() {
        return super.getToken();
    }

}
