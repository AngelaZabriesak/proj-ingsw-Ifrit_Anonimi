package it.polimi.ingsw.model;

import it.polimi.ingsw.model.Bag.Item;

public class Player {
    private Shelf myShelf;
    private String nickname;
    private Goal myGoal;
    private int myScore;
    private Item myItem;
    private Goal cGoal;

    public Player(){

    }

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

    public void setMyGoal(Goal myGoal) {
        this.myGoal = myGoal;
    }

    // return the cGoal cards : every turn check the cGoals and take the card if is completed
    // the player can have maximum two card at least
    public Goal getcGoal() {
        return cGoal;
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

