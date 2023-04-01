package it.polimi.ingsw.Action;

import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.Position;
import it.polimi.ingsw.model.Bag.*;
import it.polimi.ingsw.model.Game.*;
import it.polimi.ingsw.model.*;

import java.util.*;

public class ChooseItem implements Action {
    private final Game game;
    private final int chosenColumn;
    private final int chosenRow;
    private final Player player;
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
        Item item = game.getBoard().getItem(new Position(chosenRow,chosenColumn));
        game.getBoard().removeItem(new Position(chosenRow,chosenColumn));
        player.setPosition(new Position(chosenRow,chosenColumn));
        game.getCurrentPlayer().setMyItem(item);
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
        if(chosenRow>0 && chosenRow<game.getBoard().getRow() && chosenColumn>0 && chosenColumn<game.getBoard().getCol())
            return true;
        return false;
    }

    private boolean checkAdjacency(){
        if(game.getBoard().getAdjacency(new Position(chosenRow,chosenColumn))>0 && game.getBoard().getAdjacency(new Position(chosenRow,chosenColumn))<4)
            return true;
        return false;
    }
}
