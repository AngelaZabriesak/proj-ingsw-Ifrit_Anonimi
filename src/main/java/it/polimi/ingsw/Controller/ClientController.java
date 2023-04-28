package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.*;
import it.polimi.ingsw.Networking.Client.*;
import it.polimi.ingsw.Observer.*;
import it.polimi.ingsw.Observer.Observer;
import it.polimi.ingsw.View.*;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class ClientController implements ViewObserver, Observer {

    private final View view;
    private Client client;
    private String nickname;
    private final ExecutorService taskQueue;

    /**
     * Constructs Client Controller.
     *
     * @param view the view to be controlled.
     */
    public ClientController(View view) {
        this.view = view;
        taskQueue = Executors.newSingleThreadExecutor();
    }

    /**
     * Checks if the given port string is in the range of allowed ports.
     */
    public static boolean isValidPort(String portStr) {
        try {
            int port = Integer.parseInt(portStr);
            return port >= 1 && port <= 65535;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Create a new Socket Connection to the server with the updated info.
     * An error view is shown if connection cannot be established.
     */
    @Override
    public void onUpdateServerInfo(Map<String, String> serverInfo) {
        client = new SocketClient(serverInfo.get("address"), Integer.parseInt(serverInfo.get("port")));
        client.addObserver(this);
        client.readMessageFromServer(); // Starts an asynchronous reading from the server.
        //client.enablePinger(true);
        taskQueue.execute(view::askNickname);
    }

    /**
     * Sends a message to the server with the updated nickname.
     * The nickname is also stored locally for later usages.
     *
     * @param nickname the nickname to be sent.
     */
    @Override
    public void onUpdateNickname(String nickname) {
        this.nickname = nickname;
        client.sendMessageToServer(new MessageToServer(this.nickname, MessageType.LOGIN_REPLY,"login"));
    }

    @Override
    public void update(MessageToClient message) {
        // switch sul tipo di messaggio
    }
}
