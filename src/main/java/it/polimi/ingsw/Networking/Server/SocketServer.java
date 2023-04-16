package it.polimi.ingsw.Networking.Server;

import it.polimi.ingsw.Message.*;

import java.io.*;
import java.lang.*;
import java.net.*;

/**
 * This class implements java Socket server
 */
public class SocketServer implements Runnable {
    private final Server server;
    private final int port;
    private ServerSocket serverSocket;

    public SocketServer(Server server, int port) {
        this.server = server;
        this.port = port;
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

        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket client = serverSocket.accept();

                client.setSoTimeout(5000);

                SocketClientHandler clientHandler = new SocketClientHandler(this, client);
                Thread thread = new Thread(clientHandler);
                thread.start();
            } catch (IOException e) {
                System.out.println("Connection dropped");
            }
        }
    }

    /**
     * Handles the addition of a new client.
     */
    public void addClient(String nickname, ClientHandler clientHandler) {
        server.addClient(nickname, clientHandler);
    }

    /**
     * Forwards a received message from the client to the Server.
     */
    public void onMessageReceived(Message message) {
        server.onMessageReceived(message);
    }

    /**
     * Handles a client disconnection.
     */
    public void onDisconnect(ClientHandler clientHandler) {
        server.onDisconnect(clientHandler);
    }
}
