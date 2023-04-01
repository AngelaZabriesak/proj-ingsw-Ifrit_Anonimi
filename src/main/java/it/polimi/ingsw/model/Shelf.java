package it.polimi.ingsw.model;

import it.polimi.ingsw.model.Bag.Item;

import java.util.ArrayList;

// the [0][0] element of the matrix is the north-west element

public class Shelf {
    private static final int ROW = 6;
    private static final int COL = 5;
    private Item myShelf[][] = new Item[ROW][COL];

    public int getFreeRowByColumn(int col){
        int free=0;
        for(int r=0; r<ROW; r++){
            if(myShelf[r][col]==null){
                free++;
            }
        }
        return free;
    }

    public Item[][] getMyShelf(){
        return myShelf;
    }

    public void setMyShelf(int row, int col,Item i){
        myShelf[row][col] = i;
    }

    public int getRow(){
        return ROW;
    }

    /**
     * @return the number of cells empty
     */
    public int getNEmpty(){
        int nEmpty = ROW*COL;
        for(int r = 0; r < ROW ; r++) {
            for (int c = 0; c < COL; c++) {
                if(myShelf[r][c]!=null)
                    nEmpty--;
            }
        }
        return nEmpty;
    }

}
