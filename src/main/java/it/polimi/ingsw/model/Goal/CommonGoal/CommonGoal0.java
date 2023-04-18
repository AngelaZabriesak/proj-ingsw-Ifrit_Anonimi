package it.polimi.ingsw.Model.Goal.CommonGoal;

import it.polimi.ingsw.Model.Game.CreateItemGroup;
import it.polimi.ingsw.Model.Position;
import it.polimi.ingsw.Model.Shelf;

import java.util.ArrayList;

/* common goal 0 :
                    six groups each containing at least 2 tiles of the same type,
                    the tiles pf one group can be different from those of another group */

public class CommonGoal0 extends Cgoal {

    private static final int ROW = 6;
    private static final int COL = 5;


    public CommonGoal0() {
        setDescription("common goal 0: six groups each containing at least 2 tiles of the same type,the tiles pf one group can be different from those of another group\n");
        setIndex(0);
    }

    @Override
    public boolean isTaken(Shelf myShelf) {

        ArrayList<Position>[] groups = new CreateItemGroup().creaGruppi(myShelf);
        int numOfCond=0;

        for (int i=0; i<= groups.length; i++) {
            if (groups[i]!=null) {
                ArrayList<Position> group = groups[i];
                numOfCond += group.size() / 2;
                if (numOfCond >= 6) {
                    break;
                }
            }
        }
        return numOfCond >= 6;
    }
}

