package it.polimi.ingsw.Action;

import it.polimi.ingsw.Exception.ActionException;
import it.polimi.ingsw.Position;
import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.Bag.Item;
import it.polimi.ingsw.model.Game.*;

import java.util.ArrayList;

public class AddItemInShelf implements Action{
    private final Game game;
    private final int chosenColumn;
    private final Player player;
    private String description = "";

    public AddItemInShelf(Game game,int chosenColumn, Player player){
        this.game = game;
        this.chosenColumn = chosenColumn;
        this.player = player;
    }

    @Override
    public void execute() throws ActionException {
        checkInput();
        player.setItemInShelf(chosenColumn);

        for(Position p : game.getCurrentPlayer().getPosition())
            game.getBoard().updateNeighboursAdjacency(p);
    }

    @Override
    public void addDescription(String s) {
        description+=s;
    }

    @Override
    public void checkInput() throws ActionException {
        if(!checkColumnValid()) {
            System.out.println("The id column chose isn't valid");
            throw new ActionException();
        }
        if(!checkColumnEmpty()) {
            System.out.println("The id column chose doesn't have enough space");
            throw new ActionException();
        }
    }


    /**
     * checks if the given column id is valid
     * @return boolean
     */
    private boolean checkColumnValid(){
        if(chosenColumn<0 || chosenColumn>4)
            return false;
        return true;
    }

    private boolean checkColumnEmpty(){
        if(player.getMyShelf().getFreeRowByColumn(chosenColumn)<player.getMyItem().size())
            return false;
        return true;
    }
}
