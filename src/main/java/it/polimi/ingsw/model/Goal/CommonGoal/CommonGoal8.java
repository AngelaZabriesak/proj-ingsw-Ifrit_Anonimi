package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Token;
import it.polimi.ingsw.model.Shelf;


// common goal 8:
// two columns each formed by 6 different types of tiles

public class CommonGoal8 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    //private Item[][] myItemGoal = new Item[ROW][COL];


    public boolean CommonGoal8(Shelf CShelf){
        setDescription("common goal 8:two columns each formed by 6 different types of tiles\n");
        setIndex(8);
        Item[][] myshelf = CShelf.getMyShelf();
        int numOfCond = 0;
        int j=0;
        for  (int i=0; i<COL;i++){
           if
           (       myshelf[j][i] != myshelf[j+1][i] &&
                   myshelf[j][i] != myshelf[j+2][i] &&
                   myshelf[j][i] != myshelf[j+3][i] &&
                   myshelf[j][i] != myshelf[j+4][i] &&
                   myshelf[j][i] != myshelf[j+5][i] &&
                   myshelf[j+1][i] != myshelf[j+2][i] &&
                   myshelf[j+1][i] != myshelf[j+3][i] &&
                   myshelf[j+1][i] != myshelf[j+4][i] &&
                   myshelf[j+1][i] != myshelf[j+5][i] &&
                   myshelf[j+2][i] != myshelf[j+3][i] &&
                   myshelf[j+2][i] != myshelf[j+4][i] &&
                   myshelf[j+2][i] != myshelf[j+5][i] &&
                   myshelf[j+3][i] != myshelf[j+4][i] &&
                   myshelf[j+3][i] != myshelf[j+5][i] &&
                   myshelf[j+4][i] != myshelf[j+5][i])
               numOfCond++;
        }
        if (numOfCond>1) {return true;} else return false;

    }

}
