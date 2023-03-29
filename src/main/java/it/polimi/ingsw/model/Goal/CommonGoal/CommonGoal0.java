package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.Item;

public class CommonGoal0 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
    private Item[][] myItemGoal = new Item[ROW][COL];

    public CommonGoal0(){
        setDescription("common goal 0\nSei gruppi separati formati ciascuno da 2 tessere adiacenti dello stesso tipo");
    }

}
