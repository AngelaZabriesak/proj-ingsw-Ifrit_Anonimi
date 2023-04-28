package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Message.*;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.View.*;

import java.util.*;

public class GameController {
    private Game game;
    private TurnController turnController;
    private final ArrayList<Player> players;
    private int numberOfPlayers = 2;
    public GameController(){
        players = new ArrayList<>();
        turnController = new TurnController(this);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Game getGame() {
        return game;
    }

    public void broadcastDisconnectionMessage(String nickname, String s) {

    }

    public TurnController getTurnController() {
        return turnController;
    }

    public boolean isGameStarted() {
        return false;
    }

    public void endGame() {

    }

    public void onMessageReceived(MessageToServer message) {
        switch(message.getMessageType()){
            case LOGIN_REPLY:
                System.out.println("Login successfull");

        }

    }

    public void removeVirtualView(String nickname, boolean notifyEnabled) {
    }

    public boolean nicknameIsUsed(String nickname, VirtualView vv) {

        return false;
    }

    public void loginHandler(String nickname, VirtualView vv) {

    }
}
