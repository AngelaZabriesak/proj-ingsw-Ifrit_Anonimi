package it.polimi.ingsw.Model.Goal.CommonGoal;

import it.polimi.ingsw.Model.Game.CreateItemGroup;
import it.polimi.ingsw.Model.Position;
import it.polimi.ingsw.Model.Shelf;
import it.polimi.ingsw.Model.Token;

import java.util.ArrayList;

/**
 * common goal 0 :
 *                     six groups each containing at least 2 tiles of the same type,
 *                     the tiles pf one group can be different from those of another group
 *
 */

public class CommonGoal0 extends Cgoal {

    public CommonGoal0() {
        setDescription("common goal 0: six groups each containing at least 2 tiles of the same type,the tiles pf one group can be different from those of another group\n");
        setIndex(0);
    }

    /**
     *
     * @param myShelf player shelf
     * @return taken or not taken CGoal
     *
     */

    @Override
    public boolean isTaken(Shelf myShelf) {

        ArrayList<Position>[] groups = new CreateItemGroup().creaGruppi(myShelf);
        int numOfCond = 0;

        for (ArrayList<Position> group : groups) {
            if (group != null) {
                numOfCond += group.size() / 2;
                if (numOfCond >= 6) {
                    break;
                }
            }
        }
        return numOfCond >= 6;
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



