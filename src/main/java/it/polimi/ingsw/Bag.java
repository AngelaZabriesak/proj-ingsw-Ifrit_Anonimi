package it.polimi.ingsw;

import java.util.ArrayList;

public class Bag {

    // attributi
    private static final int SIZE = 6;
    private int[] numItem = new int[SIZE];
    //metodi

    public Bag() {

    }

    public int[] getNumItem() {
        return numItem;
    }

    public void setNumItem(int[] numItem) {
        this.numItem = numItem;
    }
}
