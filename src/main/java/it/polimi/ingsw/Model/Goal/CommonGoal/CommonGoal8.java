package it.polimi.ingsw.Model.Goal.CommonGoal;

import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Shelf;


/* common goal 8:
                   two columns each formed by 6 different types of tiles  */

public class CommonGoal8 extends Cgoal {

    private static final int ROW = 6;
    private static final int COL = 5;


    public CommonGoal8() {
        setDescription("common goal 8:two columns each formed by 6 different types of tiles\n");
        setIndex(8);


    }

    @Override
    public boolean isTaken(Shelf myShelf) {

        Item[][] myshelf = myShelf.getMyShelf();

        int numOfCond = 0;
        for (int i = 0; i < COL; i++) {

            for (int j = 0; j < ROW; j++) {
                if (myshelf[j][i].getColor() == null || myshelf[j][i].getColor() == myshelf[j + 1][i].getColor()){
                    break;
                } else numOfCond++;
            }

        }
        return numOfCond > 1;
    }
}
