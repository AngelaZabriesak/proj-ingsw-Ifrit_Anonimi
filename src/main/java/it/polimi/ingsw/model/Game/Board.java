package it.polimi.ingsw.model.Game;

import it.polimi.ingsw.model.Bag.*;
import java.util.*;

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

    public void removeItem(int row,int col){
        myBoardItem[row][col] = null;
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
