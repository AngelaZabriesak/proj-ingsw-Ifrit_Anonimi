package it.polimi.ingsw.Model.Game;

import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Model.Position;

/**
 * 0 = 0 side of the cell are free
 * 1 = 1 side of the cell is free
 * 2 = 2 sides of the cell is free
 * 3 = 3 sides of the cell is free
 * 4 = all sides of the cell are free
 * 9 = the item is black
 * 7 = the cell is null
 */

public class Board {
    private static final int ROW = 9;
    private static final int COL = 9;
    private final int[][] myBoardAdjacency;
    private final Item[][] myBoardItem;

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
    public Item getItem (Position p){
        return myBoardItem[p.getRow()][p.getCol()];
    }

    public void removeItem(Position p){
        myBoardItem[p.getRow()][p.getCol()] = null;
        myBoardAdjacency[p.getRow()][p.getCol()]=7;
    }

    public void updateNeighboursAdjacency(Position p){
        if(p.getRow()>0 && myBoardItem[p.getRow()-1][p.getCol()]!=null){
            if(!(myBoardItem[p.getRow()-1][p.getCol()].getColor().equals(ColorItem.BLACK)))
                myBoardAdjacency[p.getRow()-1][p.getCol()]-=1;
        }

        if(p.getRow()<ROW-1 && myBoardItem[p.getRow()+1][p.getCol()]!=null){
            if(!(myBoardItem[p.getRow()+1][p.getCol()].getColor().equals(ColorItem.BLACK)))
                myBoardAdjacency[p.getRow()+1][p.getCol()]-=1;
        }

        if(p.getCol()>0 && myBoardItem[p.getRow()][p.getCol()-1]!=null){
            if(!(myBoardItem[p.getRow()][p.getCol()-1].getColor().equals(ColorItem.BLACK)))
                myBoardAdjacency[p.getRow()][p.getCol()-1]-=1;
        }

        if(p.getCol()<COL-1 && myBoardItem[p.getRow()][p.getCol()+1]!=null){
            if(!(myBoardItem[p.getRow()][p.getCol()+1].getColor().equals(ColorItem.BLACK)))
                myBoardAdjacency[p.getRow()][p.getCol()+1]-=1;
        }
    }

    /**
     *
     */
    public int getAdjacency(Position p){
        return myBoardAdjacency[p.getRow()][p.getCol()];
    }

    public Item[][] getMyBoardItem(){
        return myBoardItem;
    }
    public int[][] getMyBoardAdjacency(){
        return myBoardAdjacency;
    }
}
