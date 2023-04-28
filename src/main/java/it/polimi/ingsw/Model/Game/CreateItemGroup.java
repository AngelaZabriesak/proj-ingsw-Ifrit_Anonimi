package it.polimi.ingsw.Model.Game;

import it.polimi.ingsw.Model.Bag.ColorItem;
import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Position;
import it.polimi.ingsw.Model.Shelf;

import java.util.ArrayList;

public class CreateItemGroup {
    private final ArrayList<Position>[] gruppo = new ArrayList[30];
    private ArrayList<Position> nuovoGruppo;
    public CreateItemGroup(){}

    /**
     * metodo che raggruppa gli item inseriti nella shelf in base al colore
     * @param myShelf libreria che è da controllare
     * @return un array in cui vengono memorizzate le liste di posizioni
     */
    public ArrayList<Position>[] creaGruppi(Shelf myShelf){
        Position primo;
        int i=0;
        for(int r =0; r<myShelf.getRow();r++){
            for(int c=0; c<myShelf.getCol();c++) {
                this.nuovoGruppo = new ArrayList<>();
                if(myShelf.getMyShelf()[r][c]!=null){
                    if (myShelf.getMyShelf()[r][c].getColor() != ColorItem.BLACK && !myShelf.getMyShelf()[r][c].getInGruppo()) {
                        this.gruppo[i] = new ArrayList<>();
                        primo = new Position(r, c);
                        this.gruppo[i].add(primo);
                        myShelf.getMyShelf()[r][c].setInGruppo();
                        controllaVicini(myShelf, primo);
                        this.gruppo[i].addAll(this.nuovoGruppo);
                        for (Position p : this.gruppo[i]) {
                            myShelf.getMyShelf()[r][c] = new Item(ColorItem.BLACK);
                        }
                        i++;
                    }
                }
            }
        }
        return this.gruppo;
    }
    /**
     * metodo che controlla i vicini di un item nella libreria
     * @param myShelf  la libreria che è da controllare
     * @param primo il primo item che si trova scorrendo la shelf
     * @return un intero che serve per controllare il numero di vicini che ha un item
     */
    private int controllaVicini(Shelf myShelf,Position primo){
        ArrayList<Position> gruppo = new ArrayList<>();
        primo.setCheck();
        int adiacenze =0;
        if(primo.getRow()<5 && myShelf.getMyShelf()[primo.getRow()+1][primo.getCol()]!=null) {
            if(myShelf.getMyShelf()[primo.getRow()][primo.getCol()].getColor()==myShelf.getMyShelf()[primo.getRow()+1][primo.getCol()].getColor()){
                if (!myShelf.getMyShelf()[primo.getRow() + 1][primo.getCol()].getInGruppo()) {
                    gruppo.add(new Position(primo.getRow() + 1, primo.getCol()));
                    adiacenze++;
                    myShelf.getMyShelf()[primo.getRow() + 1][primo.getCol()].setInGruppo();
                    controllaVicini(myShelf, new Position(primo.getRow() + 1, primo.getCol()));
                }
            }
        }
        if(primo.getRow()>0 && myShelf.getMyShelf()[primo.getRow()-1][primo.getCol()]!=null) {
            if(myShelf.getMyShelf()[primo.getRow()][primo.getCol()].getColor()==myShelf.getMyShelf()[primo.getRow()-1][primo.getCol()].getColor()){
                if (!myShelf.getMyShelf()[primo.getRow() - 1][primo.getCol()].getInGruppo()) {
                    gruppo.add(new Position(primo.getRow() - 1, primo.getCol()));
                    adiacenze++;
                    myShelf.getMyShelf()[primo.getRow() - 1][primo.getCol()].setInGruppo();
                    controllaVicini(myShelf, new Position(primo.getRow() - 1, primo.getCol()));
                }
            }
        }
        if(primo.getCol()<4 && myShelf.getMyShelf()[primo.getRow()][primo.getCol()+1]!=null){
            if(myShelf.getMyShelf()[primo.getRow()][primo.getCol()].getColor()==myShelf.getMyShelf()[primo.getRow()][primo.getCol()+1].getColor()){
                if(!myShelf.getMyShelf()[primo.getRow()][primo.getCol()+1].getInGruppo()){
                    gruppo.add(new Position(primo.getRow(), primo.getCol()+1));
                    adiacenze++;
                    myShelf.getMyShelf()[primo.getRow()][primo.getCol()+1].setInGruppo();
                    controllaVicini(myShelf,new Position(primo.getRow(), primo.getCol() + 1));
                }
            }
        }
        if(primo.getCol()>0 && myShelf.getMyShelf()[primo.getRow()][primo.getCol()-1]!=null){
            if(myShelf.getMyShelf()[primo.getRow()][primo.getCol()].getColor()==myShelf.getMyShelf()[primo.getRow()][primo.getCol()-1].getColor()) {
                if (!myShelf.getMyShelf()[primo.getRow()][primo.getCol() - 1].getInGruppo()) {
                    gruppo.add(new Position(primo.getRow(), primo.getCol() - 1));
                    adiacenze++;
                    myShelf.getMyShelf()[primo.getRow()][primo.getCol() - 1].setInGruppo();
                    controllaVicini(myShelf, new Position(primo.getRow(), primo.getCol() - 1));
                }
            }
        }
        this.nuovoGruppo.addAll(gruppo);
        return adiacenze;
    }
}
