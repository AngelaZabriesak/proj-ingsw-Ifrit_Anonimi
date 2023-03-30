package it.polimi.ingsw.Action;

import it.polimi.ingsw.Exception.ActionException;
import it.polimi.ingsw.model.Player;

public class ChooseOrder implements Action{
    private final Player player;
    private String description = "";

    public ChooseOrder(Player player){
        this.player = player;
    }

    @Override
    public void execute() throws ActionException {

    }

    @Override
    public void addDescription(String s) {
        description+=s;
    }

    @Override
    public void checkInput() throws ActionException {

    }

    //chooseOrder();
    // chooseColoumn();
}
