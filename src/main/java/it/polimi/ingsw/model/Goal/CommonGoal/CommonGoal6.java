package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Token;

//common goal 6:
//five tiles of the same type forming a diagonal

public class CommonGoal6 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];
    private int numOfCond = 0;                 // for this goal >0 at the end

    public CommonGoal6(){
        setDescription("common goal 6:five tiles of the same type forming a diagonal\n");
        setIndex(6);
        myItemGoal[0][0] = myItemGoal[1][1]=myItemGoal[2][2]=myItemGoal[3][3]=myItemGoal[4][4];
        myItemGoal[0][4] = myItemGoal[1][3]=myItemGoal[2][2]=myItemGoal[3][1]=myItemGoal[4][0];
        myItemGoal[5][0] = myItemGoal[4][1]=myItemGoal[3][2]=myItemGoal[2][3]=myItemGoal[1][4];
        myItemGoal[5][4] = myItemGoal[4][3]=myItemGoal[3][2]=myItemGoal[2][1]=myItemGoal[1][0];



    }


}
