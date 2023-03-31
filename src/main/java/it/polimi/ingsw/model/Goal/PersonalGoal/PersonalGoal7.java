package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.model.Bag.*;

public class PersonalGoal7 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private ColorItem[][] myItemGoal = new ColorItem[ROW][COL];

    public PersonalGoal7(){
        setDescription("personal goal 7");
        myItemGoal[2][1] = ColorItem.PINK;
        myItemGoal[1][3] = ColorItem.BLUE;
        myItemGoal[0][0] = ColorItem.GREEN;
        myItemGoal[5][2] = ColorItem.WHITE;
        myItemGoal[4][4] = ColorItem.YELLOW;
        myItemGoal[3][0] = ColorItem.AZURE;
    }

}
