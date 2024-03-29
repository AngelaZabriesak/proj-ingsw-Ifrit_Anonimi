package it.polimi.ingsw.Model.Goal.CommonGoal;

import it.polimi.ingsw.Model.Bag.ColorItem;
import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Shelf;
import it.polimi.ingsw.Model.Token;

import java.util.ArrayList;
import java.util.Collections;


/**
 * common goal 2:
 *                     four groups each containing at least 4 tiles of the same type,
 *                     the tiles of one group can be different from those of another group
 */


public class CommonGoal3 extends Cgoal {

    private static final int ROW = 6;
    private static final int COL = 5;


    public CommonGoal3() {
        setDescription("common goal 3:two groups each containing 4 tiles of the same type in a 2x2 square. the tiles of one square can be different from those of the other square\n");
        setIndex(3);
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
        Item[][] myshelfcpy = myShelf.getMyShelf();
        ArrayList<ColorItem> squares = new ArrayList<>();
        for (int i = 0; i < (ROW-1); i++) {
            for (int j = 0; j < (COL-1); j++) {
                if (myshelf[i][j] != null) {
                    if
                    (
                            ( (myshelf[i + 1][j] != null) && myshelf[i][j].getColor() == myshelf[i + 1][j].getColor() ) &&
                                    ( (myshelf[i][j + 1] != null) && myshelf[i][j].getColor() == myshelf[i][j + 1].getColor() ) &&
                                    ( (myshelf[i + 1][j + 1] != null) && myshelf[i][j].getColor() == myshelf[i + 1][j + 1].getColor() ) &&
                                    ( (myshelfcpy[i][j] != null) && myshelf[i][j].getColor() == myshelfcpy[i][j].getColor() ) ) {
                        squares.add(myshelf[i][j].getColor());
                        myshelfcpy[i][j] = null;
                        myshelfcpy[i + 1][j] = null;
                        myshelfcpy[i][j + 1] = null;
                        myshelfcpy[i + 1][j + 1] = null;
                    }
                }
                if (Collections.frequency(squares, ColorItem.AZURE) > 1) {
                    return true;
                }
                if (Collections.frequency(squares, ColorItem.BLUE) > 1) {
                    return true;
                }
                if (Collections.frequency(squares, ColorItem.GREEN) > 1) {
                    return true;
                }
                if (Collections.frequency(squares, ColorItem.PINK) > 1) {
                    return true;
                }
                if (Collections.frequency(squares, ColorItem.WHITE) > 1) {
                    return true;
                }
                if (Collections.frequency(squares, ColorItem.YELLOW) > 1) {
                    return true;
                }

            }

        } return false;
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
