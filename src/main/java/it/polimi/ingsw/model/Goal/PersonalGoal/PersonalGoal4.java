package it.polimi.ingsw.Model.Goal.PersonalGoal;

import it.polimi.ingsw.Model.Bag.*;

public class PersonalGoal4 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    public PersonalGoal4(){
        setDescription("personal goal 4");
        myItemGoal[4][4] = new Item(ColorItem.PINK);
        myItemGoal[3][1] = new Item(ColorItem.BLUE);
        myItemGoal[5][3] = new Item(ColorItem.GREEN);
        myItemGoal[3][2] = new Item(ColorItem.WHITE);
        myItemGoal[5][0] = new Item(ColorItem.YELLOW);
        myItemGoal[1][1] = new Item(ColorItem.AZURE);
    }


    @Override
    public Item[][] getGoal() {
        return myItemGoal;
    }
}