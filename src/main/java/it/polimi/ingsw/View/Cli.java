package it.polimi.ingsw.View;

import it.polimi.ingsw.Controller.*;
import it.polimi.ingsw.Message.*;
import it.polimi.ingsw.Message.Request.*;
import it.polimi.ingsw.Message.Response.*;
import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.Goal.CommonGoal.*;
import it.polimi.ingsw.Model.Goal.PersonalGoal.*;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.InputObservable;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Cli extends InputObservable implements View {

    private final PrintStream out;
    private final Scanner read;
    private InputReadTask inputThread;

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

        out.print("Enter the server address [" + defaultAddress + "]: ");

        String address = readLine();

        if (!address.equals("")) {
            defaultAddress = address;
        }
/*
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
*/
        String finalDefaultAddress = defaultAddress;
        notifyInObserver(obs -> {obs.onUpdateServerInfo(finalDefaultAddress, Integer.parseInt(defaultPort));
        });
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
        notifyInObserver(obs -> obs.onUpdateNPlayers(nPlayers));
    }

    // method that asks you to choose Items from Board
    @Override
    public void askItem(Position p1, Position p2) {
        Position position;
        out.print("Choose the position of the item you want to pick from Board [row-col]: ");
        String read = readLine();
        if(read.split(":")[0].equalsIgnoreCase("CHAT")) {
            notifyInObserver(obs -> obs.chat(new Chat(read)));
            askItem(p1,p2);
        }
        else{
            try{
                position = new Position(Integer.parseInt(read.split("-")[0]), Integer.parseInt(read.split("-")[1]));
                Position finalPosition = position;
                //System.out.println("Read "+finalPosition.getRow()+"-"+finalPosition.getCol());
                if(p1==null)
                    notifyInObserver(obs -> obs.onUpdateChooseItem(new Item1PositionResponse(finalPosition)));
                else if (p2==null)
                    notifyInObserver(obs -> obs.onUpdateChooseItem(new Item2PositionResponse(p1,finalPosition)));
                else
                    notifyInObserver(obs -> obs.onUpdateChooseItem(new Item3PositionResponse(p1,p2,finalPosition)));
            }catch(Exception e){
                out.println("Error in entering position of item");
                askItem(p1,p2);
            }
        }
    }

    @Override
    public void askOther(ChoosePositionRequest message) {
        out.println("Do you want to choose another item? (yes or no) ");
        String response = readLine();

        if(response.split(":")[0].equalsIgnoreCase("CHAT")) {
            notifyInObserver(obs -> obs.chat(new Chat(response)));
            askOther(message);
        }
        else
            notifyInObserver(obs->obs.onUpdateChoose(new ChoosePositionResponse(response,message.getP1(),message.getP2())));
    }

    // method that asks you to choose the column of the Shelf in which you want to put your Items
    @Override
    public void askColumn() {
        out.print("Choose the column in your Shelf");
        String column = readLine();
        if(column.split(":")[0].equalsIgnoreCase("CHAT")) {
            notifyInObserver(obs -> obs.chat(new Chat(column)));
            askColumn();
        }
        else {
            if (Integer.parseInt(column) < 0 || Integer.parseInt(column) > 4) {
                out.println("This id column isn't acceptable");
                askColumn();
            }
            notifyInObserver(obs -> obs.onUpdateColumn(column));
        }
    }

    // method that asks you to choose the order of Items in Shelf
    @Override
    public void askOrder(ArrayList<Item> itemToOrder) {
        ArrayList<Integer> orderInt = new ArrayList<>();
        out.print("Choose the insertion order of items in your Shelf, separated by -: ");
        String order = readLine();
        if(order.split(":")[0].equalsIgnoreCase("CHAT")) {
            notifyInObserver(obs -> obs.chat(new Chat(order)));
            askOrder(itemToOrder);
        }
        else {
            try {
                if (
                    order.split("-").length != itemToOrder.size() ||
                    max(order.split("-")) > itemToOrder.size() - 1 ||
                    areSame(order.split("-"))
                )
                    throw new Exception();
                for (int i = 0; i < itemToOrder.size(); i++) {
                    orderInt.add(Integer.parseInt(order.split("-")[i]));
                }
                notifyInObserver(obs -> obs.onUpdateOrder(orderInt, itemToOrder));
            } catch (Exception e) {
                out.println("Error in entering order of item");
                askOrder(itemToOrder);
            }
        }
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
        out.println(player.getNickname()+": Your current score is " +player.getMyScore());
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

    @Override
    public void showError(String error) {
        out.println("\nERROR: " + error);
    }

    @Override
    public void showMessage(String message) {
        out.println(message);
    }

    @Override
    public void askEnd(){
        out.println("Do you want to play other game?");
        String read = readLine();
        if(read.equalsIgnoreCase("no"))
            exit();
        else if(read.equalsIgnoreCase("yes"))
            notifyInObserver(obs->obs.newGame());
        else{
            out.println("Error in entered choose, choose again");
            askEnd();
        }
    }

    @Override
    public void exit() {
        inputThread.close();
        System.exit(1);
    }

    private int max(String[] order){
        int max = 0;
        for(int i=0; i< order.length; i++){
            if(Integer.parseInt(order[i])>max)
                max = Integer.parseInt(order[i]);
        }
        return max;
    }

    /**
     *
     * @param order is the array of the position choose by user
     * @return true if are some that are equals
     */
    private boolean areSame(String[] order){
        for(int i =0; i< order.length-1; i++){
            if(Integer.parseInt(order[i])==Integer.parseInt(order[i+1]))
                return true;
        }
        return false;
    }

}
