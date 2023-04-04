package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Token;
import it.polimi.ingsw.model.Shelf;

/* common goal 9:
                  two lines each formed by 5 different types of tiles
                  one line can show the same or a different combination of other line  */

public class CommonGoal9 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    //private Item[][] myItemGoal = new Item[ROW][COL];      may be useless

    public boolean CommonGoal9(Shelf CShelf){
        setDescription("common goal 9: two lines each formed by 5 different types of tiles. One line can show the same or a different combination of other line\n");
        setIndex(9);
        Item[][] myshelf = CShelf.getMyShelf();
        int numOfCond=0;
        int i=0;
        for  (int j=0; j<ROW;j++){
            if
            (       myshelf[j][i].getColor() != myshelf[j][i+1].getColor() &&
                    myshelf[j][i].getColor() != myshelf[j][i+2].getColor() &&
                    myshelf[j][i].getColor() != myshelf[j][i+3].getColor() &&
                    myshelf[j][i].getColor() != myshelf[j][i+4].getColor() &&
                    myshelf[j][i+1].getColor() != myshelf[j][i+2].getColor() &&
                    myshelf[j][i+1].getColor() != myshelf[j][i+3].getColor() &&
                    myshelf[j][i+1].getColor() != myshelf[j][i+4].getColor() &&
                    myshelf[j][i+2].getColor() != myshelf[j][i+3].getColor() &&
                    myshelf[j][i+2].getColor() != myshelf[j][i+4].getColor() &&
                    myshelf[j][i+3].getColor() != myshelf[j][i+4].getColor())
                numOfCond++;
        }
        if (numOfCond>1) {return true;} else return false;
    }

}
