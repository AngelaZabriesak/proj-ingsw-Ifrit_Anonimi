package it.polimi.ingsw.model;

import it.polimi.ingsw.model.Bag.Item;

public class Player {


    private Shelf myShelf;
    private String nickname;
    private Goal myGoal;
    private int myScore;
    private Item myItem;



    // return the player nickname
    public String getNickname() {
        return this.nickname;
    }

    //return the player Shelf

    public Shelf getMyShelf() {
        return myShelf;
    }

    // return the player pGoal

    public Goal getMyGoal() {
        return myGoal;
    }

    // return the player score

    public int getMyScore() {
        return myScore;
    }

    // return the item taken from the bag during player's turn
    public Item getMyItem() {
        return myItem;
    }
}

