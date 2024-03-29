package it.polimi.ingsw.Model.Goal.PersonalGoal;

import it.polimi.ingsw.Model.Bag.*;

public class PersonalGoal6 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    /**
     * PGoal 6 setting
     */

    public PersonalGoal6(){
        setDescription("personal goal 6");
        myItemGoal[2][1] = new Item(ColorItem.PINK);
        myItemGoal[1][3] = new Item(ColorItem.BLUE);
        myItemGoal[0][0] = new Item(ColorItem.GREEN);
        myItemGoal[5][2] = new Item(ColorItem.WHITE);
        myItemGoal[4][4] = new Item(ColorItem.YELLOW);
        myItemGoal[3][0] = new Item(ColorItem.AZURE);
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