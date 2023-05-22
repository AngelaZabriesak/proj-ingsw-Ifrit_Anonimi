package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Message.Chat;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Message.Response.*;
import it.polimi.ingsw.Message.Request.*;
import it.polimi.ingsw.Model.Bag.*;

import java.io.IOException;
import java.util.*;

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
    void onUpdateOrder(ArrayList<Integer> order, ArrayList<Item> itemToOrder);
    void onUpdateNickname(String nickname);
    void onUpdateServerInfo(String address,int port);
    void onUpdateNPlayers(String numberOfPlayer);
    void onUpdateChooseItem(Message message);
    void onUpdateChoose(ChoosePositionResponse message);
    void chat(Chat message);
    void newGame();
    void onUpdateDisconnection();
}
