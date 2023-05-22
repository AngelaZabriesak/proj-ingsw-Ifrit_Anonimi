package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Message.Message;

/**
 * Interface used to implement the Observer-Observable pattern between Server and GameController.
 * This interface allows the Server to observe the GameController.
 * It contains the methods to send the message to the clients.
 */
public interface GameControllerObserver {

    /**
     * Send the message to the specified client
     * @param message the message to be sent
     * @param nickname the client nickname
     */
    void sendToOnePlayer(Message message, String nickname);

    /**
     * Send the message to every connected client
     * @param message the message to be sent
     */
    void sendToAllPlayers(Message message);

    void successfulLogin(Message message,String tmpNickname, String newName);
    
    void disconnectAll();
}
