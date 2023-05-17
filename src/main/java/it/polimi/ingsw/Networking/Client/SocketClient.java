package it.polimi.ingsw.Networking.Client;

import it.polimi.ingsw.Message.Error.Error;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Observer.ObserverNew.ClientObserver;
import it.polimi.ingsw.Observer.ObserverNew.SocketClientObservable;

import java.io.*;
import java.net.*;

// Client class
public class SocketClient extends SocketClientObservable implements ClientObserver {
    private final Socket socket;
    private ObjectOutputStream writeToServer;
    private ObjectInputStream readFromServer;

    public SocketClient(String address, int port, ObsClient client) throws IOException {
        this.socket = new Socket();
        this.addObserver(client);
        try {
            this.socket.connect(new InetSocketAddress(address,port));
            this.writeToServer = new ObjectOutputStream(socket.getOutputStream());
            this.readFromServer = new ObjectInputStream(socket.getInputStream());// object of scanner class
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Error in creating socket\n");
            this.socket.close();
        }
    }

    public void start(){
        final Thread thread = new Thread(this::readMessageFromServer);
        thread.start();
    }

    public void readMessageFromServer() {
        while (true){
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

    @Override
    public void sendMessageToServer(Message message) {
        try{
            writeToServer.writeObject(message);
            writeToServer.reset();
        }catch (IOException e){
            System.out.println("Not send message");
        }
    }

    @Override
    public void disconnect() {
        try{
            removeAllObservers();
            socket.close();
        } catch (IOException e ){
            notifyObserver(obs->obs.update(new Error("Could not disconnect.")));
        }
    }
}
