package it.polimi.ingsw.Action;

import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.model.Bag.*;
import it.polimi.ingsw.model.Game.*;
import it.polimi.ingsw.model.*;

import java.util.ArrayList;

public class ChooseItem implements Action{
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

    }

    @Override
    public void addDescription(String s) {

    }

    @Override
    public void checkInput() throws ActionException {

    }
}
