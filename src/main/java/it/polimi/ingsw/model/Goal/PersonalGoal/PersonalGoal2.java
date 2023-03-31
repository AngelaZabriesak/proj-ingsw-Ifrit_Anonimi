package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.model.Bag.*;

public class PersonalGoal2 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private ColorItem[][] myItemGoal = new ColorItem[ROW][COL];

    public PersonalGoal2(){
        setDescription("personal goal 2");
        myItemGoal[0][0] = ColorItem.PINK;
        myItemGoal[1][0] = ColorItem.BLUE;
        myItemGoal[1][5] = ColorItem.GREEN;
        myItemGoal[2][3] = ColorItem.WHITE;
        myItemGoal[3][1] = ColorItem.YELLOW;
        myItemGoal[5][2] = ColorItem.AZURE;
    }

}
