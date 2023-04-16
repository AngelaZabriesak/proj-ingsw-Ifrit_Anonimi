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
}
