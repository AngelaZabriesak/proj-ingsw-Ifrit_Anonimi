package it.polimi.ingsw.Networking.Server;

import it.polimi.ingsw.Controller.*;
import it.polimi.ingsw.Message.*;
import it.polimi.ingsw.Observer.ObserverNew.*;

import java.util.*;

/**
 * This class contains all the method needed to communicate between the players and the gameControllers
 */
public class Server implements GameControllerObserver {

    private final ServerMessageManager serverMessageManager; //observed by GameController
    private final ArrayList<SocketClientHandler> clientHandlers;
    private boolean gameEnded;

    public Server(){
        serverMessageManager = new ServerMessageManager();
        clientHandlers = new ArrayList<>();
        gameEnded = false;
    }


    public void addObserverMessageManager(GameController gc) {
        this.serverMessageManager.addObserver(gc);
    }

    /**
     * Send a message to every connected client
     * @param message the message to be sent
     */
    public void notifyAllPlayers(Message message)  {
        for(SocketClientHandler c: clientHandlers){
            c.sendMessageToClient(message);
        }
    }

    /**
     * Send a message to one client
     */
    public void notifyPlayer(Message message, String nickname)  {
        for(SocketClientHandler c: clientHandlers){
            if(c.getNickname().equals(nickname)){
                c.sendMessageToClient(message);
                break;
            }
        }
    }

    /**
     * Passes the received message to the serverMessageHandler
     * @param message the message received
     */
    public void read(Message message){
        message.manageServer(serverMessageManager);
    }

    @Override
    public void sendToOnePlayer(Message message, String nickName)  {
        notifyPlayer(message,nickName);
    }

    @Override
    public void sendToAllPlayers(Message message) {
        notifyAllPlayers(message);

    }

    /**
     * Handles the final part of the login of a client:
     *      sends a completedRequestMessage to the client,
     *      sets his clientHandler name to the name chosen by the player
     * @param message is a completedRequestMessage sent to the client
     * @param temporaryName is the automatically assigned name to the clientHandler before the player's login
     * @param newName is the name indicated by the client during login
     */
    public void successfulLogin(Message message, String temporaryName, String newName){
        clientHandlers.get(Integer.parseInt(temporaryName)).setNickname(newName);
        notifyPlayer(message,newName);
    }

    /**
     * Closes every socket and set gameEnded to true
     */
    public void disconnectAll(){
        if(!gameEnded) {

            gameEnded = true;
            System.out.println("Closing all sockets");
            for (SocketClientHandler clientHandler : clientHandlers) {
                clientHandler.disconnect();
            }
            System.out.println("All sockets closed");
        }
    }

    /**
     * calls the serverMessageHandler the method to end the game and warn and disconnect every client
     */
    public void clientDisconnection(){
        if(!gameEnded)
            serverMessageManager.clientDisconnection();
    }

    public void addClientHandler(SocketClientHandler clientHandler) {
        this.clientHandlers.add(clientHandler);
    }

    public ArrayList<SocketClientHandler> getClientHandlers(){
        return this.clientHandlers;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }
}
