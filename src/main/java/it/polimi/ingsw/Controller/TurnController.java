package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Exception.WinException;
import it.polimi.ingsw.Model.Player;

import java.util.*;

public class TurnController {
    private final GameController gameController;
    private Player currentPlayer;
    private ArrayList<Player> players;

    public TurnController(GameController gameController,ArrayList<Player> players){
        this.gameController = gameController;
        this.players = players;
        setCurrentPlayer(players.get(0));
    }
    public ArrayList<String> getNicknameList() {
        ArrayList<String> nicknames = new ArrayList<>();
        for(Player player : gameController.getGame().getPlayers())
            nicknames.add(player.getNickname());
        return nicknames;
    }

    public void setCurrentPlayer(Player p){
        this.currentPlayer = p;
        this.gameController.getGame().setActivePlayer(currentPlayer);
    }

    public void setNextPlayer(){
        int position = players.indexOf(currentPlayer);
        if(position == players.size()-1)
            setCurrentPlayer(players.get(0));
        else
            setCurrentPlayer(players.get(position+1));
    }

    public GameController getGameController(){
        return gameController;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    private void checkWin() throws WinException{

    }
}
