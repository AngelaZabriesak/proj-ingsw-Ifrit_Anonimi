package it.polimi.ingsw.View;

import it.polimi.ingsw.Controller.*;
import it.polimi.ingsw.Message.Request.*;
import it.polimi.ingsw.Message.Response.ItemPositionResponse;
import it.polimi.ingsw.Model.Bag.ColorItem;
import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.Goal.CommonGoal.*;
import it.polimi.ingsw.Model.Goal.PersonalGoal.*;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.ObserverNew.*;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Cli extends InputObservable implements View {

    private final PrintStream out;
    private final Scanner read;
    private InputReadTask inputThread;
    private Thread inputReader;

    /**
     * Default constructor.
     */
    public Cli() {
        out = System.out;
        read = new Scanner(System.in);
    }


    /**
     * Reads a line from the standard input.
     */
    public String readLine() {
        return read.nextLine();
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
        String nickname = readLine();
        notifyInObserver(obs -> obs.onUpdateNickname(nickname));
    }

    @Override
    public void askNPlayers() {
        out.print("How many players are in this match? ");
        String nPlayers = readLine();
        notifyInObserver(obs -> obs.onUpdateNPlayers(Integer.parseInt(nPlayers)));
    }

    // method that asks you to choose Items from Board

    @Override
    public void askItem(int nItem) {
        Position position;
        out.print("Choose the position of "+nItem+" items you want to pick from Board [row,col]: ");
        String read = readLine();
        position = new Position(Integer.parseInt(read.split(",")[0]),Integer.parseInt(read.split(",")[1]));
        notifyInObserver(obs -> obs.onUpdateChooseItem(new ItemPositionResponse(position)));
    }

    @Override
    public void askNItem(NItemRequest message) {
        showBoard(message.getBoard());
        showCGoal(message.getCommmonGoals());
        showPGoal(message.getMyPgoal());
        String msg="How many item do you want to put in your shelf? ";
        out.println(msg);
        String nItem = readLine();
        notifyInObserver(obs->obs.onUpdateNItem(Integer.parseInt(nItem)));
    }

    // method that asks you to choose the column of the Shelf in which you want to put your Items
    @Override
    public void askColumn(ArrayList<Item> itemOrdered,Shelf shelf) {
        out.println("Your item ordered are: ");
        showItemToOrder(itemOrdered);
        showShelf(shelf);
        out.print("Choose the column in your Shelf");
        String column = readLine();
        notifyInObserver(obs -> obs.onUpdateColumn(column));
    }

    // method that asks you to choose the order of Items in Shelf
    @Override
    public void askOrder(ArrayList<Item> itemToOrder) {
        showItemToOrder(itemToOrder);
        out.print("Choose the insertion order of items in your Shelf, separated by comma: ");
        String order = readLine();
        notifyInObserver(obs -> obs.onUpdateOrder(order,itemToOrder));
    }

    // method that shows the Board
    @Override
    public void showBoard(Board board) {
        StringBuilder b = new StringBuilder();
        for (int r = -1; r < 9; r++) {
            if(r==-1)
                b.append("|\tR\134C\t");
            else
                b.append("|\t").append(r).append("\t");
            for (int c = 0; c < 9; c++) {
                if (r==-1)
                    b.append("|\t  ").append(c).append("  \t");
                else if (board.getItem(new Position(r, c)) != null){
                    if(board.getItem(new Position(r,c)).getColor().equals(ColorItem.X)){
                        b.append("|\t  ").append(board.getItem(new Position(r,c)).getColor()).append("  \t");
                    }
                    else
                        b.append("|\t").append(board.getItem(new Position(r, c)).getColor()).append("\t");
                }

                else
                    b.append("|\tnull\t");
            }
            b.append("|\n");
        }
        out.println(b);
    }

    //method that shows the personal Shelf
    @Override
    public void showShelf(Shelf shelf) {
        out.println("This is your Shelf\n");
        StringBuilder s = new StringBuilder();
        for (int r = 0; r < shelf.getRow(); r++) {
            for (int c = 0; c < shelf.getCol(); c++) {
                if (shelf.getMyShelf()[r][c] != null)
                    s.append("|\t").append(shelf.getMyShelf()[r][c].getColor()).append("\t");
                else
                    s.append("|\tnull\t");
            }
            s.append("|\n");
        }
        out.println(s);
    }

    @Override
    public void showItemToOrder(ArrayList<Item> itemToOrder) {
        StringBuilder msgBuilder = new StringBuilder();
        for(Item i : itemToOrder)
            msgBuilder.append("|\t").append(i.getColor()).append("\t");
        String msg = msgBuilder.toString();
        msg+="\n";
        out.println(msg);
    }

    //method that shows the personal score
    @Override
    public void showScore(Player player) {
        out.println("Your current score is " +player.getMyScore());
    }

    //method that shows the PGoal
    @Override
    public void showPGoal(Pgoal pgoal) {
        out.println("This is your Personal Goal\n" + pgoal.getDescription());
        StringBuilder pg = new StringBuilder();
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 5; c++) {
                if(pgoal.getGoal()[r][c]!=null)
                    pg.append("|\t").append(pgoal.getGoal()[r][c].getColor()).append("\t");
                else
                    pg.append("|\t------\t");
            }
            pg.append("|\n");
        }
        out.println(pg);
    }

    //method that shows the CGoal
    @Override
    public void showCGoal(ArrayList<Cgoal> cgoal) {
        out.println("These are the Common Goals\n");
        for (Cgoal c : cgoal) {
            out.println(c.getDescription());
        }
    }


    /**
     * Shows the login result on the terminal.
     * On login fail, the program is terminated immediately.
     */
   /* @Override
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
    }*/

    /**
     * Shows an error message and exit.
     */
    @Override
    public void showErrorAndExit(String error) {
        inputThread.close();

        out.println("\nERROR: " + error);
        out.println("EXIT.");

        System.exit(1);
    }

    @Override
    public void showError(String error) {
        out.println("\nERROR: " + error);
    }

    @Override
    public void showMessage(String message) {
        out.println(message);
    }

}
