package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.ColorItem;
import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Token;

// common goal 1:
// four tiles of the same type in the four corners of the bookshelf

public class CommonGoal1 extends Cgoal {



    public CommonGoal1() {
        setDescription("common goal 1:four tiles of the same type in the four corners of the bookshelf\n");
        setIndex(1);

    }

      if(myItemGoal[0][0] = Item[0][4] = Item[5][0] = Item[5][4]){
        numOfCond++;
    }

    public boolean CheckCondition(){

        if(numOfCond>0){
            return true;
        }
        return false;
    }
