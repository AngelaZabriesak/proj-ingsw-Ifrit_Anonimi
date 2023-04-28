package it.polimi.ingsw.Networking.Client;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.*;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

// Client class
public class SocketClient extends Client {
    private final Socket socket;

    private ObjectOutputStream writeToServer;
    private ObjectInputStream readFromServer;

    private String line = null;

    private final ExecutorService readExecution;

    public SocketClient(String address, int port){
        this.socket = new Socket();
        try {
            this.socket.connect(new InetSocketAddress(address,port));
            this.writeToServer = new ObjectOutputStream(socket.getOutputStream());
            this.readFromServer = new ObjectInputStream(socket.getInputStream());// object of scanner class
        } catch (IOException e) {
            System.out.println("Error in creating socket\n");
        }
        this.readExecution = Executors.newSingleThreadExecutor();
    }

    @Override
    public void sendMessageToServer(MessageToServer message) {
        while(!message.getMessage().equalsIgnoreCase("exit")) {
            try {
                writeToServer.writeObject(message);
                writeToServer.reset();
            } catch (IOException e) {
                disconnect();
                notifyObserver(new MessageToClient(null, MessageType.ERROR, "Not send message."));
            }
        }
        disconnect();
    }

    @Override
    public void readMessageFromServer() {
        readExecution.execute(
                ()->{
                    while (!readExecution.isShutdown()){
                        MessageToClient message;
                        try{
                            message = (MessageToClient) readFromServer.readObject();
                        } catch (Exception e) {
                            message = new MessageToClient(null,MessageType.ERROR,"Connection lost");
                        }
                        notifyObserver(message);
                    }
                }
        );
    }

    @Override
    public void disconnect() {
        try{
            if(!socket.isClosed()){
                readExecution.shutdown();
                socket.close();
            }
        } catch (IOException e ){
            notifyObserver(new MessageToClient(null,MessageType.ERROR, "Could not disconnect."));
        }
    }
}
