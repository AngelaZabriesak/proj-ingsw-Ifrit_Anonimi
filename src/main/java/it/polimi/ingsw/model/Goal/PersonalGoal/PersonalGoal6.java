package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.model.Bag.*;

public class PersonalGoal6 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    public PersonalGoal6(){
        setDescription("personal goal 6");
        myItemGoal[5][0] = new Item(ColorItem.PINK);
        myItemGoal[4][3] = new Item(ColorItem.BLUE);
        myItemGoal[0][4] = new Item(ColorItem.GREEN);
        myItemGoal[2][3] = new Item(ColorItem.WHITE);
        myItemGoal[4][1] = new Item(ColorItem.YELLOW);
        myItemGoal[0][2] = new Item(ColorItem.AZURE);
    }

}