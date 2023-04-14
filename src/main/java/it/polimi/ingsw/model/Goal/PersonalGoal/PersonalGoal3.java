package it.polimi.ingsw.Model.Goal.PersonalGoal;

import it.polimi.ingsw.Model.Bag.*;

public class PersonalGoal3 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    public PersonalGoal3(){
        setDescription("personal goal 3");
        myItemGoal[3][3] = new Item(ColorItem.PINK);
        myItemGoal[2][2] = new Item(ColorItem.BLUE);
        myItemGoal[4][2] = new Item(ColorItem.GREEN);
        myItemGoal[4][1] = new Item(ColorItem.WHITE);
        myItemGoal[0][4] = new Item(ColorItem.YELLOW);
        myItemGoal[2][0] = new Item(ColorItem.AZURE);
    }

}
