package it.polimi.ingsw.Model.Goal.CommonGoal;

import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Shelf;
import it.polimi.ingsw.Model.Token;


/**
 *  common goal 8:
 *                    two columns each formed by 6 different types of tiles
 */

public class CommonGoal8 extends Cgoal {

    private static final int ROW = 6;
    private static final int COL = 5;


    public CommonGoal8() {
        setDescription("common goal 8:two columns each formed by 6 different types of tiles\n");
        setIndex(8);


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

        int numOfCond = 0;
        for (int i = 0; i <COL; i++) {

            for (int j = 0; j <ROW-1 ; j++) {

                if(myshelf[j][i] != null){
                    if ( myshelf[j + 1][i] != null && myshelf[j][i].getColor() == myshelf[j + 1][i].getColor()) {
                        break;
                    } else numOfCond++;

                }
                else break;
            }

        }
        return numOfCond > 1;
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
