package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.model.Bag.*;

public class PersonalGoal8 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private ColorItem[][] myItemGoal = new ColorItem[ROW][COL];

    public PersonalGoal8(){
        setDescription("personal goal 8");
        myItemGoal[3][0] = ColorItem.PINK;
        myItemGoal[0][4] = ColorItem.BLUE;
        myItemGoal[1][1] = ColorItem.GREEN;
        myItemGoal[4][3] = ColorItem.WHITE;
        myItemGoal[5][3] = ColorItem.YELLOW;
        myItemGoal[2][2] = ColorItem.AZURE;
    }

}