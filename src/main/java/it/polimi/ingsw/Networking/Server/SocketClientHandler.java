package it.polimi.ingsw.Networking.Server;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.*;

import java.io.*;
import java.net.*;

public class SocketClientHandler implements ClientHandler, Runnable {
    private final Socket client;
    private final SocketServer socketServer;

    private boolean connected;

    private final Object inputLock;
    private final Object outputLock;

    private ObjectOutputStream output;
    private ObjectInputStream input;

    /**
     * Default constructor.
     *
     * @param socketServer the socket of the server.
     * @param client       the client connecting.
     */
    public SocketClientHandler(SocketServer socketServer, Socket client) {
        this.socketServer = socketServer;
        this.client = client;
        this.connected = true;

        this.inputLock = new Object();
        this.outputLock = new Object();

        try {
            this.output = new ObjectOutputStream(client.getOutputStream());
            this.input = new ObjectInputStream(client.getInputStream());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            handleClientConnection();
        } catch (IOException e) {
            System.out.println("Client " + client.getInetAddress() + " connection dropped.");
            disconnect();
        }
    }

    /**
     * Handles the connection of a new client and keep listening to the socket for new messages.
     */
    private void handleClientConnection() throws IOException {
        System.out.println("Client connected from " + client.getInetAddress());

        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("1 qui socketclienthandler");
                synchronized (inputLock) {
                    Message message = (Message) input.readObject();
                    System.out.println("2 qui socketclienthandler");

                    if (message != null && message.getMessageType() != MessageType.PING) {
                        if (message.getMessageType() == MessageType.LOGIN_REQUEST) {
                            socketServer.addClient(message.getNickname(), this);
                        } else {
                            System.out.println("Received: " + message);
                            socketServer.onMessageReceived(message);
                        }
                    }
                    System.out.println("3 qui socketclienthandler");
                }
            }
        } catch (ClassCastException | ClassNotFoundException e) {
            System.out.println("Invalid stream from client");
        }
        client.close();
    }

    /**
     * Returns the current status of the connection.
     */
    @Override
    public boolean isConnected() {
        return connected;
    }

    /**
     * Disconnect the socket.
     */
    @Override
    public void disconnect() {
        if (connected) {
            try {
                if (!client.isClosed()) {
                    client.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            connected = false;
            Thread.currentThread().interrupt();

            socketServer.onDisconnect(this);
        }
    }

    /**
     * Sends a message to the client via socket.
     *
     */
    @Override
    public void sendMessage(Message message) {
        try {
            synchronized (outputLock) {
                output.writeObject(message);
                output.reset();
                System.out.println("Sent: " + message);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            disconnect();
        }
    }
}
