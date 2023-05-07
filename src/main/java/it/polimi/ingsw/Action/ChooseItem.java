package it.polimi.ingsw.Action;

import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.Message.Action.ActionMessage;
import it.polimi.ingsw.Message.Action.ChooseItem_OK;
import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.*;

public class ChooseItem implements Action {
    private final Game game;
    private final int chosenColumn;
    private final int chosenRow;
    private final Player player;
    private Item item;
    private String description = "";

    public ChooseItem(Game game, int chosenRow, int chosenColumn, Player player) {
        this.game = game;
        this.chosenColumn = chosenColumn;
        this.chosenRow = chosenRow;
        this.player = player;
    }

    @Override
    public void execute() throws ActionException {
        checkInput();
        if(game.getCurrentPlayer().getMyItem().size()>3)
            throw new ActionException();
        this.item = game.getBoard().getItem(new Position(chosenRow,chosenColumn));
        game.getBoard().removeItem(new Position(chosenRow,chosenColumn));
        player.setPosition(new Position(chosenRow,chosenColumn));
        game.getCurrentPlayer().setMyItem(item);
    }

    @Override
    public ActionMessage getMessage() {

        return new ChooseItem_OK(this.description,item,chosenRow,chosenColumn);
    }

    @Override
    public void addDescription(String s) {
        description+=s;
    }

    @Override
    public void checkInput() throws ActionException {
        // checking if the parameter in input are acceptable
        if(!checkRowCol()) {
            System.out.println("The row and column entered aren't acceptable");
            throw new ActionException();
        }
        // checking adjacency
        if(!checkAdjacency()) {
            System.out.println("The item in " + chosenRow + ", " + chosenColumn + " doesn't have the right adjacency\n");
            throw new ActionException();
        }

    }

    private boolean checkRowCol(){
        return chosenRow > 0 && chosenRow < game.getBoard().getRow() && chosenColumn > 0 && chosenColumn < game.getBoard().getCol();
    }

    private boolean checkAdjacency(){
        return game.getBoard().getAdjacency(new Position(chosenRow, chosenColumn)) > 0 && game.getBoard().getAdjacency(new Position(chosenRow, chosenColumn)) < 4;
    }
}
