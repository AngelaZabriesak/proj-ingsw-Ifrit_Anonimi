package it.polimi.ingsw.Observer.ObserverNew;

import it.polimi.ingsw.Message.Message;

/**
 * Interface used to implement the Observer-Observable pattern between SocketClient and ClientController.
 * This interface allows SocketClient to observe ClientController.
 * It contains methods to send a client request for server or generally a messageToServer.
 */
public interface ClientObserver {
    /**
     * Method used to avoid different methods using overloading
     * @param message is a messageToServer and is different from each message
     */
    void sendMessageToServer(Message message);

    /**
     * Used to disconnect a client
     */
    void disconnect();

}
