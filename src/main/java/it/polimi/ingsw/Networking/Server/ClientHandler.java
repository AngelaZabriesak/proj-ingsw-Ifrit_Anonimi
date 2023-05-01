package it.polimi.ingsw.Networking.Server;

import it.polimi.ingsw.Message.Message;

/**
 * Interface to handle clients. Every type of connection must implement this interface.
 */
public interface ClientHandler {
    void disconnect();
    void sendMessageToClient(Message message);
}
