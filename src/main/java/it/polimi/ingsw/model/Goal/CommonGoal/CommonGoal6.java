package it.polimi.ingsw.Model.Goal.CommonGoal;

import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Shelf;
import it.polimi.ingsw.Model.Token;


/*  common goal 6:
                     five tiles of the same type forming a diagonal   */

public class CommonGoal6 extends Cgoal{


    public CommonGoal6() {
        setDescription("common goal 6:five tiles of the same type forming a diagonal\n");
        setIndex(6);


    }

    @Override
    public boolean isTaken(Shelf myShelf) {
        Item[][] myshelf = myShelf.getMyShelf();
        /*return  (  myshelf[0][0].getColor() == myshelf[1][1].getColor() && myshelf[0][0].getColor() == myshelf[2][2].getColor() && myshelf[0][0].getColor() == myshelf[3][3].getColor() && myshelf[0][0].getColor() == myshelf[4][4].getColor()) ||
                (  myshelf[0][4].getColor() == myshelf[1][3].getColor() && myshelf[0][4].getColor() == myshelf[2][2].getColor() && myshelf[0][4].getColor() == myshelf[3][1].getColor() && myshelf[0][4].getColor() == myshelf[4][0].getColor()) ||
                (  myshelf[5][0].getColor() == myshelf[4][1].getColor() && myshelf[5][0].getColor() == myshelf[3][2].getColor() && myshelf[5][0].getColor() == myshelf[2][3].getColor() && myshelf[5][0].getColor() == myshelf[1][4].getColor()) ||
                (  myshelf[5][4].getColor() == myshelf[4][3].getColor() && myshelf[5][4].getColor() == myshelf[3][2].getColor() && myshelf[5][4].getColor() == myshelf[2][1].getColor() && myshelf[5][4].getColor() == myshelf[1][0].getColor());
        */
        return false;
    }

    @Override
    public Token getToken() {
        Token t = null;
        if (tokens.size() > 0) {
            t = tokens.get(tokens.size() - 1);
            tokens.remove(tokens.size() - 1);
        }
        return t;
    }
}

