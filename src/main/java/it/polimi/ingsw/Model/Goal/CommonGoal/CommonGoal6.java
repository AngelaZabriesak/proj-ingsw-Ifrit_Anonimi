package it.polimi.ingsw.Model.Goal.CommonGoal;

import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Shelf;
import it.polimi.ingsw.Model.Token;


/**
 * common goal 6:
 *                      five tiles of the same type forming a diagonal
 */

public class CommonGoal6 extends Cgoal {


    public CommonGoal6() {
        setDescription("common goal 6:five tiles of the same type forming a diagonal\n");
        setIndex(6);


    }

    /**
     *
     * @param myShelf player shelf
     * @return taken or not taken CGoal
     *
     */

    @Override
    public boolean isTaken(Shelf myShelf) {
        Item[][] myshelf = myShelf.getMyShelf();
        return (
                ( myshelf[0][0] != null && (myshelf[1][1] != null && myshelf[0][0].getColor() == myshelf[1][1].getColor()) && (myshelf[2][2] != null && myshelf[0][0].getColor() == myshelf[2][2].getColor()) && (myshelf[3][3] != null && myshelf[0][0].getColor() == myshelf[3][3].getColor()) && (myshelf[4][4] != null && myshelf[0][0].getColor() == myshelf[4][4].getColor()) ) ||
                ( myshelf[0][4] != null && (myshelf[1][3] != null && myshelf[0][4].getColor() == myshelf[1][3].getColor()) && (myshelf[2][2] != null && myshelf[0][4].getColor() == myshelf[2][2].getColor()) && (myshelf[3][1] != null && myshelf[0][4].getColor() == myshelf[3][1].getColor()) && (myshelf[4][0] != null && myshelf[0][4].getColor() == myshelf[4][0].getColor()) ) ||
                ( myshelf[5][0] != null && (myshelf[4][1] != null && myshelf[5][0].getColor() == myshelf[4][1].getColor()) && (myshelf[3][2] != null && myshelf[5][0].getColor() == myshelf[3][2].getColor()) && (myshelf[2][3] != null && myshelf[5][0].getColor() == myshelf[2][3].getColor()) && (myshelf[1][4] != null && myshelf[5][0].getColor() == myshelf[1][4].getColor()) ) ||
                ( myshelf[5][4] != null && (myshelf[4][3] != null && myshelf[5][4].getColor() == myshelf[4][3].getColor()) && (myshelf[3][2] != null && myshelf[5][4].getColor() == myshelf[3][2].getColor()) && (myshelf[2][1] != null && myshelf[5][4].getColor() == myshelf[2][1].getColor()) && (myshelf[1][0] != null && myshelf[5][4].getColor() == myshelf[1][0].getColor()) ) );
    }


    /**
     *
     * @return the token if it is taken with its score otherwise a token of score 0
     *
     */

    @Override
    public Token getToken() {
        Token t = null;
        if (tokens.size() > 0) {
            t = tokens.get(tokens.size() - 1);
            tokens.remove(tokens.size() - 1);
        }
        if (t == null) {
            t = new Token(0);
        }
        return t;
    }
}

