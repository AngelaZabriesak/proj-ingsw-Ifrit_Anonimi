package it.polimi.ingsw.Networking.Server;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Observer.LoginObserver;

import java.io.*;
import java.net.*;

public class MainSocketServer implements LoginObserver {

    private final int port;
    private ServerSocket serverSocket;
    private GameController gameController;
    private Server server;

    public MainSocketServer(int port){
        this.port = port;
    }

    public void startServer(){
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Socket server started on port " + port + ".");
        } catch (IOException e) {
            System.out.println("Server could not start!");
            return;
        }
        createNewGame();
        try{
            while(true){
                //blocking until a connection is made
                Socket socket = serverSocket.accept();
                System.out.println("New client accepted!");
                SocketClientHandler clientHandler = new SocketClientHandler(server,socket,Integer.toString(server.getClientHandlers().size()));
                server.addClientHandler(clientHandler);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createNewGame(){
        gameController = new GameController();
        server = new Server();
        server.addObserverMessageManager(gameController);
        gameController.addObserver(server);
        gameController.addObserver(this);
    }
    @Override
    public void update() {
        createNewGame();
    }
}
