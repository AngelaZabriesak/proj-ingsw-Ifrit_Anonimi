package it.polimi.ingsw.Model.Goal.CommonGoal;

import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Shelf;
import it.polimi.ingsw.Model.Token;

/**
 *  common goal 9:
 *                   two lines each formed by 5 different types of tiles
 *                   one line can show the same or a different combination of other line
 */

public class CommonGoal9 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;


    public CommonGoal9(){
        setDescription("common goal 9: two lines each formed by 5 different types of tiles. One line can show the same or a different combination of other line\n");
        setIndex(9);

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

        for (int j= 0; j < ROW-1; j++) {
            for (int i = 0; i < COL-1; i++) {

                if (myshelf[j][i] != null && myshelf[j][i+1]!=null) {
                    if (myshelf[j][i].getColor() == myshelf[j][i + 1].getColor()) {
                        break;
                    } else numOfCond++;
                } else break;

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
