package it.polimi.ingsw.Model.Goal.PersonalGoal;

import it.polimi.ingsw.Model.Bag.*;

public class PersonalGoal7 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    public PersonalGoal7(){
        setDescription("personal goal 7");
        myItemGoal[3][0] = new Item(ColorItem.PINK);
        myItemGoal[0][4] = new Item(ColorItem.BLUE);
        myItemGoal[1][1] = new Item(ColorItem.GREEN);
        myItemGoal[4][3] = new Item(ColorItem.WHITE);
        myItemGoal[5][3] = new Item(ColorItem.YELLOW);
        myItemGoal[2][2] = new Item(ColorItem.AZURE);
    }


    @Override
    public Item[][] getGoal() {
        return myItemGoal;
    }
}
