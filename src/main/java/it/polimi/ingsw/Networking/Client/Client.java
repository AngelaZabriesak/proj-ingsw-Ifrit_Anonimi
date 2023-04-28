package it.polimi.ingsw.Networking.Client;

import it.polimi.ingsw.Message.*;
import it.polimi.ingsw.Observer.*;

public abstract class Client  extends Observable {
    /**
     * Sends a message to the server.
     *
     * @param message the message to be sent.
     */
    public abstract void sendMessageToServer(MessageToServer message);

    /**
     * Asynchronously reads a message from the server and notifies the ClientController.
     */
    public abstract void readMessageFromServer();

    /**
     * Disconnects from the server.
     */
    public abstract void disconnect();
}
