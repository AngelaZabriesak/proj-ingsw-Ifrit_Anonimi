package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.model.Bag.*;

public class PersonalGoal11 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private ColorItem[][] myItemGoal = new ColorItem[ROW][COL];

    public PersonalGoal11(){
        setDescription("personal goal 11");
        myItemGoal[0][2] = ColorItem.PINK;
        myItemGoal[3][2] = ColorItem.BLUE;
        myItemGoal[4][4] = ColorItem.GREEN;
        myItemGoal[1][1] = ColorItem.WHITE;
        myItemGoal[2][0] = ColorItem.YELLOW;
        myItemGoal[5][3] = ColorItem.AZURE;
    }

}