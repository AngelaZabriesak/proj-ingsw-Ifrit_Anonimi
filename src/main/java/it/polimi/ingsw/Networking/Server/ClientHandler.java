package it.polimi.ingsw.Networking.Server;


import it.polimi.ingsw.Message.Message;

import java.io.IOException;

/**
 * Interface to handle clients. Every type of connection must implement this interface.
 */
public interface ClientHandler {
    boolean isConnected();
    void disconnect();
    void sendMessageToClient(Message message);
    void readMessageFromClient() throws IOException, ClassNotFoundException;
}
