package it.polimi.ingsw.Networking.Server;


import it.polimi.ingsw.Controller.*;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Message.ServerMessageManager;
import it.polimi.ingsw.Observer.ObserverNew.*;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Main server class that starts a socket server.
 */
public class Server implements Runnable, LoginObserver, GameControllerObserver {

    private ServerMessageManager messageManager; //observed by gameController
    private GameController gameController;
    private ServerSocket serverSocket;
    private Socket socket;
    private final ArrayList<SocketClientHandler> clientHandler;
    private boolean endGame;
    private int port;

    public Server(int port) {
        this.clientHandler = new ArrayList<>();
        this.port = port;
        messageManager = new ServerMessageManager();
    }

    public void notifyAllPlayers(Message message){
        for(ClientHandler c : clientHandler){
            c.sendMessageToClient(message);
        }
    }

    public void notifyPlayer(Message message, String nickname){
        for(SocketClientHandler c : clientHandler){
            if(c.getNickname().equals(nickname)){
                c.sendMessageToClient(message);
                break;
            }
        }
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
        createNewGame();
        try{
            while(!Thread.currentThread().isInterrupted()){
                //blocking until a connection is made
                socket = serverSocket.accept();
                System.out.println("New client accepted!");
                SocketClientHandler clientHandler = new SocketClientHandler(this,socket,Integer.toString(this.clientHandler.size()));
                this.clientHandler.add(clientHandler);
                Thread thread = new Thread(clientHandler);
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

    private void createNewGame(){
        gameController = new GameController();
        gameController.addObserver((GameControllerObserver) this);
        gameController.addObserver((LoginObserver) this);
        messageManager.addObserver(gameController);
    }

    public boolean isGameEnded() {
        return endGame;
    }

    @Override
    public void update() {
        createNewGame();
    }

    @Override
    public void sendToOnePlayer(Message message, String nickname) {
        notifyPlayer(message,nickname);
    }

    @Override
    public void sendToAllPlayers(Message message) {
        notifyAllPlayers(message);
    }

    @Override
    public void successfulLogin(Message message/*,String tmpNickname*/, String newName) {
        //clientHandler.get(Integer.parseInt(tmpNickname)).setNickname(newName);
        notifyPlayer(message,newName);
    }

    @Override
    public void disconnectAll() {
        if(!endGame) {

            endGame = true;
            System.out.println("Closing all sockets");
            for (ClientHandler clientHandler : clientHandler) {
                clientHandler.disconnect();
            }
            System.out.println("All sockets closed");
        }
    }

    public void clientDisconnection(){
        if(!endGame)
            messageManager.clientDisconnection();
    }

    public void removeClientHandler(SocketClientHandler clientHandler){
        this.clientHandler.remove(clientHandler);
    }

    public void read(Message message){
        message.manageServer(messageManager);
    }
}
