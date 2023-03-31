package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.model.Bag.*;

public class PersonalGoal9 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    public PersonalGoal9(){
        setDescription("personal goal 9");
        myItemGoal[4][4] = new Item(ColorItem.PINK);
        myItemGoal[5][0] = new Item(ColorItem.BLUE);
        myItemGoal[2][2] = new Item(ColorItem.GREEN);
        myItemGoal[3][4] = new Item(ColorItem.WHITE);
        myItemGoal[0][2] = new Item(ColorItem.YELLOW);
        myItemGoal[4][1] = new Item(ColorItem.AZURE);
    }

}