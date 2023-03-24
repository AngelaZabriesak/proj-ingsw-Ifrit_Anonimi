package it.polimi.ingsw.Action;

import it.polimi.ingsw.Exception.ActionException;
import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Game.*;

import java.util.ArrayList;

public class AddItemInShelf implements Action{

    private final Game game;
    private final int chosenColumn;
    private final ArrayList<Item> chosenItem;
    private final Player player;
    private String description = "";

    public AddItemInShelf(Game game, int chosenColumn, ArrayList<Item> chosenItem, Player player){
        this.game = game;
        this.chosenColumn = chosenColumn;
        this.chosenItem = chosenItem;
        this.player = player;
    }

    @Override
    public void execute() throws ActionException {
        checkInput();
        player.getMyShelf().setItemInShelf(chosenColumn,chosenItem);
    }

    @Override
    public void addDescription(String s) {

    }

    /**
     * checks if the given column id is valid
     * @return boolean
     */
    private boolean checkColumnValid(){
        if(chosenColumn<1 || chosenColumn>5)
            return false;
        return true;
    }

    private boolean checkColumnEmpty(){
        if(player.getMyShelf().getFreeRowByColumn(chosenColumn)<=chosenItem.size())
            return true;
        return false;
    }

    @Override
    public void checkInput() throws ActionException {
        if(!checkColumnValid())
            throw new ActionException();
        if(!checkColumnEmpty())
            throw new ActionException();
    }
}
