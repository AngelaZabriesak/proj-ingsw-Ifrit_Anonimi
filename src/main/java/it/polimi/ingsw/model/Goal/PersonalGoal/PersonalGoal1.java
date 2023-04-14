package it.polimi.ingsw.Model.Goal.PersonalGoal;

import it.polimi.ingsw.Model.Bag.*;

public class PersonalGoal1 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    public PersonalGoal1(){
        setDescription("personal goal 1");
        myItemGoal[1][1] = new Item(ColorItem.PINK);
        myItemGoal[5][4] = new Item(ColorItem.BLUE);
        myItemGoal[2][0] = new Item(ColorItem.GREEN);
        myItemGoal[3][4] = new Item(ColorItem.WHITE);
        myItemGoal[2][2] = new Item(ColorItem.YELLOW);
        myItemGoal[4][3] = new Item(ColorItem.AZURE);
    }

}
