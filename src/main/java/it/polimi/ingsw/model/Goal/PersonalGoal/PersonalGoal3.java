package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.model.Bag.*;

public class PersonalGoal3 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private ColorItem[][] myItemGoal = new ColorItem[ROW][COL];

    public PersonalGoal3(){
        setDescription("personal goal 3");
        myItemGoal[2][2] = ColorItem.PINK;
        myItemGoal[1][0] = ColorItem.BLUE;
        myItemGoal[3][1] = ColorItem.GREEN;
        myItemGoal[5][0] = ColorItem.WHITE;
        myItemGoal[1][3] = ColorItem.YELLOW;
        myItemGoal[3][4] = ColorItem.AZURE;
    }

}
