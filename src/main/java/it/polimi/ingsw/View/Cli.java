package it.polimi.ingsw.View;

import it.polimi.ingsw.Controller.*;
import it.polimi.ingsw.Model.Game.Game;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Observer.*;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Cli extends ViewObservable implements View{

    private final PrintStream out;
    private Thread inputThread;

    /**
     * Default constructor.
     */
    public Cli() {
        out = System.out;
    }


    /**
     * Reads a line from the standard input.
     */
    public String readLine() throws ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(new InputReadTask());
        inputThread = new Thread(futureTask);
        inputThread.start();

        String input = null;

        try {
            input = futureTask.get();
        } catch (InterruptedException e) {
            futureTask.cancel(true);
            Thread.currentThread().interrupt();
        }
        return input;
    }

    public void init(){
        out.println("My Shelfie");
        try {
            askServerInfo();
        } catch (ExecutionException e) {
            out.println("Error init");
        }
    }

    /**
     * Asks the server address and port to the user.
     *
     * @throws ExecutionException if the input stream thread is interrupted.
     */
    public void askServerInfo() throws ExecutionException {
        Map<String, String> serverInfo = new HashMap<>();
        String defaultAddress = "localhost";
        String defaultPort = "16847";
        boolean validPort;

        out.print("Enter the server address [" + defaultAddress + "]: ");

        String address = readLine();

        if (address.equals("")) {
            serverInfo.put("address", defaultAddress);
        }
        else{
            serverInfo.put("address", address);
        }

        do {
            out.print("Enter the server port [" + defaultPort + "]: ");
            String port = readLine();

            if (port.equals("")) {
                serverInfo.put("port", defaultPort);
                validPort = true;
            } else {
                if (ClientController.isValidPort(port)) {
                    serverInfo.put("port", port);
                    validPort = true;
                } else {
                    out.println("Invalid port!");
                    validPort = false;
                }
            }
        } while (!validPort);

        notifyObserver(obs -> obs.onUpdateServerInfo(serverInfo));
    }

    // method that asks for the nickname

    @Override
    public void askNickname() {
        out.print("Enter your nickname: ");
        try {
            String nickname = readLine();
            notifyObserver(obs -> obs.onUpdateNickname(nickname));
        } catch (ExecutionException e) {
            out.println("Error askNickname");
        }
    }

     // method that asks for number of players

    @Override
    public void askNPlayers() {
        out.print("How many players are in this match?");
        try{

            String nPlayers = readLine();
            notifyObserver(obs -> obs.onUpdateNPlayers(nPlayers));
        } catch (ExecutionException e){
            out.println("Error askNPlayers");
        }

    }

    // method that asks you to choose Items from Board

    @Override
    public void askItem() {
        out.print("Choose the Items you want to pick from Board");
        notifyObserver(obs -> obs.onUpdateItem());


        }


    // method that asks you to choose the column of the Shelf in which you want to put your Items


    @Override
    public void askColumn() {
        out.print("Choose the column in your Shelf");
        try{
            String column = readLine();
            notifyObserver(obs -> obs.onUpdateColumn(column));
        } catch (ExecutionException e){
            out.println("Error askColumn");
        }

    }



    // method that asks you to choose the order of Items in Shelf

    @Override
    public void askOrder() {
        out.print("Choose the insertion order of Items in your Shelf");

    }
    

    @Override
    public void showBoard() {
        out.println("This is the current Board\n");

    }

    @Override
    public void showShelf() {
        out.println("This is your Shelf\n" + new Player(inputThread.getName()).getMyShelf());
    }

    @Override
    public void showPGoal() {
        out.println("This is your Personal Goal\n" + new Player(inputThread.getName()).getMyGoal());
    }

    @Override
    public void showCGoal() {
        out.println("These are the Common Goals\n" + new Player(inputThread.getName()).getcGoal());
    }

    @Override
    public void showScore() {
        out.println("Yuor current score is " + new Player(inputThread.getName()).getMyScore());
    }

    @Override
    /**
     * Shows the login result on the terminal.
     * On login fail, the program is terminated immediatly.
     */
    public void showLoginResult(boolean nicknameAccepted, boolean connectionSuccessful, String nickname) {

        if (nicknameAccepted && connectionSuccessful) {
            out.println("Hi, " + nickname + "! You connected to the server.");
        } else if (connectionSuccessful) {
            askNickname();
        } else if (nicknameAccepted) {
            out.println("Max players reached. Connection refused.");
            out.println("EXIT.");

            System.exit(1);
        } else {
            showErrorAndExit("Could not contact server.");
        }
    }

    /**
     * Shows an error message and exit.
     */
    @Override
    public void showErrorAndExit(String error) {
        inputThread.interrupt();

        out.println("\nERROR: " + error);
        out.println("EXIT.");

        System.exit(1);
    }
}
