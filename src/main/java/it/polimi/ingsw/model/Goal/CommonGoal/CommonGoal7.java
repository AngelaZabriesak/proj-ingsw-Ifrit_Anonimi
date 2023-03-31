package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Token;

// common goal 7:
// four lines each formed by 5 tiles of maximum three different types
// one line can show the same or a different combination of other line
public class CommonGoal7 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];
    private int numOfCond = 0;                 // for this goal >3 at the end

    public CommonGoal7(){
        setDescription("common goal 7: four lines each formed by 5 tiles of maximum three different types. One line can show the same or a different combination of other line\n ");
        setIndex(7);
    }

    @Override
    public Token getToken() {
        return super.getToken();
    }

}
