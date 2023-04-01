package it.polimi.ingsw.model.Goal.PersonalGoal;

import it.polimi.ingsw.model.Bag.*;

public class PersonalGoal2 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    public PersonalGoal2(){
        setDescription("personal goal 2");
        myItemGoal[0][0] = new Item(ColorItem.PINK);
        myItemGoal[1][0] = new Item(ColorItem.BLUE);
        //myItemGoal[1][5] = new Item(ColorItem.GREEN);
        myItemGoal[2][3] = new Item(ColorItem.WHITE);
        myItemGoal[3][1] = new Item(ColorItem.YELLOW);
        myItemGoal[5][2] = new Item(ColorItem.AZURE);
    }

}
