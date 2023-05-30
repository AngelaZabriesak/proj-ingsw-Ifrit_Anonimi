package it.polimi.ingsw.Model;

import java.io.Serializable;

/**
 *
 * generic class that implement the returning position in a matrix in different parts in game
 *
 */

public class Position implements Serializable {
    private final int row;
    private final int col;
    public boolean check = false;


    /**
     *
     * @param row   row of a matrix
     * @param col   col of a matrix
     */
    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }

    /**
     *
     * @return col
     */

    public int getCol(){
        return col;
    }

    /**
     *
     * @return row
     */
    public int getRow(){
        return row;
    }

    public void setCheck(){
        this.check = true;
    }
}
