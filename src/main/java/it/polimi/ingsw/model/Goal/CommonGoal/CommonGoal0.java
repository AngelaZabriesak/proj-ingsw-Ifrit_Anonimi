package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Shelf;
import it.polimi.ingsw.model.Token;

/* common goal 0 :
                    six groups each containing at least 2 tiles of the same type,
                    the tiles pf one group can be different from those of another group */

public class CommonGoal0 extends Cgoal {

    private static final int ROW = 6;
    private static final int COL = 5;
    // for this goal >5 at the end


    public boolean CommonGoal0(Shelf CShelf) {
        setDescription("common goal 0: six groups each containing at least 2 tiles of the same type,the tiles pf one group can be different from those of another group\n");
        setIndex(0);
       /* Item[][] myshelf = CShelf.getMyShelf();
        Item[][] myshelfcpy = CShelf.getMyShelf();
        int numOfCond = 0;     // for this goal ==6
        for (int i=0; i<ROW; i++){
            for (int j=0; j<COL; j++){
                if
                ((myshelf[i][j].getColor() != null) &&
                ((myshelf[i][j].getColor() == myshelf[i+1][j].getColor()) ||
                (myshelf[i][j].getColor() == myshelf[i][j+1].getColor())) &&
                (myshelf[i][j].getColor() == myshelfcpy[i][j].getColor()))
                {numOfCond++;
                myshelfcpy[i][j] = null;}
                return numOfCond ==6;
            }
        }
        return false;
    }




/* va eliminata l'intera coppia dalla matrice copia; quindi vanno separati i due casi per poter eliminare
eventualmente quella giusta, aggiustare il return, assicurarsi che si possano verificare due possibilità
 */

        return true;
    }

    @Override
    boolean isTaken(Shelf myShelf) {
        return false;
    }
}
