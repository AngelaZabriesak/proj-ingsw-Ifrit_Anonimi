package it.polimi.ingsw.Model.Goal.CommonGoal;
import it.polimi.ingsw.Model.Bag.ColorItem;
import it.polimi.ingsw.Model.Shelf;
import it.polimi.ingsw.Model.Position;
import it.polimi.ingsw.Model.Token;

import java.util.ArrayList;

/**
 *  common goal 5:
 *     eight tiles of the same type
 *     There's no restriction about the position of these tiles
 *
 */

public class CommonGoal5 extends Cgoal {


    public CommonGoal5() {
        setDescription("common goal 5:eight tiles of the same type. There's no restriction about the position of these tiles\n");
        setIndex(5);
    }


    /**
     *
     * @param myShelf player shelf
     * @return taken or not taken CGoal
     *
     */

    @Override
    public boolean isTaken(Shelf myShelf) {

        ArrayList<Position> group = null;

        for (ColorItem ci : ColorItem.values()) {   // there is even black : groupColor size is 7
            group = new ArrayList<>();
            for (int r = 0; r < myShelf.getRow(); r++) {
                for (int c = 0; c < myShelf.getCol(); c++) {
                    if(myShelf.getMyShelf()[r][c]!=null){
                        if (myShelf.getMyShelf()[r][c].getColor().equals(ci))
                            group.add(new Position(r, c));
                    }
                }
            }
        }
        assert group != null;
        return group.size() == 8;
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









