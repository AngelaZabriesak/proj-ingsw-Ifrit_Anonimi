package it.polimi.ingsw.Action;

import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.model.Bag.*;
import it.polimi.ingsw.model.Game.*;
import it.polimi.ingsw.model.*;

import java.util.*;

public class ChooseItem implements Action {
    private final Game game;
    private final int chosenColumn;
    private final ArrayList<Item> chosenItem;
    private final Player player;
    private String description = "";

    public ChooseItem(Game game, int chosenColumn, ArrayList<Item> chosenItem, Player player) {
        this.game = game;
        this.chosenColumn = chosenColumn;
        this.chosenItem = chosenItem;
        this.player = player;
    }

    @Override
    public void execute() throws ActionException {
        checkInput();
        new AddItemInShelf(game, chosenColumn, chosenItem, player);
    }

    @Override
    public void addDescription(String s) {
        description+=s;
    }

    @Override
    public void checkInput() throws ActionException {
        // check if the column id is right
        if (!checkId())
            throw new ActionException();

        // checking adjacency
        if(!checkAdjacency())
            throw new ActionException();

        // check if the itemColor is in the Board
        /*for (Item ci : chosenItem)
            if (!game.getBoard().checkpresence(ColorItem.valueOf("" + ci.getColor())))
                throw new ActionException();
*/
    }

    /**
     * checks if the given column number is valid
     *
     * @return boolean
     */
    private boolean checkId() {
        if(chosenColumn<5 && chosenColumn>=0)
            return true;
        return false;
    }

    /**
     * checks if the given item has the right adjacency
     */
    private boolean checkAdjacency(){
        //for(Item ci : chosenItem)
            //if()
        return false;
    }
}
