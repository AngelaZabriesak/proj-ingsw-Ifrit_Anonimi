package it.polimi.ingsw.model;

public class Board {
    // aggiungere adjacency
    private static final int ROW = 9;
    private static final int COL = 9;
    int myBoard[][] = new int[ROW][COL];

    public Board() {

    }

    /**
     *   indicate which item can be chosen
     */
    public void setPositionAvailable() {}

    /**
     *  select item to remove
     */
    public int getItem (int row, int col){
        return myBoard[row][col];
    }
}
