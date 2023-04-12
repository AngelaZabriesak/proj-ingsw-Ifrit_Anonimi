package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Shelf;
//import it.polimi.ingsw.model.Token;

/* common goal 11:
                 five columns of increasing on decreasing height
                 starting from the first column on the left or the right
                 each next column must be made of exactly one more tile
                 tiles can be of any type  */

public class CommonGoal11 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    //private Item[][] myItemGoal = new Item[ROW][COL];     may be useless

    public boolean CommonGoal11(Shelf CShelf){
        setDescription("common goal 11:five columns of increasing on decreasing height starting from the first column on the left or the right,each next column must be made of exactly one more tile. Tiles can be of any type\n");
        setIndex(11);
        Item[][] myshelf = CShelf.getMyShelf();
        int j=0;
        for (int i=0;i<COL;i++){
            if
            (       (myshelf[j].length ==5 &&
                    myshelf[j+1].length ==4 &&
                    myshelf[j+2].length ==3 &&
                    myshelf[j+3].length ==2 &&
                    myshelf[j+4].length ==1) ||
                    (myshelf[j].length ==6 &&
                    myshelf[j+1].length ==5 &&
                    myshelf[j+2].length ==4 &&
                    myshelf[j+3].length ==3 &&
                    myshelf[j+4].length ==2 ) ||
                    (myshelf[j].length ==1 &&
                    myshelf[j+1].length ==2 &&
                    myshelf[j+2].length ==3 &&
                    myshelf[j+3].length ==4 &&
                    myshelf[j+4].length ==5) ||
                    (myshelf[j].length ==2 &&
                    myshelf[j+1].length ==3 &&
                    myshelf[j+2].length ==4 &&
                    myshelf[j+3].length ==5 &&
                    myshelf[j+4].length ==6 )) return true;

        } return false;

    }


    @Override
    public boolean isTaken(Shelf myShelf) {
        return false;
    }
}
