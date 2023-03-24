package it.polimi.ingsw.model;

import it.polimi.ingsw.model.Bag.Item;

import java.util.HashMap;

public class Board {
    // aggiungere adjacency
    private static final int ROW = 9;
    private static final int COL = 9;
    HashMap<Item,Integer> myBoard[][] = new HashMap[ROW][COL];

    public Board() {


    }

    /**
     *   indicate which item can be chosen
     */
    public void setPositionAvailable() {}

    /**
     *  select item to remove
     */
    public HashMap getItem (int row, int col){
        return myBoard[row][col];
    }
}
