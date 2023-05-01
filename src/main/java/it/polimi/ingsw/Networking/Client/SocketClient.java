package it.polimi.ingsw.Networking.Client;

import it.polimi.ingsw.Message.Error.Error;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Observer.ObserverNew.ClientObserver;
import it.polimi.ingsw.Observer.ObserverNew.SocketClientObservable;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

// Client class
public class SocketClient extends SocketClientObservable implements ClientObserver {
    private final Socket socket;

    private ObjectOutputStream writeToServer;
    private ObjectInputStream readFromServer;

    private String line = null;

    private final ExecutorService readExecution;

    public SocketClient(String address, int port, ObsClient client){
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

    public void start(){
        final Thread thread = new Thread(){
            public void run(){
                readMessageFromServer();
            }
        };
        thread.start();
    }
/*
    public void sendMessageToServer(MessageToServer message) {
        while(!message.getMessage().equalsIgnoreCase("exit")) {
            try {
                writeToServer.writeObject(message);
                writeToServer.reset();
            } catch (IOException e) {
                disconnect();
                notifyObserver(new InputError("Not send message."));
            }
        }
        disconnect();
    }*/

    public void readMessageFromServer() {
        readExecution.execute(
                ()->{
                    while (!readExecution.isShutdown()){
                        try{
                            Message message = (Message) readFromServer.readObject();
                            notifyObserver(obs->obs.update(message));
                        } catch (Exception e) {
                            Error message = new Error("Connection lost");
                            notifyObserver(obs->obs.update(message));
                            disconnect();
                            break;
                        }
                    }
                }
        );
    }

    @Override
    public void sendMessageToServer(Message message) {
        try{
            System.out.println(message.getNickname()+" is sending a "+message.getType());
            writeToServer.writeObject(message);
            writeToServer.reset();
        }catch (IOException e){
            System.out.println("Not send message");
        }
    }

    @Override
    public void disconnect() {
        try{
            if(!socket.isClosed()){
                removeAllObservers();
                readExecution.shutdown();
                socket.close();
            }
        } catch (IOException e ){
            notifyObserver(obs->obs.update(new Error("Could not disconnect.")));
        }
    }
}
