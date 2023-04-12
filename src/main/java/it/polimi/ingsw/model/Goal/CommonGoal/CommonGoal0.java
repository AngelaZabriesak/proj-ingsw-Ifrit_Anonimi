package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Shelf;

/* common goal 0 :
                    six groups each containing at least 2 tiles of the same type,
                    the tiles pf one group can be different from those of another group */

public class CommonGoal0 extends Cgoal {

    private static final int ROW = 6;
    private static final int COL = 5;


    public CommonGoal0() {
        setDescription("common goal 0: six groups each containing at least 2 tiles of the same type,the tiles pf one group can be different from those of another group\n");
        setIndex(0);
    }

    @Override
    public boolean isTaken(Shelf myShelf) {
        Item[][] myshelf = myShelf.getMyShelf();
        Item[][] myshelfcpy = myShelf.getMyShelf();
        int numOfCond = 0;     // for this goal ==6

        for (int i=0; i<ROW; i++){
            for (int j=0; j<COL; j++){
                if
                (myshelf[i][j].getColor() != null &&
                        myshelf[i][j].getColor() == myshelf[i+1][j].getColor() &&
                        myshelf[i][j].getColor() == myshelfcpy[i][j].getColor())
                {numOfCond++;
                    myshelfcpy[i][j] = null;
                    myshelfcpy[i+1][j] = null;}
                if
                (myshelf[i][j].getColor() != null &&
                        myshelf[i][j].getColor() == myshelf[i][j+1].getColor() &&
                        myshelf[i][j].getColor() == myshelfcpy[i][j].getColor() )
                {numOfCond++;
                    myshelfcpy[i][j] = null;
                    myshelfcpy[i][j+1] = null;}

                return numOfCond ==6;
            }
        }
        return false;
    }
}


