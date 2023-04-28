package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Message.*;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.View.*;

public class GameController {
    private TurnController turnController;
    private Game game;
    public GameController(){
        turnController = new TurnController(this);
    }
    public void broadcastDisconnectionMessage(String nickname, String s) {

    }

    public Game getGame(){
        return game;
    }

    public TurnController getTurnController() {
        return turnController;
    }

    public boolean isGameStarted() {
        return false;
    }

    public void endGame() {

    }

    public void onMessageReceived(Message message) {

    }

    public void removeVirtualView(String nickname, boolean notifyEnabled) {
    }

    public boolean nicknameIsUsed(String nickname, VirtualView vv) {

        return false;
    }

    public void loginHandler(String nickname, VirtualView vv) {

    }
}