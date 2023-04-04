package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Shelf;
import it.polimi.ingsw.model.Token;

// common goal 10:
// five tiles of the same type forming an X

public class CommonGoal10 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    //private Item[][] myItemGoal = new Item[ROW][COL];         may be useless

    public boolean CommonGoal10(Shelf CShelf) {
        setDescription("common goal 10:five tiles of the same type forming an X\n");
        setIndex(10);

        Item[][] myshelf = CShelf.getMyShelf();

        for (int i=0; i<=3; i++) {
            for (int j = 0; j<=4; j++) {
                if(
                        (myshelf[j][i].getColor() != null) && myshelf[j][i].getColor() == myshelf[j][i+2].getColor()   &&
                                                              myshelf[j][i].getColor() == myshelf[j+1][i+1].getColor() &&
                                                              myshelf[j][i].getColor() == myshelf[j+2][i].getColor() &&
                                                              myshelf[j][i].getColor() == myshelf[j+2][i+2].getColor()   )
                 return true;
            }

        } return false;

    }

}
