package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Message.*;
import it.polimi.ingsw.Message.Request.*;
import it.polimi.ingsw.Message.GameState.*;
import it.polimi.ingsw.Message.Response.ColumnResponse;
import it.polimi.ingsw.Message.Response.ItemOrderResponse;
import it.polimi.ingsw.Message.Response.ItemPositionResponse;
import it.polimi.ingsw.Message.Response.NItemResponse;
import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Networking.Client.*;
import it.polimi.ingsw.Observer.ObserverNew.*;

import java.util.ArrayList;

public class ClientController extends ClientObservable implements InputObserver {
    private ViewMessageManager messageManager;
    private ObsClient client;

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
    public void onUpdateNItem(String nItem) {
        notifyObserver(obs->obs.sendMessageToServer(new NItemResponse(nItem)));
    }

    @Override
    public void onUpdateOrder(String order, ArrayList<Item> itemToOrder) {
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
    public void onUpdateServerInfo(String address, int port) {
        removeAllObservers();
        SocketClient socketClient = new SocketClient(address,port,client);
        socketClient.start();
        this.addObserver(socketClient);
        socketClient.readMessageFromServer(); // Starts an asynchronous reading from the server.
        update(new ConnectionOK(true));
    }

    /**
     * this method is used to bring "Messages to Client" from Server to cli
     */
    public void update(Message message){
        message.manageView(messageManager);
    }

    @Override
    public void onUpdateNPlayers(String numberOfPlayer) {
        notifyObserver(obs->obs.sendMessageToServer(new NPlayer(""+numberOfPlayer)));
    }

    @Override
    public void onUpdateShelfRequest(ShelfRequest message) {
        notifyObserver(obs->obs.sendMessageToServer(message));
    }

    @Override
    public void onUpdateBoardRequest(BoardRequest message) {
        notifyObserver(obs->obs.sendMessageToServer(message));
    }

    @Override
    public void onUpdateChooseItem(ItemPositionResponse message) {
        notifyObserver(obs->obs.sendMessageToServer(message));
    }

    @Override
    public void onUpdateDisconnection() {
        notifyObserver(obs->obs.disconnect());
    }
}
