package it.polimi.ingsw.model.Bag;


public class Item {
    private ColorItem type;

    public Item(ColorItem type) {
        this.type = type;
    }

    public ColorItem getColor(){
        return type;
    }


    public void setItem(ColorItem c){
        this.type = c;
    }

}
