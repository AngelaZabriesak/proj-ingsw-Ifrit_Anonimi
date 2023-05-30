package it.polimi.ingsw.Action;

import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.Message.Action.ActionMessage;
import it.polimi.ingsw.Message.Action.ChooseOrder_OK;
import it.polimi.ingsw.Model.Position;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Model.Game.Game;

import java.util.*;

/**
 * this class implements choose order of items  
 */

public class ChooseOrder implements Action{
    private final Player player;
    private final ArrayList<Integer> orderedPositionItem;
    private final Game game;
    private String description = "";

    public ChooseOrder(Game game,Player player, ArrayList<Integer> orderedPositionItem){
        this.game = game;
        this.player = player;
        this.orderedPositionItem = orderedPositionItem;
    }

    @Override
    public void execute() throws ActionException {
        for(Position p : player.getPosition())
            game.getBoard().updateNeighboursAdjacency(p);
        checkInput();
        ArrayList<Item> items = new ArrayList<>();
        for(Integer i : orderedPositionItem)
            items.add(player.getMyItem().get(i));
        player.clearItem();
        for(Item i : items)
            player.setMyItem(i);
    }

    @Override
    public ActionMessage getMessage() {

        return new ChooseOrder_OK(this.description,player.getMyItem());
    }

    @Override
    public void addDescription(String s) {
        description+=s;
    }

    @Override
    public void checkInput() throws ActionException {
        // check that position and myItem have the same length
        if(!checkLength()){
            throw new ActionException("The chosen positions do not correspond to the items");
        }
        // check if the position of item if between 0 and 2 and all are different
        if(!checkItem()) {
            throw new ActionException("The chosen positions are not acceptable");
        }
    }

    private boolean checkLength() {
        return orderedPositionItem.size() == game.getCurrentPlayer().getMyItem().size();
    }

    private boolean checkItem(){
        // check if the position of item is between 0 and 2
        for(Integer i : orderedPositionItem)
            if(i<0 || i> orderedPositionItem.size()-1)
                return false;
        // check if the position of item are all different
        if(orderedPositionItem.size()==1)
            return true;
        if(orderedPositionItem.size()>1) {
            if (orderedPositionItem.get(0).equals(orderedPositionItem.get(1)))
                return false;
            if (orderedPositionItem.size() == 3) {
                return !orderedPositionItem.get(1).equals(orderedPositionItem.get(2)) || !orderedPositionItem.get(0).equals(orderedPositionItem.get(2));
            }
        }
        return true;
    }
}
