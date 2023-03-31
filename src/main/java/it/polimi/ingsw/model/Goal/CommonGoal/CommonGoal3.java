package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Token;

// common goal 3:
// two groups each containing 4 tiles of the same type in a 2x2 square.
// the tiles of one square can be different from those of the other square.


public class CommonGoal3 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];
    private int numOfCond = 0;                 // for this goal >1 at the end


    public CommonGoal3(){
        setDescription("common goal 3:two groups each containing 4 tiles of the same type in a 2x2 square. the tiles of one square can be different from those of the other square\n");
        setIndex(3);
    }

    @Override
    public Token getToken() {
        return super.getToken();
    }

}
