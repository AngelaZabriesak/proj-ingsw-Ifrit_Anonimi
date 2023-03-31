package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.model.Bag.*;

public class PersonalGoal10 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private ColorItem[][] myItemGoal = new ColorItem[ROW][COL];

    public PersonalGoal10(){
        setDescription("personal goal 10");
        myItemGoal[5][3] = ColorItem.PINK;
        myItemGoal[4][1] = ColorItem.BLUE;
        myItemGoal[3][3] = ColorItem.GREEN;
        myItemGoal[2][0] = ColorItem.WHITE;
        myItemGoal[1][1] = ColorItem.YELLOW;
        myItemGoal[0][4] = ColorItem.AZURE;
    }

}