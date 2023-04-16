package it.polimi.ingsw.Networking.Client;

import it.polimi.ingsw.Message.*;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

/**
 * This class implements java socket client
 */
public class SocketClient extends Client {

    private final Socket socket;

    private final ObjectOutputStream outputStm;
    private final ObjectInputStream inputStm;
    private final ExecutorService readExecutionQueue;
    private final ScheduledExecutorService pinger;

    private static final int SOCKET_TIMEOUT = 10000;

    public SocketClient(String address, int port) throws IOException {
        this.socket = new Socket();
        this.socket.connect(new InetSocketAddress(address, port), SOCKET_TIMEOUT);
        this.outputStm = new ObjectOutputStream(socket.getOutputStream());
        this.inputStm = new ObjectInputStream(socket.getInputStream());
        this.readExecutionQueue = Executors.newSingleThreadExecutor();
        this.pinger = Executors.newSingleThreadScheduledExecutor();
    }

    /**
     * Asynchronously reads a message from the server via socket and notifies the ClientController.
     */
    @Override
    public void readMessage() {
        readExecutionQueue.execute(() -> {

            while (!readExecutionQueue.isShutdown()) {
                Message message;
                try {
                    message = (Message) inputStm.readObject();
                    System.out.println("Received: " + message);
                } catch (IOException | ClassNotFoundException e) {
                    message = new MessageError(null, "Connection lost with the server.");
                    disconnect();
                    readExecutionQueue.shutdownNow();
                }
                notifyObserver(message);
            }
        });
    }

    /**
     * Sends a message to the server via socket.
     *
     */
    @Override
    public void sendMessage(Message message) {
        try {
            outputStm.writeObject(message);

            outputStm.reset();
        } catch (IOException e) {
            disconnect();
            notifyObserver(new MessageError(null, "Could not send message."));
        }
    }

    /**
     * Disconnect the socket from the server.
     */
    @Override
    public void disconnect() {
        try {
            if (!socket.isClosed()) {
                readExecutionQueue.shutdownNow();
                enablePinger(false);
                socket.close();
            }
        } catch (IOException e) {
            notifyObserver(new MessageError(null, "Could not disconnect."));
        }
    }

    /**
     * Enable a ping message between client and server sockets to keep the connection alive.
     */
    public void enablePinger(boolean enabled) {
        if (enabled) {
            pinger.scheduleAtFixedRate(() -> sendMessage(new MessagePing()), 0, 1000, TimeUnit.MILLISECONDS);
        } else {
            pinger.shutdownNow();
        }
    }
}
