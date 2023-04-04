package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Shelf;
import it.polimi.ingsw.model.Token;

// common goal 3:
// two groups each containing 4 tiles of the same type in a 2x2 square.
// the tiles of one square can be different from those of the other square.


public class CommonGoal3 extends Cgoal {

    private static final int ROW = 6;
    private static final int COL = 5;
    //private Item[][] myItemGoal = new Item[ROW][COL];         may be useless

    public boolean CommonGoal3(Shelf CShelf) {
        setDescription("common goal 3:two groups each containing 4 tiles of the same type in a 2x2 square. the tiles of one square can be different from those of the other square\n");
        setIndex(3);
        Item[][] myshelf = CShelf.getMyShelf();
        Item[][] myshelfcpy = CShelf.getMyShelf();
        int numOfCond = 0;

        for (int i=0; i<ROW; i++){
            for (int j=0; j<COL; j++){
                if
                ((myshelf[i][j] != null) &&
                (myshelf[i][j] == myshelf[i+1][j]) &&
                (myshelf[i][j] == myshelf[i][j+1]) &&
                (myshelf[i][j] == myshelf[i+1][j+1]) &&
                (myshelf[i][j] == myshelfcpy[i][j]))
                {numOfCond++;
                 myshelfcpy[i][j] = null;}
            }
        }
        if (numOfCond==2) return true;
        else return false;
    }

}