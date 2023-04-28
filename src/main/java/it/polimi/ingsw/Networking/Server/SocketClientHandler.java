package it.polimi.ingsw.Networking.Server;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.*;

import java.io.*;
import java.net.*;

public class SocketClientHandler implements ClientHandler, Runnable {
    private final Socket client;
    private boolean connected;
    private final Object inputLock;
    private final Object outputLock;
    private final Server server;
    private ObjectOutputStream toClient;
    private ObjectInputStream fromClient;

    public SocketClientHandler(Server server, Socket socket) {
        this.server = server;
        this.client = socket;
        this.connected = true;

        this.inputLock = new Object();
        this.outputLock = new Object();

        try {
            this.toClient = new ObjectOutputStream(socket.getOutputStream());
            this.fromClient = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("Client connected from " + client.getInetAddress());
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("1 qui socketclienthandler");
                synchronized (inputLock) {
                    readMessageFromClient();
                }
            }
            client.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Client " + client.getInetAddress() + " connection dropped."+e.getMessage());
            disconnect();
        }
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

            server.onDisconnect(this);
        }
    }

    /**
     * Sends a message to the client via socket.
     */
    @Override
    public void sendMessageToClient(MessageToClient message) {
        synchronized (outputLock) {
            try {
                toClient.writeObject(message);
                toClient.reset();
                System.out.println("Sent: " + message.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
                disconnect();
            }
        }
    }

    @Override
    public void readMessageFromClient() throws IOException, ClassNotFoundException {
        MessageToServer message = (MessageToServer) fromClient.readObject();
        System.out.println("Ricevuto: "+message.getMessage());
        System.out.println("2 qui socketclienthandler");
        if (message.getMessage().equalsIgnoreCase("end")) disconnect();
        if (message.getMessage() != null) {
            if (message.getMessageType().equals(MessageType.LOGIN_REPLY)) {
                server.addClient(message.getMessage(), this);
            }
            server.onMessageReceived(message);
        }
        //System.out.println("3 qui socketclienthandler");
    }
}
