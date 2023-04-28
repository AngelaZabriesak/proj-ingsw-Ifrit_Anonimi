package it.polimi.ingsw.Model.Bag;


public class Item {
    private final ColorItem type;
    private boolean inGruppo = false;

    public Item(ColorItem type) {
        this.type = type;
    }

    public ColorItem getColor(){
        return type;
    }

    public boolean getInGruppo(){
        return inGruppo;
    }

    public void setInGruppo(){
        this.inGruppo=true;
    }

}
