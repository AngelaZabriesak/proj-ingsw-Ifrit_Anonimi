package it.polimi.ingsw.Model.Goal.CommonGoal;


import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Shelf;
import it.polimi.ingsw.Model.Token;

/**
 * common goal 0 :
 *                     six groups each containing at least 2 tiles of the same type,
 *                     the tiles pf one group can be different from those of another group
 *
 */
public class CommonGoal1 extends Cgoal {

    public CommonGoal1() {
        setDescription("common goal 1: Four tiles of the same type in the four corners of the bookshelf\n");
        setIndex(1);
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
        return ((myshelf[0][0] != null) && ( myshelf[0][4]!= null && myshelf[0][0].getColor() == myshelf[0][4].getColor() ) &&
                                           ( myshelf[5][4]!= null && myshelf[0][0].getColor() == myshelf[5][4].getColor() ) &&
                                           ( myshelf[5][0]!= null && myshelf[0][0].getColor() == myshelf[5][0].getColor() ) );

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