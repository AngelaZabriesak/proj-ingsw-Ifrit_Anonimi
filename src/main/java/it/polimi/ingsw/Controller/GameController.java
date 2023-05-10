package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Action.*;
import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.Message.*;
import it.polimi.ingsw.Message.Action.AddItemInShelf_OK;
import it.polimi.ingsw.Message.GameState.*;
import it.polimi.ingsw.Message.Request.*;
import it.polimi.ingsw.Message.Error.Error;
import it.polimi.ingsw.Message.Response.*;
import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.Observer;
import it.polimi.ingsw.Observer.ObserverNew.*;

import java.util.*;

public class GameController extends GameControllerObservable implements ServerObserver, Observer {
    private Game game;
    private TurnController turnController;
    private final ArrayList<Player> players;
    private int numberOfPlayer;
    private ArrayList<Item> itemsToOrder;
    private int nItemMoved;
    public GameController(){
        players = new ArrayList<>();
        this.numberOfPlayer = 2;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Game getGame() {
        return game;
    }

    private void startGame(){
        System.out.println("Starting game for "+players.size()+" players");
        this.game = new Game(players);
        game.addObserver(this);
        game.initialize();
        this.turnController = new TurnController(this,players);
        notifyObserver();
        System.out.println("Game created!");
        notifyObserver(obs->obs.sendToAllPlayers(new GameStart(game.getPlayers())));
        turnController.setCurrentPlayer(turnController.getCurrentPlayer());
        startTurn();
    }

    private void startTurn(){
        notifyObserver(obs -> obs.sendToOnePlayer(new NItemRequest(game.getBoard(),game.getCGoal(),game.getCurrentPlayer().getMyGoal()),turnController.getCurrentPlayer().getNickname()));
    }

    /**
     * @param nickname
     * @return return a player searching by his nickname
     */
    private Player getPlayerByNickname(String nickname) {
        for(Player p :players){
            if(p.getNickname().equals(nickname))
                return p;
        }
        return null;
    }

    private boolean checkActivePlayer(String nickname){
        return turnController.getCurrentPlayer().equals(getPlayerByNickname(nickname));
    }

    public TurnController getTurnController() {
        return turnController;
    }

    public boolean isGameStarted() {
        return false;
    }

    public void winGame(String winner) {
        System.out.println(winner+" won!");
        notifyObserver(obs->obs.sendToAllPlayers(new Win(winner)));
        notifyObserver(GameControllerObserver::disconnectAll);
    }

    @Override
    public void update(Message message) {
        notifyObserver(obs->obs.sendToOnePlayer(message, message.getNickname()));
    }

    @Override
    public void loginHandler(Login message) {
        System.out.println("Received login message");
        if(getPlayerByNickname(message.getNickname())==null && players.size() <= numberOfPlayer/* && !firstPlayerConnected*/){
            if(players.size()==0) {
                notifyObserver(obs->obs.sendToOnePlayer(new NPlayerRequest(),message.getNickname()));
            }
            players.add(new Player(message.getNickname()));
            notifyObserver(obs->obs.successfulLogin(new CompletedQuestion("Login successful"), message.getNewNickname()));
        }
        else {
            if(getPlayerByNickname(message.getNickname())!=null) {
                //notifyObserver(obs -> obs.sendToOnePlayer(new Error("Nickname already used ,choose another!"),));
                //notifyObserver(obs->obs.sendToOnePlayer(new LoginRequest(), message.getNickname()));
            }
        }
        if(players.size() == numberOfPlayer)
            startGame();
    }

    @Override
    public void numberOfPlayerHandler(NPlayer message) {
        int nPlayer;
        if(!isInt(message.getnPlayer())){
            notifyObserver(obs-> obs.sendToOnePlayer(new Error("Invalid number of players, is not integer "),message.getNickname()));
            notifyObserver(obs->obs.sendToOnePlayer(new NPlayerRequest(), message.getNickname()));
        }
        else{
            nPlayer = Integer.parseInt(message.getnPlayer());
            if(nPlayer<2 || nPlayer>4){
                notifyObserver(obs-> obs.sendToOnePlayer(new Error("Invalid number of players"),message.getNickname()));
                notifyObserver(obs->obs.sendToOnePlayer(new NPlayerRequest(), message.getNickname()));
            }
            else{
                this.numberOfPlayer = nPlayer;
                notifyObserver(obs -> obs.sendToOnePlayer(new CompletedQuestion("Number of players set to "+ numberOfPlayer ),message.getNickname()));
            }
        }
    }

    @Override
    public void showItemChooseForOrdering(ItemOrderRequest message) {
        notifyObserver(obs->obs.sendToOnePlayer(message, message.getNickname()));
    }

    @Override
    public void showShelfRequestHandler(ShelfRequest message) {
        notifyObserver(obs->obs.sendToOnePlayer(new ShelfResponse(getPlayerByNickname(message.getNickname()).getMyShelf()),message.getNickname()));
    }

    @Override
    public void showBoardRequestHandler(BoardRequest message) {
        notifyObserver(obs->obs.sendToOnePlayer(new BoardResponse(game.getBoard()),message.getNickname()));
    }

    @Override
    public void endGameDisconnection() {
    }

    @Override
    public void moveToColumn(ColumnResponse message) {
        int nColumn;
        if(!isInt(message.getColumn())){
            notifyObserver(obs-> obs.sendToOnePlayer(new Error("Invalid number of column, is not integer "),message.getNickname()));
            notifyObserver(obs->obs.sendToOnePlayer(new ColumnRequest(getPlayerByNickname(message.getNickname()).getMyItem(),getPlayerByNickname(message.getNickname()).getMyShelf()), message.getNickname()));
        }
        else {
            if(checkActivePlayer(message.getNickname())) {
                try {
                    nColumn = Integer.parseInt(message.getColumn());
                    if (nColumn < 0 || nColumn > 4) {
                        notifyObserver(obs -> obs.sendToOnePlayer(new Error("Invalid number of column"), message.getNickname()));
                        notifyObserver(obs -> obs.sendToOnePlayer(new ColumnRequest(getPlayerByNickname(message.getNickname()).getMyItem(), getPlayerByNickname(message.getNickname()).getMyShelf()), message.getNickname()));
                    } else if (checkActivePlayer(message.getNickname())) {
                        game.setAction(new AddItemInShelf(game, nColumn, getPlayerByNickname(message.getNickname())));
                        game.doAction();
                        notifyObserver(obs -> obs.sendToOnePlayer(new AddItemInShelf_OK(getPlayerByNickname(message.getNickname()).getMyShelf()), message.getNickname()));
                    }
                } catch (Exception e) {
                    if (e.getClass().equals(WinException.class))
                        winGame(((WinException) e).getNickname());
                    notifyObserver(obs -> obs.sendToOnePlayer(new Error("Invalid input parameters"), message.getNickname()));
                    notifyObserver(obs -> obs.sendToOnePlayer(new ColumnRequest(getPlayerByNickname(message.getNickname()).getMyItem(), getPlayerByNickname(message.getNickname()).getMyShelf()), message.getNickname()));
                }
                turnController.setNextPlayer();
                startTurn();
            }
            else {
                notifyObserver(obs -> obs.sendToOnePlayer(new Error("It's not your turn phase"), message.getNickname()));
            }
        }
    }

    @Override
    public void chooseItemPosition(ItemPositionResponse message) {
        int row,col;
        if(checkActivePlayer(message.getNickname())){
            try {
                row = message.getRow();
                col = message.getCol();
                game.setAction(new ChooseItem(game,row,col,getPlayerByNickname(message.getNickname())));
                game.doAction();
                itemsToOrder.add(game.getBoard().getItem(new Position(row,col)));
                if(turnController.getCurrentPlayer().getMyItem().size()==nItemMoved){
                    if(nItemMoved != 1){
                        notifyObserver(obs->obs.sendToOnePlayer(new ItemOrderRequest(turnController.getCurrentPlayer().getMyItem()), message.getNickname()));
                    }
                    else{
                        notifyObserver(obs->obs.sendToOnePlayer(new ColumnRequest(turnController.getCurrentPlayer().getMyItem(),turnController.getCurrentPlayer().getMyShelf()), message.getNickname()));
                    }
                }

            } catch (Exception e) {
                notifyObserver(obs->obs.sendToOnePlayer(new Error("Invalid input parameters"), message.getNickname()));
                notifyObserver(obs->obs.sendToOnePlayer(new ItemPositionRequest(nItemMoved), message.getNickname()));
            }
        }
        else{
            notifyObserver(obs->obs.sendToOnePlayer(new Error("It's not your turn, is turn of "+turnController.getCurrentPlayer().getNickname()), message.getNickname()));
        }
    }

    @Override
    public void chooseNItemToMove(NItemResponse message) {
        int nItem;
        if(checkActivePlayer(message.getNickname())) {
            if(!isInt(message.getnItem())){
                notifyObserver(obs -> obs.sendToOnePlayer(new Error("Invalid number of items,, is not integer"), message.getNickname()));
                notifyObserver(obs -> obs.sendToOnePlayer(new NItemRequest(game.getBoard(),game.getCGoal(),game.getCurrentPlayer().getMyGoal()), message.getNickname()));
            }
            else {
                nItem = Integer.parseInt(message.getnItem());
                if (nItem < 1 || nItem > 3) {
                    notifyObserver(obs -> obs.sendToOnePlayer(new Error("Invalid number of items"), message.getNickname()));
                    notifyObserver(obs -> obs.sendToOnePlayer(new NItemRequest(game.getBoard(), game.getCGoal(), game.getCurrentPlayer().getMyGoal()), message.getNickname()));
                } else {
                    this.itemsToOrder = new ArrayList<>();
                    this.nItemMoved = nItem;
                    notifyObserver(obs -> obs.sendToOnePlayer(new CompletedQuestion("Choosed " + nItemMoved + " items to move."), message.getNickname()));
                    for (int i = 0; i < nItemMoved; i++) {
                        int finalI = i;
                        notifyObserver(obs -> obs.sendToOnePlayer(new ItemPositionRequest(finalI), message.getNickname()));
                    }
                }
            }
        }
    }

    @Override
    public void chooseOrderItem(ItemOrderResponse message) {
        if(checkActivePlayer(message.getNickname())){
            game.setAction(new ChooseOrder(game,getPlayerByNickname(message.getNickname()),message.getOrder()));
            try{
                game.doAction();
            }catch(ActionException | WinException e){
                notifyObserver(obs->obs.sendToOnePlayer(new Error("Invalid input parameters"), message.getNickname()));
                notifyObserver(obs->obs.sendToOnePlayer(new ItemOrderRequest(itemsToOrder), message.getNickname()));
            }
        }
        else{
            notifyObserver(obs -> obs.sendToOnePlayer(new Error("It's not your turn phase"),message.getNickname()));
        }
    }

    public void notifyActivePlayer(Player currentPlayer) {
        notifyObserver(obs->obs.sendToOnePlayer(new TurnAlert("It's your turn"),currentPlayer.getNickname()));
        for(Player p : players){
            if(!p.equals(currentPlayer))
                notifyObserver(obs->obs.sendToOnePlayer(new TurnAlert("It's turn of "+currentPlayer.getNickname()),p.getNickname()));
        }
    }

    private boolean isInt(String message){
        try{
            Integer.parseInt(message);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
