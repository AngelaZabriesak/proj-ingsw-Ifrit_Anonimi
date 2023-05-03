package it.polimi.ingsw.Model.Goal.CommonGoal;

import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Shelf;


/*   common goal 10:
                     five tiles of the same type forming an X   */

public class CommonGoal10 extends Cgoal{


    public CommonGoal10() {
        setDescription("common goal 10:five tiles of the same type forming an X\n");
        setIndex(10);
    }


    @Override
    public boolean isTaken(Shelf myShelf) {
        Item[][] myshelf = myShelf.getMyShelf();

        for (int i=0; i<=3; i++) {
            for (int j = 0; j<=4; j++) {
                if(
                        myshelf[j][i].getColor() == myshelf[j][i+2].getColor()   &&
                                myshelf[j][i].getColor() == myshelf[j+1][i+1].getColor() &&
                                myshelf[j][i].getColor() == myshelf[j+2][i].getColor() &&
                                myshelf[j][i].getColor() == myshelf[j+2][i+2].getColor()   )
                    return true;
            }

        } return false;
    }
}
