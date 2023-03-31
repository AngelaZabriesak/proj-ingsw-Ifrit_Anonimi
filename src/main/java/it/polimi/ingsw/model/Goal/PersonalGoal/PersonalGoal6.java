package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.model.Bag.*;

public class PersonalGoal6 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private ColorItem[][] myItemGoal = new ColorItem[ROW][COL];

    public PersonalGoal6(){
        setDescription("personal goal 6");
        myItemGoal[5][0] = ColorItem.PINK;
        myItemGoal[4][3] = ColorItem.BLUE;
        myItemGoal[0][4] = ColorItem.GREEN;
        myItemGoal[2][3] = ColorItem.WHITE;
        myItemGoal[4][1] = ColorItem.YELLOW;
        myItemGoal[0][2] = ColorItem.AZURE;
    }

}