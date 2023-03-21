package it.polimi.ingsw.model;


public class Item {
    private static final int ADJACENCY = 4;
    private ColorItem type;
    private int adjacency;

    public Item(ColorItem type) {
        this.type = type;
        this.adjacency = ADJACENCY;
    }

    public int getAdiacency() {
        return adjacency;
    }

    public void setAdiacency(int adjacency) {
        this.adjacency = adjacency;
    }

}
