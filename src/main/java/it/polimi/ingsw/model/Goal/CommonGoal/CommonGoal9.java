package it.polimi.ingsw.Model.Goal.CommonGoal;

import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Shelf;

/* common goal 9:
                  two lines each formed by 5 different types of tiles
                  one line can show the same or a different combination of other line  */

public class CommonGoal9 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;


    public CommonGoal9(){
        setDescription("common goal 9: two lines each formed by 5 different types of tiles. One line can show the same or a different combination of other line\n");
        setIndex(9);

    }

    @Override
    public boolean isTaken(Shelf myShelf) {
        Item[][] myshelf = myShelf.getMyShelf();
        int numOfCond = 0;

        for (int j= 0; j < ROW; j++) {

            for (int i = 0; i<COL; i++) {
                if ( myshelf[j][i].getColor() == myshelf[j][i+1].getColor()){
                    break;
                } else numOfCond++;
            }

        }
        return numOfCond > 1;
    }
}
