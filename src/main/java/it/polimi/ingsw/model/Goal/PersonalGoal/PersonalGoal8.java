package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.model.Bag.*;

public class PersonalGoal8 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    public PersonalGoal8(){
        setDescription("personal goal 8");
        myItemGoal[3][0] = new Item(ColorItem.PINK);
        myItemGoal[0][4] = new Item(ColorItem.BLUE);
        myItemGoal[1][1] = new Item(ColorItem.GREEN);
        myItemGoal[4][3] = new Item(ColorItem.WHITE);
        myItemGoal[5][3] = new Item(ColorItem.YELLOW);
        myItemGoal[2][2] = new Item(ColorItem.AZURE);
    }

}