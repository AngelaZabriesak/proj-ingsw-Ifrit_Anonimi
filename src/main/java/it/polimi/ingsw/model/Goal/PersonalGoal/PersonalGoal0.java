package it.polimi.ingsw.Model.Goal.PersonalGoal;

import it.polimi.ingsw.Model.Bag.*;



public class PersonalGoal0 extends Pgoal{
    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];


    /**
     * PGoal 0 setting
     */

    public PersonalGoal0(){
        setDescription("personal goal 0");
        myItemGoal[0][0] = new Item(ColorItem.PINK);
        myItemGoal[0][2] = new Item(ColorItem.BLUE);
        myItemGoal[1][4] = new Item(ColorItem.GREEN);
        myItemGoal[2][3] = new Item(ColorItem.WHITE);
        myItemGoal[3][1] = new Item(ColorItem.YELLOW);
        myItemGoal[5][2] = new Item(ColorItem.AZURE);
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
