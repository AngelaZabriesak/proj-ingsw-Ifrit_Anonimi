package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Shelf;
import it.polimi.ingsw.model.Token;

/* common goal 3:
                   two groups each containing 4 tiles of the same type in a 2x2 square.
                   the tiles of one square can be different from those of the other square. */


public class CommonGoal3 extends Cgoal {

    private static final int ROW = 6;
    private static final int COL = 5;
    //private Item[][] myItemGoal = new Item[ROW][COL];         may be useless

    public CommonGoal3() {
        setDescription("common goal 3:two groups each containing 4 tiles of the same type in a 2x2 square. the tiles of one square can be different from those of the other square\n");
        setIndex(3);
    }

    @Override
    public boolean isTaken(Shelf myShelf) {
        Item[][] myshelf = myShelf.getMyShelf();
        Item[][] myshelfcpy = myShelf.getMyShelf();
        int numOfCond = 0;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if
                (       (myshelf[i][j].getColor() != null) &&
                        (myshelf[i][j].getColor() == myshelf[i + 1][j].getColor()) &&
                        (myshelf[i][j].getColor() == myshelf[i][j + 1].getColor()) &&
                        (myshelf[i][j].getColor() == myshelf[i + 1][j + 1].getColor()) &&
                        (myshelf[i][j].getColor() == myshelfcpy[i][j].getColor())) {
                    numOfCond++;
                    myshelfcpy[i][j] = null;
                }
                return numOfCond >= 2;
            }
        } return false;
    }
}