package it.polimi.ingsw.Networking.Server;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.GameState.Login;
import it.polimi.ingsw.Message.Message;

import java.io.*;
import java.net.*;

public class SocketClientHandler implements ClientHandler, Runnable {
    private final Socket client;
    private String nickname;
    private final Server server;
    private ObjectOutputStream toClient;
    private ObjectInputStream fromClient;

    public SocketClientHandler(Server server, Socket socket,String tempNickname) {
        this.server = server;
        this.client = socket;
        this.nickname = tempNickname;
        try {
            this.toClient = new ObjectOutputStream(socket.getOutputStream());
            this.fromClient = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public void run() {
        keepListen();
    }

    private void keepListen(){
        while(!Thread.currentThread().isInterrupted()){
            try {
                Message message = (Message) fromClient.readObject();
                if(message.getType().equals(MessageType.LOGIN))
                    setNickname(message.getNickname());
                else {
                    message.setNickname(nickname);
                }
                System.out.println("ClientHandler " + nickname + " received a message: " + message.getClass());
                server.read(message);
            } catch (IOException e) {
                if(!client.isClosed()){
                    System.out.println("Connection ended from clienthandler " + nickname);
                    server.removeClientHandler(this);
                    disconnect();
                    if(!server.isGameEnded())
                        server.clientDisconnection();
                }
                break;
            } catch (ClassNotFoundException e) {
                System.out.println("ClientHandler "+ nickname +" Class not found exc");
            }
        }
    }

    /**
     * Disconnect the socket.
     */
    @Override
    public void disconnect() {
        try {
            if(!client.isClosed()) {
                System.out.println("Closing socket: " + nickname);
                toClient.close();
                fromClient.close();
                client.close();
            }
        } catch (IOException e) {
            System.out.println("IOException when closing Socket: " + nickname);
        }
    }

    /**
     * Sends a message to the client via socket.
     */
    @Override
    public void sendMessageToClient(Message message) {
        try {
            System.out.println("ClientHandler "+ nickname +": Sends message "+ message.getClass() +" to " + nickname);
            toClient.writeObject(message);
            toClient.reset();
        } catch (IOException e) {
            System.out.println("ECCEZIONE \t"+e);
            System.out.println("ClientHandler "+ nickname + ": Error in sending message to " + nickname);
        }
    }


}
