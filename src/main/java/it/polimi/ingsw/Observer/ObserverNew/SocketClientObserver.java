package it.polimi.ingsw.Observer.ObserverNew;

import it.polimi.ingsw.Message.Message;

/**
 * Interface used to implement the Observer-Observable pattern between ObserverClient and SocketClient.
 * This interface allows ObserverClient to observe the SocketClient.
 * It contains methods to response to a client request or generally a message to client.
 */
public interface SocketClientObserver {
    /**
     * Method used to avoid different methods using overloading
     * @param message is a messageToClient and is different from each message
     */
    void update(Message message);
}
