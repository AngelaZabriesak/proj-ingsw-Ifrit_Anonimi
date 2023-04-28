package it.polimi.ingsw.Observer;

import java.util.Map;

/**
 * Custom observer interface for views. It supports different types of notification.
 */
public interface ViewObserver {

    /**
     * Create a new connection to the server with the updated info.
     *
     * @param serverInfo a map of server address and server port.
     */
    void onUpdateServerInfo(Map<String, String> serverInfo);

    /**
     * Sends a message to the server with the updated nickname.
     *
     * @param nickname the nickname to be sent.
     */
    void onUpdateNickname(String nickname);

    /**
     * Create a new connection to the server with the numbers of players.
     *
     * @param nPlayers the number of the players to be sent.
     */

    void onUpdateNPlayers(String nPlayers);

    /**
     * Create a new connection to the server with the updated column.
     *
     * @param column the number of the column to be sent.
     */

    void onUpdateColumn(String column);


  /**
 * Create a new connection to the server with the updated Items picked from Board.
 */

    void onUpdateItem( );

    /**
            * Create a new connection to the server with the updated the order of the Items in Shelf.
 */

    void onUpdateOrder();


}
