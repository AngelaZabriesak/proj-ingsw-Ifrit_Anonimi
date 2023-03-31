package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.model.Bag.*;

public class PersonalGoal3 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    public PersonalGoal3(){
        setDescription("personal goal 3");
        myItemGoal[2][2] = new Item(ColorItem.PINK);
        myItemGoal[1][0] = new Item(ColorItem.BLUE);
        myItemGoal[3][1] = new Item(ColorItem.GREEN);
        myItemGoal[5][0] = new Item(ColorItem.WHITE);
        myItemGoal[1][3] = new Item(ColorItem.YELLOW);
        myItemGoal[3][4] = new Item(ColorItem.AZURE);
    }

}
