package it.polimi.ingsw.Action;

import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.*;
import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.Game.*;

public class AddItemInShelf implements Action{
    private final Game game;
    private final int chosenColumn;
    private final Player player;
    private final String description = "";

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
        return chosenColumn >= 0 && chosenColumn <= 4;
    }

    private boolean checkColumnEmpty(){
        return player.getMyShelf().getFreeRowByColumn(chosenColumn) >= player.getMyItem().size();
    }
}
