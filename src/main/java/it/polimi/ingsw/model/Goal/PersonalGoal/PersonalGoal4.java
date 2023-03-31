package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.model.Bag.*;

public class PersonalGoal4 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private ColorItem[][] myItemGoal = new ColorItem[ROW][COL];

    public PersonalGoal4(){
        setDescription("personal goal 4");
        myItemGoal[3][3] = ColorItem.PINK;
        myItemGoal[2][2] = ColorItem.BLUE;
        myItemGoal[4][2] = ColorItem.GREEN;
        myItemGoal[4][1] = ColorItem.WHITE;
        myItemGoal[0][4] = ColorItem.YELLOW;
        myItemGoal[2][0] = ColorItem.AZURE;
    }

}