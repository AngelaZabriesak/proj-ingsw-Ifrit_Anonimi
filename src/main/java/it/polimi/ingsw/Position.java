package it.polimi.ingsw;

public class Position {
    private final int row;
    private final int col;
    public boolean check = false;

    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }

    public int getCol(){
        return col;
    }
    public int getRow(){
        return row;
    }

    public boolean getCheck() {
        return check;
    }

    public void setCheck(){
        this.check = true;
    }
}
