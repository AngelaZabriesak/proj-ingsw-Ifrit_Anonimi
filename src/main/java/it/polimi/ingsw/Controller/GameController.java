package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Action.*;
import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.Message.*;
import it.polimi.ingsw.Message.GameState.*;
import it.polimi.ingsw.Message.Request.*;
import it.polimi.ingsw.Message.Error.Error;
import it.polimi.ingsw.Message.Response.*;
import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.ObserverNew.*;

import java.util.*;

public class GameController extends GameControllerObservable implements ServerObserver {
    private Game game;
    private TurnController turnController;
    private final ArrayList<Player> players;
    private int numberOfPlayer;
    private boolean firstPlayerConnected;
    private int nItemMoved;
    public GameController(){
        players = new ArrayList<>();
        firstPlayerConnected = true;
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
        this.turnController = new TurnController(this,players);
        notifyObserver();
        System.out.println("Game created!");
        notifyObserver(obs->obs.sendToAllPlayers(new GameStart()));
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
        notifyObserver(obs->obs.sendToAllPlayers(message));
    }

    @Override
    public void loginHandler(Login message) {
        if(getPlayerByNickname(message.getNickname())==null && players.size() < numberOfPlayer){
            if(players.size()==0) {
                firstPlayerConnected = true;
                notifyObserver(obs->obs.sendToOnePlayer(new NPlayerRequest(),message.getNickname()));
            }
            players.add(new Player(message.getNickname()));
            notifyObserver(obs->obs.successfulLogin(new CompletedQuestion("Welcome to my shelfie"), message.getNickname(), message.getNewNickname()));
        }
        if(players.size() == numberOfPlayer)
            startGame();
    }

    @Override
    public void numberOfPlayerHandler(NPlayer message) {
        if(message.getnPlayer()<2 || message.getnPlayer()>4){
            notifyObserver(obs-> obs.sendToOnePlayer(new Error("Invalid number of players"),message.getNickname()));
            notifyObserver(obs->obs.sendToOnePlayer(new NPlayerRequest(), message.getNickname()));
        }
        else{
            this.numberOfPlayer = message.getnPlayer();
            notifyObserver(obs -> obs.sendToOnePlayer(new CompletedQuestion("Number of players set to "+ numberOfPlayer ),message.getNickname()));
        }
    }

    @Override
    public void showItemChooseForOrdering(ItemOrderRequest message) {
        notifyObserver(obs->obs.sendToOnePlayer(new ItemOrderResponse(getPlayerByNickname(message.getNickname()).getMyItem()), message.getNickname()));
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
    public void moveToColumn(Column message) {
        if(checkActivePlayer(message.getNickname())){
            game.setAction(new AddItemInShelf(game, message.getColumn(), getPlayerByNickname(message.getNickname())));
            try {
                game.doAction();
            } catch (ActionException e) {
                notifyObserver(obs->obs.sendToOnePlayer(new Error("Invalid input parameters"), message.getNickname()));
            }
            catch(WinException e){
                winGame(e.getNickname());
            }
        }
        else{
            notifyObserver(obs -> obs.sendToOnePlayer(new Error("It's not your turn phase"),message.getNickname()));
        }
    }

    @Override
    public void chooseItemPosition(ItemPosition message) {
        int row,col;
        if(checkActivePlayer(message.getNickname())){
            row = message.getRow();
            col = message.getCol();
            game.setAction(new ChooseItem(game,row,col,getPlayerByNickname(message.getNickname())));
            try {
                game.doAction();
            } catch (ActionException | WinException e) {
                notifyObserver(obs->obs.sendToOnePlayer(new Error("Invalid input parameters"), message.getNickname()));
            }
        }
        else{
            notifyObserver(obs->obs.sendToOnePlayer(new Error("It's not your turn, is turn of "+turnController.getCurrentPlayer().getNickname()), message.getNickname()));
        }
    }

    @Override
    public void chooseNItemToMove(NItem message) {
        if(checkActivePlayer(message.getNickname())){
            this.nItemMoved = message.getnItem();
            notifyObserver(obs->obs.sendToOnePlayer(new CompletedQuestion("Choosed "+nItemMoved+" to move."), message.getNickname()));
        }
    }

    @Override
    public void chooseOrderItem(ItemOrderResponse message) {
        ArrayList<Integer> itemsOrder = new ArrayList<>();
        if(checkActivePlayer(message.getNickname())){
            for(Item i : message.getItems()){
                itemsOrder.add(message.getItems().indexOf(i));
            }
            game.setAction(new ChooseOrder(game,getPlayerByNickname(message.getNickname()),itemsOrder));
            try {
                game.doAction();
            } catch (ActionException | WinException e) {
                notifyObserver(obs->obs.sendToOnePlayer(new Error("Invalid input parameters"), message.getNickname()));
            }
        }
        else{
            notifyObserver(obs -> obs.sendToOnePlayer(new Error("It's not your turn phase"),message.getNickname()));
        }
    }

    public void notifyActivePlayer(Player currentPlayer) {
        notifyObserver(obs->obs.sendToOnePlayer(new TurnAlert(),currentPlayer.getNickname()));
    }
}
