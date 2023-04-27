package it.polimi.ingsw.Network3;

import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Message.MessageError;
import it.polimi.ingsw.Networking.Client.Client;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Client class
class SocketClient extends Client {
    private Socket socket;

    private final ObjectOutputStream writeToServer;
    private final ObjectInputStream readFromServer;
    //private final Scanner readFromTastiera;
    private String line = null;

    private final ExecutorService readExecution;

    public SocketClient(String address, int port){
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(address,port));
            writeToServer = new ObjectOutputStream(socket.getOutputStream());
            readFromServer = new ObjectInputStream(socket.getInputStream());// object of scanner class
            //readFromTastiera = new Scanner(System.in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.readExecution = Executors.newSingleThreadExecutor();
    }

    @Override
    public void sendMessageToServer(Message message) {
        while(!message.getMessage().equalsIgnoreCase("exit")) {
            try {
                writeToServer.writeObject(message);
                writeToServer.reset();
            } catch (IOException e) {
                disconnect();
                notifyObserver(new MessageError(null, "Not send message."));
            }
        }
        disconnect();
    }

    @Override
    public void readMessageFromServer() {
        readExecution.execute(
                ()->{
                    while (!readExecution.isShutdown()){
                        try{
                            Message message =(Message) readFromServer.readObject();
                            notifyObserver(message);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
    }

    @Override
    public void disconnect() {
        try{
            if(!socket.isClosed()){
                readExecution.shutdownNow();
                socket.close();
            }
        } catch (IOException e ){
            notifyObserver(new MessageError(null, "Could not disconnect."));
        }
    }
}
