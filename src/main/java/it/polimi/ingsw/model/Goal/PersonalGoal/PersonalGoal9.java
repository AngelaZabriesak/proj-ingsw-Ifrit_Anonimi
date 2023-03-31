package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.model.Bag.*;

public class PersonalGoal9 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private ColorItem[][] myItemGoal = new ColorItem[ROW][COL];

    public PersonalGoal9(){
        setDescription("personal goal 9");
        myItemGoal[4][4] = ColorItem.PINK;
        myItemGoal[5][0] = ColorItem.BLUE;
        myItemGoal[2][2] = ColorItem.GREEN;
        myItemGoal[3][4] = ColorItem.WHITE;
        myItemGoal[0][2] = ColorItem.YELLOW;
        myItemGoal[4][1] = ColorItem.AZURE;
    }

}