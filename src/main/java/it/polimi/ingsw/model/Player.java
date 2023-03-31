package it.polimi.ingsw.model;

import it.polimi.ingsw.Position;
import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Goal.Goal;

import java.util.ArrayList;

public class Player {
    private Shelf myShelf;
    private String nickname;
    private Goal myGoal;
    private int myScore;
    private ArrayList<Item> myItem;
    private Goal cGoal;
    private ArrayList<Position> myPosition = new ArrayList<>();

    public Player(String nickname){
        this.nickname = nickname;
        myItem = new ArrayList<>();
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

    /**
     * set the item chose
     * @param chosenItem
     */
    public void setMyItem(Item chosenItem) {
        myItem.add(chosenItem);
    }

    public ArrayList<Item> getMyItem(){
        return myItem;
    }

    public void setPosition(Position p){
        myPosition.add(p);
    }

    public ArrayList<Position> getPosition(){
        return myPosition;
    }
}

