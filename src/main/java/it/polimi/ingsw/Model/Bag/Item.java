package it.polimi.ingsw.Model.Bag;


import java.io.Serializable;

public class Item implements Serializable {
    private final ColorItem type;
    private boolean inGroup = false;

    public Item(ColorItem type) {
        this.type = type;
    }

    public ColorItem getColor(){
        return type;
    }

    public boolean getInGroup(){
        return !inGroup;
    }

    public void setInGroup(){
        this.inGroup =true;
    }

}
