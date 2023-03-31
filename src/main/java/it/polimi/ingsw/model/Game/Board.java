package it.polimi.ingsw.model.Game;

import it.polimi.ingsw.model.Bag.*;
import java.util.*;

/**
 * 0 = 0 side of the cell are free
 * 1 = 1 side of the cell is free
 * 2 = 2 sides of the cell is free
 * 3 = 3 sides of the cell is free
 * 4 = all sides of the cell are free
 * 9 = the item is black
 * 7 = the box is null
 */

public class Board {
    private static final int ROW = 9;
    private static final int COL = 9;
    private int myBoardAdjacency[][];
    private Item myBoardItem[][];

    public Board() {
        myBoardAdjacency = new int[ROW][COL];
        for(int r=0; r<ROW; r++)
            for(int c=0; c<COL; c++)
                    myBoardAdjacency[r][c]=0;
        myBoardItem = new Item[ROW][COL];
    }

    public void setMyBoardAdjacency(){
        for(int r=0; r<ROW; r++){
            for(int c=0; c<COL; c++){
                if(myBoardItem[r][c].getColor().equals(ColorItem.BLACK))
                    myBoardAdjacency[r][c]=9;
                else {
                    if (r > 0 && !(myBoardItem[r - 1][c].getColor().equals(ColorItem.BLACK) || myBoardItem[r - 1][c] == null))
                        myBoardAdjacency[r][c] += 1;
                    if (r < ROW-1 && !(myBoardItem[r + 1][c].getColor().equals(ColorItem.BLACK) || myBoardItem[r + 1][c] == null))
                        myBoardAdjacency[r][c] += 1;
                    if (c > 0 && !(myBoardItem[r][c - 1].getColor().equals(ColorItem.BLACK) || myBoardItem[r][c - 1] == null))
                        myBoardAdjacency[r][c] += 1;
                    if (c < COL-1 && !(myBoardItem[r][c + 1].getColor().equals(ColorItem.BLACK) || myBoardItem[r][c + 1] == null))
                        myBoardAdjacency[r][c] += 1;
                }
            }
        }
    }

    /**
     *   indicate which item can be chosen
     */
    public void setPositionAvailable() {

    }

    public int getRow(){
        return ROW;
    }

    public int getCol(){
        return COL;
    }

    /**
     *  select item to remove
     */
    public Item getItem (int row, int col){
        return myBoardItem[row][col];
    }

    public void removeItem(int row, int col){
        myBoardItem[row][col] = null;
        myBoardAdjacency[row][col]=7;
    }

    public void updateNeighboursAdjacency(int row, int col){
        if(row>0 && myBoardItem[row-1][col]!=null){
            if(!(myBoardItem[row-1][col].getColor().equals(ColorItem.BLACK)))
                myBoardAdjacency[row-1][col]-=1;
        }

        if(row<ROW-1 && myBoardItem[row+1][col]!=null){
            if(!(myBoardItem[row+1][col].getColor().equals(ColorItem.BLACK)))
                myBoardAdjacency[row+1][col]-=1;
        }

        if(col>0 && myBoardItem[row][col-1]!=null){
            if(!(myBoardItem[row][col-1].getColor().equals(ColorItem.BLACK)))
                myBoardAdjacency[row][col-1]-=1;
        }

        if(col<COL-1 && myBoardItem[row][col+1]!=null){
            if(!(myBoardItem[row][col+1].getColor().equals(ColorItem.BLACK)))
                myBoardAdjacency[row][col+1]-=1;
        }
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
