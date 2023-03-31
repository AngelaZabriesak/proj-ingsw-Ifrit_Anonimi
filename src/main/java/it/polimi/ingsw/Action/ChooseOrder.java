package it.polimi.ingsw.Action;

import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.Position;
import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.Bag.*;
import it.polimi.ingsw.model.Game.Game;

import java.util.*;

public class ChooseOrder implements Action{
    private final Player player;
    private final ArrayList<Integer> orderedPositionItem;
    private final int chosenColumn;
    private final Game game;
    private String description = "";

    public ChooseOrder(Game game,Player player, ArrayList<Integer> orderedPositionItem, int chosenColumn){
        this.game = game;
        this.player = player;
        this.chosenColumn = chosenColumn;
        this.orderedPositionItem = orderedPositionItem;
    }

    @Override
    public void execute() throws ActionException {
        for(Position p : player.getPosition())
            game.getBoard().updateNeighboursAdjacency(p.getRow(), p.getCol());
        checkInput();
        ArrayList<Item> items = new ArrayList<>();
        for(Integer i : orderedPositionItem)
            items.add(player.getMyItem().get(i));
        for(Item i : items)
            player.setMyItem(i);
    }

    @Override
    public void addDescription(String s) {
        description+=s;
    }

    @Override
    public void checkInput() throws ActionException {
        // check if the position of item if between 0 and 2 and all are different
        if(!checkItem())
            throw new ActionException();
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
            if (orderedPositionItem.get(0) == orderedPositionItem.get(1))
                return false;
            if (orderedPositionItem.size() == 3) {
                if (orderedPositionItem.get(1) == orderedPositionItem.get(2) && orderedPositionItem.get(0)==orderedPositionItem.get(2))
                    return false;
            }
        }
        return true;
    }
}
