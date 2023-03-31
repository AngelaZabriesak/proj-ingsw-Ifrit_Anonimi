package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.model.Bag.*;

public class PersonalGoal5 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private ColorItem[][] myItemGoal = new ColorItem[ROW][COL];

    public PersonalGoal5(){
        setDescription("personal goal 5");
        myItemGoal[4][4] = ColorItem.PINK;
        myItemGoal[3][1] = ColorItem.BLUE;
        myItemGoal[5][3] = ColorItem.GREEN;
        myItemGoal[3][2] = ColorItem.WHITE;
        myItemGoal[5][0] = ColorItem.YELLOW;
        myItemGoal[3][3] = ColorItem.AZURE;
    }

}