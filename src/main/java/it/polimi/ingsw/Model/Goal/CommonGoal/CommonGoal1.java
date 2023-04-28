package it.polimi.ingsw.Model.Goal.CommonGoal;


import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Shelf;

/* common goal 1:
 four tiles of the same type in the four corners of the bookshelf */

public class CommonGoal1 extends Cgoal {

    public CommonGoal1() {
        setDescription("common goal 1: Four tiles of the same type in the four corners of the bookshelf\n");
        setIndex(1);
    }

    @Override
    public boolean isTaken(Shelf myShelf) {

        Item[][] myshelf = myShelf.getMyShelf();

        return (myshelf[0][0].getColor() != null) && (myshelf[0][0].getColor() == myshelf[0][4].getColor() && myshelf[0][0].getColor() == myshelf[5][4].getColor() && myshelf[0][0].getColor() == myshelf[5][0].getColor());

    }
}