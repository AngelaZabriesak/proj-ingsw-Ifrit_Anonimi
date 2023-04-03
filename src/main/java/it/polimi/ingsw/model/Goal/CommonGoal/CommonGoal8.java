package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Token;
import it.polimi.ingsw.model.Shelf;


// common goal 8:
// two columns each formed by 6 different types of tiles

public class CommonGoal8 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];
                     // for this goal >1 at the end

    public CommonGoal8(Shelf CShelf){
        setDescription("common goal 8:two columns each formed by 6 different types of tiles\n");
        setIndex(8);
        Item[][] myshelf = CShelf.getMyShelf();
        int numOfCond = 0;
        int i=0;
        int j=0;
        do {
            if(myshelf[i][j] == myshelf[i][j+1]) {
                i++;
            } else {
                if(j==ROW)
                    numOfCond++;
                    j++;
                }
        } while (i<COL);


    }

}
