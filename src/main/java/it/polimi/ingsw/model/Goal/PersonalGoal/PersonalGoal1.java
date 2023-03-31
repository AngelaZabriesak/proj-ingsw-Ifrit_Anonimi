package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.model.Bag.*;

public class PersonalGoal1 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private ColorItem[][] myItemGoal = new ColorItem[ROW][COL];

    public PersonalGoal1(){
        setDescription("personal goal 1");
        myItemGoal[1][1] = ColorItem.PINK;
        myItemGoal[5][4] = ColorItem.BLUE;
        myItemGoal[2][0] = ColorItem.GREEN;
        myItemGoal[3][4] = ColorItem.WHITE;
        myItemGoal[2][2] = ColorItem.YELLOW;
        myItemGoal[4][3] = ColorItem.AZURE;
    }

}
