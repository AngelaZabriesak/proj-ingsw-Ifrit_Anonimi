package it.polimi.ingsw.Model.Goal.PersonalGoal;

import it.polimi.ingsw.Model.Bag.*;

public class PersonalGoal8 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];


    /**
     * PGoal 8 setting
     */

    public PersonalGoal8(){
        setDescription("personal goal 8");
        myItemGoal[4][4] = new Item(ColorItem.PINK);
        myItemGoal[5][0] = new Item(ColorItem.BLUE);
        myItemGoal[2][2] = new Item(ColorItem.GREEN);
        myItemGoal[3][4] = new Item(ColorItem.WHITE);
        myItemGoal[0][2] = new Item(ColorItem.YELLOW);
        myItemGoal[4][1] = new Item(ColorItem.AZURE);
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