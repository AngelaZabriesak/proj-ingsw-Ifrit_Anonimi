package it.polimi.ingsw.Model.Goal.CommonGoal;

import it.polimi.ingsw.Model.Bag.ColorItem;
import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Shelf;
import it.polimi.ingsw.Model.Token;

/**
 *  common goal 7:
 *                   four lines each formed by 5 tiles of maximum three different types
 *                   one line can show the same or a different combination of other line
 */


public class CommonGoal7 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private int numOfCond = 0;                 // for this goal >3 at the end

    public CommonGoal7(){
        setDescription("common goal 7: four lines each formed by 5 tiles of maximum three different types. One line can show the same or a different combination of other line\n ");
        setIndex(7);
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

        int b = 0;   //n of elements blue
        int w = 0;   //n of element white
        int p = 0;  // n of elements pink
        int g = 0;   //n of elements green
        int y = 0;   //n of elements yellow
        int a = 0;   //n of elements azure
        int sum;   // sum of the different colors in every col



        for (int j = 0; j < ROW; j++) {

            for (int i = 0; i < COL; i++) {

                if (myshelf[j][i] != null){


                    if (myshelf[j][i].getColor() == ColorItem.BLUE) {
                        b = 1;
                    }

                    if (myshelf[j][i].getColor() == ColorItem.WHITE) {
                        w = 1;
                    }

                    if (myshelf[j][i].getColor() == ColorItem.PINK) {
                        p = 1;
                    }
                    if (myshelf[j][i].getColor() == ColorItem.GREEN) {
                        g = 1;

                    }
                    if (myshelf[j][i].getColor() == ColorItem.YELLOW) {
                        y = 1;
                    }

                    if (myshelf[j][i].getColor() == ColorItem.AZURE) {
                        a = 1;

                    }

                }
            }
                sum= (b+w+p+g+y+a);
            if (sum<=3){

                numOfCond++;}
        }

        return numOfCond > 3;
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

