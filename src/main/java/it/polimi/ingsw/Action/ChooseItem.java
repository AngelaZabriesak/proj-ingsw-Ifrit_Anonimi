package it.polimi.ingsw.Action;

import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.Message.Action.ActionMessage;
import it.polimi.ingsw.Message.Action.ChooseItem_OK;
import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.*;

public class ChooseItem implements Action {
    private final Game game;
    private Position p1,p2, newPosition;
    private final Player player;
    private Item item;
    private String description = "";

    public ChooseItem(Game game, Player player,Position p1, Position p2, Position newPosition) {
        this.game = game;
        this.player = player;
        this.p1 = p1;
        this.p2 = p2;
        this.newPosition = newPosition;
    }

    @Override
    public void execute() throws ActionException {
        checkInput();
        if(game.getCurrentPlayer().getMyItem().size()>3)
            throw new ActionException("You can't choose more of 3 items");
        this.item = game.getBoard().getItem(newPosition);
        game.getBoard().removeItem(newPosition);
        player.setPosition(newPosition);
        game.getCurrentPlayer().setMyItem(item);
    }

    @Override
    public ActionMessage getMessage() {
        return new ChooseItem_OK(this.description,item,newPosition.getRow(), newPosition.getCol());
    }

    @Override
    public void addDescription(String s) {
        description+=s;
    }

    @Override
    public void checkInput() throws ActionException {
        // checking if the parameter in input are acceptable
        if(!checkRowCol()) {
            throw new ActionException("The row and column entered aren't acceptable");
        }
        // checking adjacency
        if(!checkAdjacency()) {
            throw new ActionException("The item in " + newPosition.getRow() + ", " + newPosition.getCol() + " doesn't have the right adjacency");
        }

        if(!checkAvailable()) {
            throw new ActionException("The item choosed isn't available");
        }

    }

    private boolean checkRowCol(){
        return newPosition.getRow() > 0 && newPosition.getRow() < game.getBoard().getRow() && newPosition.getCol() > 0 && newPosition.getCol() < game.getBoard().getCol();
    }

    private boolean checkAdjacency(){
        return game.getBoard().getPositionAvailable(newPosition.getRow(),newPosition.getCol())>0;
    }

    private boolean checkAvailable(){
        for(Position p : game.getPositionAvailable(p1,p2)) {
            if (p.getRow() == newPosition.getRow() && p.getCol() == newPosition.getCol())
                return true;
        }
        return false;
    }
}
