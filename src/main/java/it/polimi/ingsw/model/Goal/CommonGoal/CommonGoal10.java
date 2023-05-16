package it.polimi.ingsw.Model.Goal.CommonGoal;

import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Shelf;
import it.polimi.ingsw.Model.Token;


/*   common goal 10:
                     five tiles of the same type forming an X   */

public class CommonGoal10 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;

    public CommonGoal10() {
        setDescription("common goal 10:five tiles of the same type forming an X\n");
        setIndex(10);
    }


    @Override
    public boolean isTaken(Shelf myShelf) {
        Item[][] myshelf = myShelf.getMyShelf();

        for (int i=0; i<3; i++) {
            for (int j = 0; j<4; j++) {
                if (myshelf[j][i] != null &&
                        (myshelf[j][i + 2] != null && myshelf[j][i].getColor() == myshelf[j][i + 2].getColor() ) &&
                        (myshelf[j + 1][i + 1] != null && myshelf[j][i].getColor() == myshelf[j + 1][i + 1].getColor() ) &&
                        (myshelf[j + 2][i] != null && myshelf[j][i].getColor() == myshelf[j + 2][i].getColor() ) &&
                        (myshelf[j + 2][i + 2] != null && myshelf[j][i].getColor() == myshelf[j + 2][i + 2].getColor() ) )
                    return true;

            }

        }
        return false;
    }

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
