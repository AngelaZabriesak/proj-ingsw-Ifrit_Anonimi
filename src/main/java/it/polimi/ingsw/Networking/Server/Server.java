package it.polimi.ingsw.Networking.Server;


import it.polimi.ingsw.Controller.*;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Message.MessageManager;
import it.polimi.ingsw.Observer.ObserverNew.*;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Main server class that starts a socket server.
 */
public class Server implements Runnable, LoginObserver, GameControllerObserver {

    private MessageManager messageManager; //observed by gameController
    private GameController gameController;
    private ServerSocket serverSocket;
    private Socket socket;
    private final Map<String, ClientHandler> clientHandlerMap;
    private boolean endGame;
    private int port;

    public Server(int port) {
        this.clientHandlerMap = Collections.synchronizedMap(new HashMap<>());
        this.port = port;
        messageManager = new MessageManager();
    }

    public void notifyAllPlayers(Message message){
        for(ClientHandler c : clientHandlerMap.values()){
            c.sendMessageToClient(message);
        }
    }

    public void notifyPlayer(Message message, String nickname){
        for(String c : clientHandlerMap.keySet()){
            if(c.equals(nickname)){
                clientHandlerMap.get(c).sendMessageToClient(message);
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
                SocketClientHandler clientHandler = new SocketClientHandler(this,socket,Integer.toString(clientHandlerMap.size()));
                clientHandlerMap.put(Integer.toString(clientHandlerMap.size()),clientHandler);
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
    public void successfulLogin(Message message,String tmpNickname, String newName) {
        ClientHandler c = clientHandlerMap.get(tmpNickname);
        clientHandlerMap.remove(tmpNickname,c);
        clientHandlerMap.put(newName,c);
        notifyPlayer(message,newName);
    }

    @Override
    public void disconnectAll() {
        if(!endGame) {

            endGame = true;
            System.out.println("Closing all sockets");
            for (ClientHandler clientHandler : clientHandlerMap.values()) {
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
        clientHandlerMap.remove(clientHandler.getNickname(),clientHandler);
    }

    public void read(Message message){
        message.manage(messageManager);
    }
}
