package it.polimi.ingsw.model;

import it.polimi.ingsw.model.Bag.ColorItem;
import it.polimi.ingsw.model.Goal;



public class Pgoal extends Goal {

    private static final int ROW = 6;
    private static final int COL = 5;
    private ColorItem[][] myPgoal = new ColorItem[ROW][COL];


    /**
     * function that generates personal goal cards on extracted card number
     */
    public Pgoal CreatePgoal(int n){
        switch (n){
            case 1:
                myPgoal[0][0] = ColorItem.PINK;
                myPgoal[1][0] = ColorItem.BLUE;
                myPgoal[1][5] = ColorItem.GREEN;
                myPgoal[2][3] = ColorItem.WHITE;
                myPgoal[3][1] = ColorItem.YELLOW;
                myPgoal[5][2] = ColorItem.TURQUOISE;
                break;

            case 2:
                myPgoal[1][1] = ColorItem.PINK;
                myPgoal[5][4] = ColorItem.BLUE;
                myPgoal[2][0] = ColorItem.GREEN;
                myPgoal[3][4] = ColorItem.WHITE;
                myPgoal[2][2] = ColorItem.YELLOW;
                myPgoal[4][3] = ColorItem.TURQUOISE;
                break;

            case 3:
                myPgoal[2][2] = ColorItem.PINK;
                myPgoal[1][0] = ColorItem.BLUE;
                myPgoal[3][1] = ColorItem.GREEN;
                myPgoal[5][0] = ColorItem.WHITE;
                myPgoal[1][3] = ColorItem.YELLOW;
                myPgoal[3][4] = ColorItem.TURQUOISE;
                break;

            case 4:
                myPgoal[3][3] = ColorItem.PINK;
                myPgoal[2][2] = ColorItem.BLUE;
                myPgoal[4][2] = ColorItem.GREEN;
                myPgoal[4][1] = ColorItem.WHITE;
                myPgoal[0][4] = ColorItem.YELLOW;
                myPgoal[2][0] = ColorItem.TURQUOISE;
                break;

            case 5:
                myPgoal[4][4] = ColorItem.PINK;
                myPgoal[3][1] = ColorItem.BLUE;
                myPgoal[5][3] = ColorItem.GREEN;
                myPgoal[3][2] = ColorItem.WHITE;
                myPgoal[5][0] = ColorItem.YELLOW;
                myPgoal[3][3] = ColorItem.TURQUOISE;
                break;

            case 6:
                myPgoal[5][0] = ColorItem.PINK;
                myPgoal[4][3] = ColorItem.BLUE;
                myPgoal[0][4] = ColorItem.GREEN;
                myPgoal[2][3] = ColorItem.WHITE;
                myPgoal[4][1] = ColorItem.YELLOW;
                myPgoal[0][2] = ColorItem.TURQUOISE;
                break;

            case 7:
                myPgoal[2][1] = ColorItem.PINK;
                myPgoal[1][3] = ColorItem.BLUE;
                myPgoal[0][0] = ColorItem.GREEN;
                myPgoal[5][2] = ColorItem.WHITE;
                myPgoal[4][4] = ColorItem.YELLOW;
                myPgoal[3][0] = ColorItem.TURQUOISE;
                break;

            case 8:
                myPgoal[3][0] = ColorItem.PINK;
                myPgoal[0][4] = ColorItem.BLUE;
                myPgoal[1][1] = ColorItem.GREEN;
                myPgoal[4][3] = ColorItem.WHITE;
                myPgoal[5][3] = ColorItem.YELLOW;
                myPgoal[2][2] = ColorItem.TURQUOISE;
                break;

            case 9:
                myPgoal[4][4] = ColorItem.PINK;
                myPgoal[5][0] = ColorItem.BLUE;
                myPgoal[2][2] = ColorItem.GREEN;
                myPgoal[3][4] = ColorItem.WHITE;
                myPgoal[0][2] = ColorItem.YELLOW;
                myPgoal[4][1] = ColorItem.TURQUOISE;
                break;

            case 10:
                myPgoal[5][3] = ColorItem.PINK;
                myPgoal[4][1] = ColorItem.BLUE;
                myPgoal[3][3] = ColorItem.GREEN;
                myPgoal[2][0] = ColorItem.WHITE;
                myPgoal[1][1] = ColorItem.YELLOW;
                myPgoal[0][4] = ColorItem.TURQUOISE;
                break;

            case 11:
                myPgoal[0][2] = ColorItem.PINK;
                myPgoal[3][2] = ColorItem.BLUE;
                myPgoal[4][4] = ColorItem.GREEN;
                myPgoal[1][1] = ColorItem.WHITE;
                myPgoal[2][0] = ColorItem.YELLOW;
                myPgoal[5][3] = ColorItem.TURQUOISE;
                break;

            case 12:
                myPgoal[1][1] = ColorItem.PINK;
                myPgoal[2][2] = ColorItem.BLUE;
                myPgoal[5][0] = ColorItem.GREEN;
                myPgoal[0][2] = ColorItem.WHITE;
                myPgoal[4][4] = ColorItem.YELLOW;
                myPgoal[3][3] = ColorItem.TURQUOISE;
                break;

            }
        return this;
    }
}


