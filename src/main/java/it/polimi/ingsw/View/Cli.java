package it.polimi.ingsw.View;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.Observer.ViewObservable;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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
