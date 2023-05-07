package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Model.Goal.*;
import it.polimi.ingsw.Model.Goal.PersonalGoal.Pgoal;

import java.io.Serializable;
import java.util.*;

public class Player implements Serializable {
    private final Shelf myShelf;
    private final String nickname;
    private Goal myGoal;
    private int myScore = 0;
    private final ArrayList<Item> myItem;
    private Goal cGoal;
    private final ArrayList<Position> myPosition = new ArrayList<>();

    public Player(String nickname){
        this.nickname = nickname;
        myItem = new ArrayList<>();
        myShelf = new Shelf();
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
    public Pgoal getMyGoal() {
        return (Pgoal) myGoal;
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

    public void setItemInShelf(int col){
        boolean ok;
        for(Item i : myItem) {
            ok = false;
            for(int r = myShelf.getRow()-1; r>-1 && !ok; r--){
                if (myShelf.getMyShelf()[r][col] == null) {
                    myShelf.setMyShelf(new Position(r,col),i);
                    ok = true;
                }
            }
        }
        clearItem();
    }

    public void clearItem(){
        myItem.clear();
        myPosition.clear();
    }

    public void setMyScore(int myScore){
        this.myScore = myScore;
    }

    public void addMyScore(int score){
        this.myScore+=score;
    }

}

