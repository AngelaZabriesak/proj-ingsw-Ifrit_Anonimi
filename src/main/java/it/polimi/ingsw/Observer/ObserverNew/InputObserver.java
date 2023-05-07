package it.polimi.ingsw.Observer.ObserverNew;

import it.polimi.ingsw.Message.Response.ItemPositionResponse;
import it.polimi.ingsw.Message.Request.BoardRequest;
import it.polimi.ingsw.Message.Request.ShelfRequest;
import it.polimi.ingsw.Model.Bag.Item;

import java.util.ArrayList;

/**
 * Interface used to implement the Observer-Observable pattern between Cli and ClientController.
 * This interface allows ClientController to observe Cli.
 * It contains methods to send a client request for server or generally a messageToServer.
 * These are raw messages that will be created and standardized in ClientController.
 * Every method contains an input or a request from Client
 */
public interface InputObserver {

    /**
     * Create a new connection to the server with the updated column.
     *
     * @param column the number of the column to be sent.
     */
    void onUpdateColumn(String column);
    void onUpdateNItem(int nItem);
    void onUpdateOrder(String order, ArrayList<Item> itemToOrder);
    void onUpdateNickname(String nickname);
    void onUpdateServerInfo(String address,int port);
    void onUpdateNPlayers(int numberOfPlayer);
    void onUpdateShelfRequest(ShelfRequest message);
    void onUpdateBoardRequest(BoardRequest message);
    void onUpdateChooseItem(ItemPositionResponse message);
    void onUpdateDisconnection();
}
