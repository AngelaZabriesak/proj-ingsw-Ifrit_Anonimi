package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.model.Bag.*;

public class PersonalGoal10 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    public PersonalGoal10(){
        setDescription("personal goal 10");
        myItemGoal[5][3] = new Item(ColorItem.PINK);
        myItemGoal[4][1] = new Item(ColorItem.BLUE);
        myItemGoal[3][3] = new Item(ColorItem.GREEN);
        myItemGoal[2][0] = new Item(ColorItem.WHITE);
        myItemGoal[1][1] = new Item(ColorItem.YELLOW);
        myItemGoal[0][4] = new Item(ColorItem.AZURE);
    }

}