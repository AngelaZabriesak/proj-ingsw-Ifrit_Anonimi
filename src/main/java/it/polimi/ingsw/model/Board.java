package it.polimi.ingsw.model;

import it.polimi.ingsw.model.Bag.Item;

public class Board {
    // aggiungere adjacency
    private static final int ROW = 9;
    private static final int COL = 9;
    int myBoardAdjacency[][];
    Item myBoardItem[][];

    public Board() {
        myBoardAdjacency = new int[ROW][COL];
        for(int r = 0;r<ROW;r++){
            for( int c = 0; c<COL; c++)
                myBoardAdjacency[r][c]=0;
        }
        myBoardItem = new Item[ROW][COL];
        for(int r = 0;r<ROW;r++){
            for( int c = 0; c<COL; c++)
                myBoardItem[r][c]=null;
        }
    }

    /**
     *   indicate which item can be chosen
     */
    public void setPositionAvailable() {

    }

    /**
     *  select item to remove
     */
    public Item getItem (int row, int col){
        return myBoardItem[row][col];
    }

    /**
     *
     */
    public int getAdjacency(int row, int col){
        return myBoardAdjacency[row][col];
    }

    public Item[][] getMyBoardItem(){
        return myBoardItem;
    }
    public int[][] getMyBoardAdjacency(){
        return myBoardAdjacency;
    }
}
