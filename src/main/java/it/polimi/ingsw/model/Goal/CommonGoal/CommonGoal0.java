package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Shelf;
import it.polimi.ingsw.model.Token;

// common goal 0 :
// six groups each containing at least 2 tiles of the same type,
// the tiles pf one group can be different from those of another group

public class CommonGoal0 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
                     // for this goal >5 at the end



    public boolean CommonGoal0(Shelf CShelf){
        setDescription("common goal 0: six groups each containing at least 2 tiles of the same type,the tiles pf one group can be different from those of another group\n");
        setIndex(0);
        Item[][] myshelf = CShelf.getMyShelf();
        Item[][] myshelfcpy = CShelf.getMyShelf();
        int numOfCond = 0;
        for (int i=0; i<ROW; i++){
            for (int j=0; j<COL; j++){
                if
                ((myshelf[i][j] != null) &&
                ((myshelf[i][j] == myshelf[i+1][j]) ||
                (myshelf[i][j] == myshelf[i][j+1])) &&
                (myshelf[i][j] == myshelfcpy[i][j]))
                {numOfCond++;
                myshelfcpy[i][j] = null;}
            }
        }
        if (numOfCond==6) return true;
        else return false;
    }

    /*public boolean CheckCondition() {
        if (numOfCond>5) {
            return true;
        }
        else return false;
    }*/

}
