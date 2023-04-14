package it.polimi.ingsw.Model.Game;

import it.polimi.ingsw.Model.Bag.ColorItem;
import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Position;

import java.util.ArrayList;

public class CreateItemGroup {
    private final ArrayList<Position>[] gruppo = new ArrayList[30];
    private ArrayList<Position> nuovoGruppo;
    public CreateItemGroup(){}

    /**
     * metodo che raggruppa gli item inseriti nella shelf in base al colore
     * @param player il player la cui libreria è da controllare
     * @return un array in cui vengono memorizzate le liste di posizioni
     */
    public ArrayList<Position>[] creaGruppi(Player player){
        Position primo;
        int i=0;
        for(int r =0; r<player.getMyShelf().getRow();r++){
            for(int c=0; c<player.getMyShelf().getCol();c++) {
                this.nuovoGruppo = new ArrayList<>();
                if(player.getMyShelf().getMyShelf()[r][c]!=null){
                    if (player.getMyShelf().getMyShelf()[r][c].getColor() != ColorItem.BLACK && !player.getMyShelf().getMyShelf()[r][c].getInGruppo()) {
                        this.gruppo[i] = new ArrayList<>();
                        primo = new Position(r, c);
                        this.gruppo[i].add(primo);
                        player.getMyShelf().getMyShelf()[r][c].setInGruppo();
                        controllaVicini(player, primo);
                        this.gruppo[i].addAll(this.nuovoGruppo);
                        for (Position p : this.gruppo[i]) {
                            player.getMyShelf().getMyShelf()[r][c] = new Item(ColorItem.BLACK);
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
     * @param player il player la cui libreria è da controllare
     * @param primo il primo item che si trova scorrendo la shelf
     * @return un intero che serve per controllare il numero di vicini che ha un item
     */
    private int controllaVicini(Player player,Position primo){
        ArrayList<Position> gruppo = new ArrayList<>();
        primo.setCheck();
        int adiacenze =0;
        if(primo.getRow()<5 && player.getMyShelf().getMyShelf()[primo.getRow()+1][primo.getCol()]!=null) {
            if(player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()].getColor()==player.getMyShelf().getMyShelf()[primo.getRow()+1][primo.getCol()].getColor()){
                if (!player.getMyShelf().getMyShelf()[primo.getRow() + 1][primo.getCol()].getInGruppo()) {
                    gruppo.add(new Position(primo.getRow() + 1, primo.getCol()));
                    adiacenze++;
                    player.getMyShelf().getMyShelf()[primo.getRow() + 1][primo.getCol()].setInGruppo();
                    controllaVicini(player, new Position(primo.getRow() + 1, primo.getCol()));
                }
            }
        }
        if(primo.getRow()>0 && player.getMyShelf().getMyShelf()[primo.getRow()-1][primo.getCol()]!=null) {
            if(player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()].getColor()==player.getMyShelf().getMyShelf()[primo.getRow()-1][primo.getCol()].getColor()){
                if (!player.getMyShelf().getMyShelf()[primo.getRow() - 1][primo.getCol()].getInGruppo()) {
                    gruppo.add(new Position(primo.getRow() - 1, primo.getCol()));
                    adiacenze++;
                    player.getMyShelf().getMyShelf()[primo.getRow() - 1][primo.getCol()].setInGruppo();
                    controllaVicini(player, new Position(primo.getRow() - 1, primo.getCol()));
                }
            }
        }
        if(primo.getCol()<4 && player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()+1]!=null){
            if(player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()].getColor()==player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()+1].getColor()){
                if(!player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()+1].getInGruppo()){
                    gruppo.add(new Position(primo.getRow(), primo.getCol()+1));
                    adiacenze++;
                    player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()+1].setInGruppo();
                    controllaVicini(player,new Position(primo.getRow(), primo.getCol() + 1));
                }
            }
        }
        if(primo.getCol()>0 && player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()-1]!=null){
            if(player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()].getColor()==player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()-1].getColor()) {
                if (!player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol() - 1].getInGruppo()) {
                    gruppo.add(new Position(primo.getRow(), primo.getCol() - 1));
                    adiacenze++;
                    player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol() - 1].setInGruppo();
                    controllaVicini(player, new Position(primo.getRow(), primo.getCol() - 1));
                }
            }
        }
        this.nuovoGruppo.addAll(gruppo);
        return adiacenze;
    }
}
