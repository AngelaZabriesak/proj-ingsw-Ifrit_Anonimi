package it.polimi.ingsw.model.Bag;

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
     * @return the item created by randomly extracting the color
     */
    public Item getItem() {
        double posDouble = Math.random() * SIZE;
        int pos = (int) posDouble;
        numItem[pos]--;
        return new Item(ColorItem.values()[pos]);
    }

    /**
     * @return the sum of the amount of each color
     */
    public int getSize(){
        int tot=0;
        for(int i = 0; i < SIZE; i++)
            tot+=numItem[i];
        return tot;
    }
}
