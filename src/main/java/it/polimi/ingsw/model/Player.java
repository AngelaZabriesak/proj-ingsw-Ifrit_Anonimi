package it.polimi.ingsw.model;

import it.polimi.ingsw.Position;
import it.polimi.ingsw.model.Bag.ColorItem;
import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Goal.Goal;

import java.util.ArrayList;
import java.util.Arrays;

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

    public void setItemInShelf(int col){
        boolean ok;
        for(Item i : myItem) {
            ok = false;
            for(int r=myShelf.getRow()-1; r>-1 && ok!=true; r--){
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

    public ArrayList<ArrayList<Position>> getAdjacencyGoal(Shelf shelf){
        ArrayList<ArrayList<Position>> listGroups = new ArrayList<>();
        ArrayList<Position> groups = new ArrayList<>();
        for(int r=0; r<myShelf.getRow(); r++){
            for(int c = 0; c<myShelf.getCol(); c++){
                if(!myShelf.getMyShelf()[r][c].getColor().equals(ColorItem.BLACK) && myShelf.getMyShelf()!=null){
                    checkAdjacency(new Position(r,c),groups);
                }
                if(groups.size()>0) {
                    listGroups.add(groups);
                    groups.clear();
                }
            }
        }
        return listGroups;
    }

    public void checkAdjacency(Position p,ArrayList<Position> groups){
        if(myShelf.getMyShelf()[p.getRow()-1][p.getCol()].equals(myShelf.getMyShelf()[p.getRow()-1][p.getCol()])) {
            groups.add(p);
            checkAdjacency(new Position(p.getRow() - 1, p.getCol()),groups);
        }

        if(myShelf.getMyShelf()[p.getRow()+1][p.getCol()].equals(myShelf.getMyShelf()[p.getRow()+1][p.getCol()])) {
            groups.add(p);
            checkAdjacency(new Position(p.getRow() +1, p.getCol()),groups);
        }

        if(myShelf.getMyShelf()[p.getRow()][p.getCol()-1].equals(myShelf.getMyShelf()[p.getRow()][p.getCol()-1])) {
            groups.add(p);
            checkAdjacency(new Position(p.getRow(), p.getCol()-1),groups);
        }

        if(myShelf.getMyShelf()[p.getRow()][p.getCol()+1].equals(myShelf.getMyShelf()[p.getRow()][p.getCol()+1])) {
            groups.add(p);
            checkAdjacency(new Position(p.getRow(), p.getCol()+1),groups);
        }
    }
}

