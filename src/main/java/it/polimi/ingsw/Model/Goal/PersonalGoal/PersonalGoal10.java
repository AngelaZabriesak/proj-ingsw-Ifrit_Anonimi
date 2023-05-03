package it.polimi.ingsw.Model.Goal.PersonalGoal;

import it.polimi.ingsw.Model.Bag.*;

public class PersonalGoal10 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    public PersonalGoal10(){
        setDescription("personal goal 10");
        myItemGoal[0][2] = new Item(ColorItem.PINK);
        myItemGoal[3][2] = new Item(ColorItem.BLUE);
        myItemGoal[4][4] = new Item(ColorItem.GREEN);
        myItemGoal[1][1] = new Item(ColorItem.WHITE);
        myItemGoal[2][0] = new Item(ColorItem.YELLOW);
        myItemGoal[5][3] = new Item(ColorItem.AZURE);
    }


    @Override
    public Item[][] getGoal() {
        return myItemGoal;
    }
}