package it.polimi.ingsw.Model.Game;

import it.polimi.ingsw.Model.Bag.ColorItem;
import it.polimi.ingsw.Model.Position;
import it.polimi.ingsw.Model.Shelf;

import java.util.ArrayList;




public class CreateItemGroup {
    private final ArrayList<Position>[] gruppo = new ArrayList[30];
    private ArrayList<Position> nuovoGruppo;
    public CreateItemGroup(){}

    /**
     * metodo which groups the items inserted in the shelf by color
     * @param myShelf library to be checked
     * @return an array in which lists of positions are stored
     */
    public ArrayList<Position>[] creaGruppi(Shelf myShelf){
        Position primo;
        int i=0;
        for(int r =0; r<myShelf.getRow();r++){
            for(int c=0; c<myShelf.getCol();c++) {
                this.nuovoGruppo = new ArrayList<>();
                if(myShelf.getMyShelf()[r][c]!=null){
                    if (myShelf.getMyShelf()[r][c].getColor() != ColorItem.X && myShelf.getMyShelf()[r][c].getInGroup()) {
                        this.gruppo[i] = new ArrayList<>();
                        primo = new Position(r, c);
                        this.gruppo[i].add(primo);
                        myShelf.getMyShelf()[r][c].setInGroup();
                        controllaVicini(myShelf, primo);
                        this.gruppo[i].addAll(this.nuovoGruppo);
                        /*for (Position p : this.gruppo[i]) {
                            myShelf.getMyShelf()[r][c] = new Item(ColorItem.X);
                        }*/
                        i++;
                    }
                }
            }
        }
        return this.gruppo;
    }
    /**
     * A method that checks the neighbors of an item in the library
     * @param myShelf  library to be checked
     * @param primo The first item you find by scrolling the shelf
     * @return an int that is used to control the number of neighbors who have an item
     */
    private int controllaVicini(Shelf myShelf,Position primo){
        ArrayList<Position> gruppo = new ArrayList<>();
        primo.setCheck();
        int adiacenze =0;
        if(primo.getRow()<5 && myShelf.getMyShelf()[primo.getRow()+1][primo.getCol()]!=null) {
            if(myShelf.getMyShelf()[primo.getRow()][primo.getCol()].getColor()==myShelf.getMyShelf()[primo.getRow()+1][primo.getCol()].getColor()){
                if (myShelf.getMyShelf()[primo.getRow() + 1][primo.getCol()].getInGroup()) {
                    gruppo.add(new Position(primo.getRow() + 1, primo.getCol()));
                    adiacenze++;
                    myShelf.getMyShelf()[primo.getRow() + 1][primo.getCol()].setInGroup();
                    controllaVicini(myShelf, new Position(primo.getRow() + 1, primo.getCol()));
                }
            }
        }
        if(primo.getRow()>0 && myShelf.getMyShelf()[primo.getRow()-1][primo.getCol()]!=null) {
            if(myShelf.getMyShelf()[primo.getRow()][primo.getCol()].getColor()==myShelf.getMyShelf()[primo.getRow()-1][primo.getCol()].getColor()){
                if (myShelf.getMyShelf()[primo.getRow() - 1][primo.getCol()].getInGroup()) {
                    gruppo.add(new Position(primo.getRow() - 1, primo.getCol()));
                    adiacenze++;
                    myShelf.getMyShelf()[primo.getRow() - 1][primo.getCol()].setInGroup();
                    controllaVicini(myShelf, new Position(primo.getRow() - 1, primo.getCol()));
                }
            }
        }
        if(primo.getCol()<4 && myShelf.getMyShelf()[primo.getRow()][primo.getCol()+1]!=null){
            if(myShelf.getMyShelf()[primo.getRow()][primo.getCol()].getColor()==myShelf.getMyShelf()[primo.getRow()][primo.getCol()+1].getColor()){
                if(myShelf.getMyShelf()[primo.getRow()][primo.getCol() + 1].getInGroup()){
                    gruppo.add(new Position(primo.getRow(), primo.getCol()+1));
                    adiacenze++;
                    myShelf.getMyShelf()[primo.getRow()][primo.getCol()+1].setInGroup();
                    controllaVicini(myShelf,new Position(primo.getRow(), primo.getCol() + 1));
                }
            }
        }
        if(primo.getCol()>0 && myShelf.getMyShelf()[primo.getRow()][primo.getCol()-1]!=null){
            if(myShelf.getMyShelf()[primo.getRow()][primo.getCol()].getColor()==myShelf.getMyShelf()[primo.getRow()][primo.getCol()-1].getColor()) {
                if (myShelf.getMyShelf()[primo.getRow()][primo.getCol() - 1].getInGroup()) {
                    gruppo.add(new Position(primo.getRow(), primo.getCol() - 1));
                    adiacenze++;
                    myShelf.getMyShelf()[primo.getRow()][primo.getCol() - 1].setInGroup();
                    controllaVicini(myShelf, new Position(primo.getRow(), primo.getCol() - 1));
                }
            }
        }
        this.nuovoGruppo.addAll(gruppo);
        return adiacenze;
    }
}
