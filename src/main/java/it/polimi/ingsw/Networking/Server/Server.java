package it.polimi.ingsw.Networking.Server;


import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Message.MessageToServer;
import it.polimi.ingsw.View.VirtualView;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * Main server class that starts a socket server.
 */
public class Server implements Runnable{

    private GameController gameController;

    private ServerSocket serverSocket;
    private Socket socket;
    private final Map<String, ClientHandler> clientHandlerMap;
    private final Object lock;
    private int port,id=0;

    public Server(GameController gameController,int port) {
        this.gameController = gameController;
        this.clientHandlerMap = Collections.synchronizedMap(new HashMap<>());
        this.port = port;
        this.lock = new Object();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Socket server started on port " + port + ".");
        } catch (IOException e) {
            System.out.println("Server could not start!");
            return;
        }

        try{
            while(!Thread.currentThread().isInterrupted()){
                //blocking until a connection is made
                socket = serverSocket.accept();
                SocketClientHandler clientHandler = new SocketClientHandler(this,socket);
                Thread thread = new Thread(clientHandler);
                id++;
                thread.start();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
        try{
            serverSocket.close();
        }catch (IOException e){
            System.exit(1);
        }
    }


    public void addClient(String nickname, ClientHandler clientHandler) {
        VirtualView vv = new VirtualView(clientHandler);

        if (!gameController.isGameStarted()) {
            if (gameController.nicknameIsUsed(nickname, vv)) {
                clientHandlerMap.put(nickname, clientHandler);
                gameController.loginHandler(nickname, vv);
            }
        } else {
            vv.showLoginResult(true, false, null);
            clientHandler.disconnect();
        }

    }

    public void removeClient(String nickname, boolean enable) {
        clientHandlerMap.remove(nickname);
        gameController.removeVirtualView(nickname, enable);
        System.out.println("Removed " + nickname + " from the client list.");
    }

    /**
     * Forwards a received message from the client to the GameController.
     */
    public void onMessageReceived(MessageToServer message) {
        gameController.onMessageReceived(message);
    }

    /**
     * Handles the disconnection of a client.
     *
     * @param clientHandler the client disconnecting.
     */
    public void onDisconnect(ClientHandler clientHandler) {
        synchronized (lock) {
            String nickname = clientHandlerMap.entrySet().stream().filter(entry -> clientHandler.equals(entry.getValue())).map(Map.Entry::getKey).findFirst().orElse(null);

            if (nickname != null) {

                boolean gameStarted = gameController.isGameStarted();
                removeClient(nickname, !gameStarted); // enable lobby notifications only if the game didn't start yet.

                if(gameController.getTurnController() != null &&
                        !gameController.getTurnController().getNicknameList().contains(nickname)) {
                    return;
                }

                // Resets server status only if the game was already started.
                // Otherwise the server will wait for a new player to connect.
                if (gameStarted) {
                    gameController.broadcastDisconnectionMessage(nickname, " disconnected from the server. GAME ENDED.");

                    gameController.endGame();
                    clientHandlerMap.clear();
                }
            }
        }
    }
}
