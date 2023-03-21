package it.polimi.ingsw.model;

public class Bag {
    private static final int SIZE = 6;
    private static final int NUMITEM = 22;
    private int[] numItem = new int[SIZE];

    public Bag() {
        for(int i = 0; i<SIZE ; i++){
            numItem[i] = NUMITEM;
        }
    }

    /**
     * @return number between 0 and 5 that is the index of the array
     */
    public it.polimi.ingsw.Item getItem() {
        int pos = (int) Math.random()%SIZE;
        numItem[pos]--;
        return new Item(ColorItem.values()[pos]);
    }
}
