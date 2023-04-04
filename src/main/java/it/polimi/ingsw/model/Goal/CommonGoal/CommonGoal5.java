package it.polimi.ingsw.model.Goal.CommonGoal;

import it.polimi.ingsw.model.Bag.ColorItem;
import it.polimi.ingsw.model.Bag.Item;
//import it.polimi.ingsw.model.Token;
import it.polimi.ingsw.model.Shelf;

/*  common goal 5:
    eight tiles of the same type
    There's no restriction about the position of these tiles */

public class CommonGoal5 extends Cgoal{

    private static final int ROW = 6;
    private static final int COL = 5;
   // private Item[][] myItemGoal = new Item[ROW][COL];


    public boolean CommonGoal5(Shelf CShelf) {
        setDescription("common goal 5:eight tiles of the same type. There's no restriction about the position of these tiles\n");
        setIndex(5);
        Item[][] myshelf = CShelf.getMyShelf();

        int b = 0;   //n of elements blue
        int w = 0;   //n of element white
        int p = 0;  // n of elements pink
        int g = 0;   //n of elements green
        int y = 0;   //n of elements yellow
        int a = 0;   //n of elements azure

        for (int j = ROW-1; j <= 0; j--) {
            for (int i = 0; i < COL; i++) {
                if (myshelf[j][i].getColor() == ColorItem.BLUE) {
                    b++;
                    if(b==8){
                        return true;
                    }
                }
                if (myshelf[j][i].getColor() == ColorItem.WHITE) {
                    w++;
                    if(w==8){
                        return true;
                    }
                }
                if (myshelf[j][i].getColor() == ColorItem.PINK){
                    p++;
                    if(p==8){
                        return true;
                    }
                }
                if (myshelf[j][i].getColor() == ColorItem.GREEN){
                    g++;
                    if(g==8){
                        return true;
                    }
                }
                if (myshelf[j][i].getColor() == ColorItem.YELLOW){
                    y++;
                    if(y==8){
                        return true;
                    }

                }
                if (myshelf[j][i].getColor() == ColorItem.AZURE){
                    a++;
                    if(a==8){
                        return true;
                    }
                }

            }

        }
        return false;

        }

    }
