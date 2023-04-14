package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.ColorItem;
import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Shelf;

/* common goal 4:
                 three columns each formed by 6 tiles maximum three different types.
                 one column can show the same or a different combination of another column */

public class CommonGoal4 extends Cgoal {

    private static final int ROW = 6;
    private static final int COL = 5;
    private int numOfCond = 0;                 // for this goal >2 at the end

    public CommonGoal4() {
        setDescription("common goal 4:three columns each formed by 6 tiles maximum three different types. One column can show the same or a different combination of another column\n");
        setIndex(4);
    }

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

        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {

                if (myshelf[j][i].getColor() == null){

                    break; }

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

            } sum= (b+w+p+g+y+a);
            if (sum<=3){

                numOfCond++;}
        }
        return numOfCond > 2;
    }
}

