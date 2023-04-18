package it.polimi.ingsw.View;

import it.polimi.ingsw.Message.*;
import it.polimi.ingsw.Networking.Server.*;

public class VirtualView implements View{
    private ClientHandler clientHandler;

    /**
     * Default constructor.
     *
     * @param clientHandler the client handler the virtual view must send messages to.
     */
    public VirtualView(ClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }

    /**
     * Returns the client handler associated to a client.
     *
     * @return client handler.
     */
    public ClientHandler getClientHandler() {
        return clientHandler;
    }

    @Override
    public void askNickname() {
        clientHandler.sendMessage(new LoginReply(false, true));
    }

    @Override
    public void askNPlayer() {

    }

    @Override
    public void askItem() {

    }

    @Override
    public void askColumn() {

    }

    @Override
    public void askOrder() {

    }

    @Override
    public void showBoard() {

    }

    @Override
    public void showShelf() {

    }

    @Override
    public void showPGoal() {

    }

    @Override
    public void showCGoal() {

    }

    @Override
    public void showScore() {

    }

    @Override
    public void showLoginResult(boolean nicknameAccepted, boolean connectionSuccessful, String nickname) {
        clientHandler.sendMessage(new LoginReply(nicknameAccepted, connectionSuccessful));
    }

    @Override
    public void showErrorAndExit(String error) {
        clientHandler.sendMessage(new MessageError("server", error));
    }

}
