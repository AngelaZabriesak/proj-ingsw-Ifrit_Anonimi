package it.polimi.ingsw.model;

import it.polimi.ingsw.model.Bag.Item;

public class Shelf {
    private static final int ROW = 6;
    private static final int COL = 5;
    Item myShelf[][] = new Item[ROW][COL];

    public Shelf() {

    }

    public void setItemInShelf(int col,Item item){
        for(int r = 0;r<ROW;r++){
            if(myShelf[r][col]==null){
                myShelf[r][col] = item;
            }
        }
    }

    /**
     * @return the number of cells empty
     */
    public int getNEmpty(){
        int nEmpty = ROW*COL;
        for(int r=0;r<ROW;r++) {
            for (int c = 0; c < COL; c++) {
                if(myShelf[r][c]!=null)
                    nEmpty--;
            }
        }
        return nEmpty;
    }

}
