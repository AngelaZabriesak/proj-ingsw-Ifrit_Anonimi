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
    public int getItem() {
        int pos = (int) Math.random()%SIZE;
        removeItem(pos);
        return pos;
    }

    /**
     *  Remove the item caught
     */
    public void removeItem(int pos){
        numItem[pos]--;
    }
}
