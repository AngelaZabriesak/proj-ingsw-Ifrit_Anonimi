package it.polimi.ingsw.View;

import it.polimi.ingsw.Controller.*;
import it.polimi.ingsw.Message.GameState.*;
import it.polimi.ingsw.Message.ItemPosition;
import it.polimi.ingsw.Message.Request.NPlayerRequest;
import it.polimi.ingsw.Message.Response.BoardResponse;
import it.polimi.ingsw.Message.Response.ShelfResponse;
import it.polimi.ingsw.Message.TurnAlert;
import it.polimi.ingsw.Message.Error.Error;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.Goal.CommonGoal.*;
import it.polimi.ingsw.Model.Goal.Goal;
import it.polimi.ingsw.Model.Goal.PersonalGoal.*;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.*;
import it.polimi.ingsw.Observer.ObserverNew.InputObservable;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Cli extends InputObservable implements View, ViewObserver {

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

    public void init() {
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

        if (!address.equals("")) {
            defaultAddress = address;
        }

        do {
            out.print("Enter the server port [" + defaultPort + "]: ");
            String port = readLine();

            if (port.equals("")) {
                serverInfo.put("port", defaultPort);
                validPort = true;
            } else {
                if (ClientController.isValidPort(port)) {
                    defaultPort = port;
                    validPort = true;
                } else {
                    out.println("Invalid port!");
                    validPort = false;
                }
            }
        } while (!validPort);

        String finalDefaultPort = defaultPort;
        String finalDefaultAddress = defaultAddress;
        notifyInObserver(obs -> obs.onUpdateServerInfo(finalDefaultAddress, Integer.parseInt(finalDefaultPort)));
    }

    // method that asks for the nickname

    @Override
    public void askNickname() {
        out.print("Enter your nickname: ");
        try {
            String nickname = readLine();
            System.out.println("read " + nickname);
            notifyInObserver(obs -> obs.onUpdateNickname(nickname));
        } catch (ExecutionException e) {
            out.println("Error askNickname");
        }
    }

    // method that asks for number of players

    @Override
    public void NumOfPlayerHandler(NPlayerRequest message) {
        askNPlayers();
    }


    @Override
    public void askNPlayers() {
        out.print("How many players are in this match?");
        try {
            String nPlayers = readLine();
            notifyInObserver(obs -> obs.onUpdateNPlayers(Integer.parseInt(nPlayers)));
        } catch (ExecutionException e) {
            out.println("Error askNPlayers");
        }
    }

    // method that asks you to choose Items from Board

    @Override
    public void askItem() {
        out.print("Choose the Items you want to pick from Board");
        Position fstItem = null;
        Position scdItem;
        Position trdItem;
        notifyInObserver(obs -> obs.onUpdateChooseItem(new ItemPosition(fstItem)));
    }

    // method that asks you to choose the column of the Shelf in which you want to put your Items
    @Override
    public void askColumn() {
        out.print("Choose the column in your Shelf");
        try{
            String column = readLine();
            notifyInObserver(obs -> obs.onUpdateColumn(column));
        } catch (ExecutionException e){
            out.println("Error askColumn");
        }
    }

    // method that asks you to choose the order of Items in Shelf
    @Override
    public void askOrder() {
        out.print("Choose the insertion order of Items in your Shelf");
        notifyInObserver(obs -> obs.onUpdateOrder());
    }

    // method that shows the Board

    @Override
    public void showBoard(Board board) {
        out.println("This is the current Board\n"+board);

    }

    //method that shows the personal Shelf
    @Override
    public void showShelf(Shelf shelf) {
        out.println("This is your Shelf\n");
        String s = "";
        for (int r = 0; r < shelf.getRow(); r++) {
            for (int c = 0; c < shelf.getCol(); c++) {
                if (shelf.getMyShelf()[r][c] != null)
                    s += "|\t" + shelf.getMyShelf()[r][c].getColor() + "\t";
                else
                    s += "|\tnull\t";
            }
            s += "|\n";
        }
        out.println(s);
    }

    //method that shows the personal score
    public void showScore(Player player) {
        out.println("Your current score is " +player.getMyScore());
    }

    //method that shows the PGoal
    @Override
    public void showPGoal(Pgoal pgoal) {
        out.println("This is your Personal Goal\n" + pgoal.getDescription());
    }

    //method that shows the CGoal
    @Override
    public void showCGoal(ArrayList<Cgoal> cgoal) {
        out.println("These are the Common Goals\n");
        for (Cgoal c : cgoal)
        {
            out.println(c.getDescription() + "\n");
        }
    }


    /**
     * Shows the login result on the terminal.
     * On login fail, the program is terminated immediately.
     */
    @Override
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

    @Override
    public void showError(String error) {
        out.println("\nERROR: " + error);
    }

    @Override
    public void ErrorManager(Error message) {
        showError(message.getError());
    }

    @Override
    public void endTurnHandler(EndTurn message) {
        GameController gameController;
        out.println(message.getNickname() + ", your turn ended! Now is " + /*gameController.notifyActivePlayer()*/ "'s turn");
    }

    @Override
    public void ConnectionSuccessfulHandler(ConnectionOK message) {
        askNickname();
    }

    @Override
    public void CompleteQuestionManager(CompletedQuestion message) {

    }

    @Override
    public void showShelfHandler(ShelfResponse message) {
        showShelf(message.getShelf());
    }

    @Override
    public void showBoardHandler(BoardResponse message) {
        showBoard(message.getBoard());
    }

    @Override
    public void GameStartedHandler(GameStart message) {

    }

    @Override
    public void TurnAlert(TurnAlert message) {

    }

    //tells the game winner
    @Override
    public void winHandler(Win message) {
        out.println("AND THE WINNER IS..... \n" + message.getNickname());
    }

    //tells the game ended because of player disconnection
    @Override
    public void GameEndedHandler(EndGame message) {
        out.println("THE GAME ENDED, PLAYER " + message.getNickname() + "DISCONNECTED!");

    }
}
