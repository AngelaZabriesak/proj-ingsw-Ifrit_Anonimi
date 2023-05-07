package it.polimi.ingsw.Model.Goal.CommonGoal;
import it.polimi.ingsw.Model.Bag.ColorItem;
import it.polimi.ingsw.Model.Shelf;
import it.polimi.ingsw.Model.Position;
import it.polimi.ingsw.Model.Token;

import java.util.ArrayList;

/*  common goal 5:
    eight tiles of the same type
    There's no restriction about the position of these tiles */

public class CommonGoal5 extends Cgoal {


    public CommonGoal5() {
        setDescription("common goal 5:eight tiles of the same type. There's no restriction about the position of these tiles\n");
        setIndex(5);
    }


    @Override
    public boolean isTaken(Shelf myShelf) {

        ArrayList<Position> group = null;

        for (ColorItem ci : ColorItem.values()) {   // there is even black : groupColor size is 7
            group = new ArrayList<>();
            for (int r = 0; r < myShelf.getRow(); r++) {
                for (int c = 0; c < myShelf.getCol(); c++) {
                    if(myShelf.getMyShelf()[r][c]!=null){
                        if (myShelf.getMyShelf()[r][c].getColor().equals(ci))
                            group.add(new Position(r, c));
                    }
                }
            }
        }
        assert group != null;
        return group.size() == 8;
    }

    @Override

    public Token getToken() {
        Token t = null;
        if (tokens.size() > 0) {
            t = tokens.get(tokens.size() - 1);
            tokens.remove(tokens.size() - 1);
        }
        return t;
    }
}









/*     another way to do this
        int b = 0;   //n of elements blue

        int w = 0;   //n of element white
        int p = 0;  // n of elements pink
        int g = 0;   //n of elements green
        int y = 0;   //n of elements yellow
        int a = 0;   //n of elements azure

        for (int j = ROW-1; j >= 0; j--) {
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

        */