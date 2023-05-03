package it.polimi.ingsw.Model.Goal.PersonalGoal;

import it.polimi.ingsw.Model.Bag.*;

public class PersonalGoal11 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;

    private Item[][] myItemGoal = new Item[ROW][COL];
    public PersonalGoal11(){
        super();
        setDescription("personal goal 11");
        myItemGoal[1][1] = new Item(ColorItem.PINK);
        myItemGoal[2][2] = new Item(ColorItem.BLUE);
        myItemGoal[5][0] = new Item(ColorItem.GREEN);
        myItemGoal[0][2] = new Item(ColorItem.WHITE);
        myItemGoal[4][4] = new Item(ColorItem.YELLOW);
        myItemGoal[3][3] = new Item(ColorItem.AZURE);
    }


    @Override
    public Item[][] getGoal() {
        return myItemGoal;
    }
}