package it.polimi.ingsw.Model.Goal.CommonGoal;

import it.polimi.ingsw.Model.Shelf;
import it.polimi.ingsw.Model.Bag.Item;


/* common goal 2:
                    four groups each containing at least 4 tiles of the same type,
                    the tiles of one group can be different from those of another group  */

public class CommonGoal2 extends Cgoal {
    private static final int ROW = 6;
    private static final int COL = 5;

    public CommonGoal2() {
        setDescription("common goal 2: four groups each containing at least 4 tiles of the same type,the tiles of one group can be different from those of another group\n");
        setIndex(2);
    }

    @Override
    public boolean isTaken(Shelf myShelf) {
        int numOfCond = 0;  // for this goal >3 at the end
        Item[][] myshelf = myShelf.getMyShelf();
        Item[][] myshelfcpy = myShelf.getMyShelf();
        int i, j;

        for (i = 0; i < ROW; i++) {
            for (j = 0; j < COL; j++) {
                if(myshelf[i][j]!=null){
                    if ((myshelf[i][j].getColor() != null) &&
                            (
                                    ((myshelf[i][j].getColor() == myshelf[i + 1][j].getColor()) &&
                                            (myshelf[i][j].getColor() == myshelf[i + 2][j].getColor()) &&
                                            (myshelf[i][j].getColor() == myshelf[i + 3][j].getColor()))
                                            ||
                                            ((myshelf[i][j].getColor() == myshelf[i][j + 1].getColor()) &&
                                                    (myshelf[i][j].getColor() == myshelf[i][j + 2].getColor()) &&
                                                    (myshelf[i][j].getColor() == myshelf[i][j + 3].getColor()))
                            )) {
                        numOfCond++;
                        myshelfcpy[i][j] = null;
                    }
                }
                numOfCond++;
                myshelfcpy[i][j] = null;
            }

        }
        return numOfCond >= 3;
    }
}



