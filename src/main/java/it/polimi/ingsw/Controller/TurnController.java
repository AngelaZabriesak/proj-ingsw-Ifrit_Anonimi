package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Player;

import java.util.*;

public class TurnController {
    private GameController gameController;
    public TurnController(GameController gameController){
        this.gameController = gameController;
    }
    public ArrayList<String> getNicknameList() {
        ArrayList<String> nicknames = new ArrayList<>();
        for(Player player : gameController.getGame().getPlayers())
            nicknames.add(player.getNickname());
        return nicknames;
    }
}
