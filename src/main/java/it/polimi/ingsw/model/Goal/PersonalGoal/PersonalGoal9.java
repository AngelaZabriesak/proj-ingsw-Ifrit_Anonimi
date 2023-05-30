package it.polimi.ingsw.Model.Goal.PersonalGoal;

import it.polimi.ingsw.Model.Bag.*;

public class PersonalGoal9 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    /**
     * PGoal 9 setting
     */

    public PersonalGoal9(){
        setDescription("personal goal 9");
        myItemGoal[5][3] = new Item(ColorItem.PINK);
        myItemGoal[4][1] = new Item(ColorItem.BLUE);
        myItemGoal[3][3] = new Item(ColorItem.GREEN);
        myItemGoal[2][0] = new Item(ColorItem.WHITE);
        myItemGoal[1][1] = new Item(ColorItem.YELLOW);
        myItemGoal[0][4] = new Item(ColorItem.AZURE);
    }

    /**
     *
     * @return the player pGoal
     *
     */

    @Override
    public Item[][] getGoal() {
        return myItemGoal;
    }
}