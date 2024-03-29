package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Message.*;
import it.polimi.ingsw.Message.Error.Error;
import it.polimi.ingsw.Message.GameState.*;
import it.polimi.ingsw.Message.Response.*;
import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Networking.Client.*;
import it.polimi.ingsw.Observer.ClientObservable;
import it.polimi.ingsw.Observer.ClientObserver;
import it.polimi.ingsw.Observer.InputObserver;

import java.io.IOException;
import java.util.ArrayList;

public class ClientController extends ClientObservable implements InputObserver {
    private final ViewMessageManager messageManager;
    private final ObsClient client;

    /**
     * Constructs Client Controller.
     */
    public ClientController(ViewMessageManager messageManager, ObsClient obsClient) {
        this.messageManager = messageManager;
        this.client = obsClient;
    }

    /**
     * Checks if the given port string is in the range of allowed ports.
     */
    public static boolean isValidPort(String portStr) {
        try {
            int port = Integer.parseInt(portStr);
            return port >= 1 && port <= 65535;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void onUpdateColumn(String column) {
        notifyObserver(obs->obs.sendMessageToServer(new ColumnResponse(column)));
    }

    @Override
    public void onUpdateOrder(ArrayList<Integer> order, ArrayList<Item> itemToOrder) {
        notifyObserver(obs->obs.sendMessageToServer(new ItemOrderResponse(order,itemToOrder)));
    }

    /**
     * Sends a message to the server with the updated nickname.
     * The nickname is also stored locally for later usages.
     *
     * @param nickname the nickname to be sent.
     */
    @Override
    public void onUpdateNickname(String nickname) {
        //update(new Login(nickname));
        notifyObserver(obs->obs.sendMessageToServer(new Login(nickname)));
    }

    @Override
    public void onUpdateServerInfo(String address, int port){
        removeAllObservers();
        try {
            SocketClient socketClient = new SocketClient(address, port, client);
            socketClient.start();
            this.addObserver(socketClient);
            update(new ConnectionOK(true));
        }catch(IOException e){
            update(new Error("error in update server info in client controller"));
        }
    }

    /**
     * this method is used to bring "Messages to Client" from Server to cli
     */
    public void update(Message message){
        message.manageView(messageManager);
    }

    @Override
    public void onUpdateNPlayers(String numberOfPlayer) {
        notifyObserver(obs->obs.sendMessageToServer(new NPlayer(numberOfPlayer)));
    }

    @Override
    public void onUpdateChooseItem(Message message) {
        notifyObserver(obs->obs.sendMessageToServer(message));
    }

    @Override
    public void onUpdateChoose(ChoosePositionResponse message) {
        notifyObserver(obs->obs.sendMessageToServer(message));
    }

    @Override
    public void chat(Chat message) {
        notifyObserver(obs->obs.sendMessageToServer(message));
    }

    @Override
    public void newGame(){
        notifyObserver(obs->obs.sendMessageToServer(new newGame()));
    }

    @Override
    public void onUpdateDisconnection() {
        notifyObserver(ClientObserver::disconnect);
    }
}
