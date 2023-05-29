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
import it.polimi.ingsw.Model.Goal.CommonGoal.Cgoal;
import it.polimi.ingsw.Observer.GameControllerObservable;
import it.polimi.ingsw.Observer.Observer;
import it.polimi.ingsw.Observer.ServerObserver;

import java.util.*;

public class GameController extends GameControllerObservable implements ServerObserver, Observer {
    private Game game;
    private TurnController turnController;
    private final ArrayList<Player> players;
    private int numberOfPlayer;
    private ArrayList<Item> itemsToOrder = new ArrayList<>();
    private boolean gameStarted = false,gameEnded = false;
    public GameController(){
        players = new ArrayList<>();
        this.numberOfPlayer = 9999;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Game getGame() {
        return game;
    }

    private void startGame(){
        gameStarted = true;
        System.out.println("Starting game for "+players.size()+" players");
        this.game = new Game(players);
        game.addObserver(this);
        game.initialize();
        this.turnController = new TurnController(this,players);
        notifyObserver();
        System.out.println("Game created!");
        notifyObserver(obs->obs.sendToAllPlayers(new GameStart(game.getPlayers(),game.getCGoal(),turnController.getCurrentPlayer().getMyGoal())));
        notifyAllPlayer(turnController.getCurrentPlayer());
        startTurn();
    }

    private void startTurn(){
        notifyObserver(obs->obs.sendToOnePlayer(new Item1PositionRequest(null,game.getBoard(),turnController.getCurrentPlayer().getMyShelf(),game.getCGoal(),game.getCurrentPlayer().getMyGoal(),game.getPositionAvailable(null,null), turnController.getCurrentPlayer()),turnController.getCurrentPlayer().getNickname()));
        //notifyObserver(obs -> obs.sendToOnePlayer(new NItemRequest(game.getBoard(),game.getCGoal(),game.getCurrentPlayer().getMyGoal()),turnController.getCurrentPlayer().getNickname()));
    }

    /**
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
        return gameStarted;
    }

    /*public void winGame(String winner) {
        System.out.println(winner+" won!");
        notifyObserver(obs->obs.sendToAllPlayers(new Win(winner)));
        notifyObserver(GameControllerObserver::disconnectAll);
    }*/

    @Override
    public void update(Message message) {
        notifyObserver(obs->obs.sendToOnePlayer(message, message.getNickname()));
    }

    @Override
    public void loginHandler(Login message) {
        System.out.println("Received login message");
        if(getPlayerByNickname(message.getNewNickname())==null && players.size() <= numberOfPlayer && !gameStarted){
            players.add(new Player(message.getNewNickname()));
            notifyObserver(obs->obs.successfulLogin(new CompletedQuestion("Login successful "+message.getNewNickname()),message.getNickname(), message.getNewNickname()));
            if(numberOfPlayer==9999) {
                notifyObserver(obs->obs.sendToOnePlayer(new NPlayerRequest(),message.getNewNickname()));
            }
        }
        else {
            if(getPlayerByNickname(message.getNewNickname())!=null) {
                notifyObserver(obs -> obs.sendToOnePlayer(new Error("Nickname already used ,choose another!"), message.getNickname()));
                notifyObserver(obs -> obs.sendToOnePlayer(new LoginRequest(), message.getNickname()));
            }
        }
        if(players.size() == numberOfPlayer)
            startGame();
    }

    @Override
    public void numberOfPlayerHandler(NPlayer message) {
        int nPlayer;
        if(isInt(message.getnPlayer())){
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
                notifyObserver(obs -> obs.sendToOnePlayer(new Wait(numberOfPlayer-players.size()),message.getNickname()));
            }
        }
    }

    @Override
    public void showShelfRequestHandler(ShelfRequest message) {
        notifyObserver(obs->obs.sendToOnePlayer(new ShelfResponse(Objects.requireNonNull(getPlayerByNickname(message.getNickname())).getMyShelf(),getPlayerByNickname(message.getNickname())),message.getNickname()));
    }

    @Override
    public void showBoardRequestHandler(BoardRequest message) {
        notifyObserver(obs->obs.sendToOnePlayer(new BoardResponse(game.getBoard()),message.getNickname()));
    }

    @Override
    public void endGameDisconnection() {
        ArrayList<Integer> punteggi = new ArrayList<>();
        gameEnded = true;
        game.endGame();
        int indiceVincitore = players.indexOf(turnController.getCurrentPlayer());
        ArrayList<Player> playerMancanti = new ArrayList<>();
        for(indiceVincitore++;indiceVincitore<players.size();indiceVincitore++){
            playerMancanti.add(players.get(indiceVincitore));
        }
        for(Player p : playerMancanti) {
            turnController.setCurrentPlayer(p);
            notifyObserver(obs -> obs.sendToOnePlayer(new Item1PositionRequest(null, game.getBoard(),p.getMyShelf(), game.getCGoal(), game.getCurrentPlayer().getMyGoal(),game.getPositionAvailable(null,null),p), p.getNickname()));
        }
        for(Player p : players){
            game.calcScore(p);
            punteggi.add(p.getMyScore());
            System.out.println(p.getMyScore());
        }

        /*punteggi.stream().sorted();
        for (Player p : players){
            if (p.getMyScore() == punteggi.get(punteggi.size()-1))
        }*/

        notifyObserver(obs->obs.sendToAllPlayers(new Win(players)));
    }

    @Override
    public void waitPlayers(Wait message) {
        notifyObserver(obs->obs.sendToOnePlayer(message,message.getNickname()));
    }

    @Override
    public void moveToColumn(ColumnResponse message) {
        int nColumn,score = 0;
        if(isInt(message.getColumn())){
            notifyObserver(obs->obs.sendToOnePlayer(new ColumnRequest("Invalid number of column, is not integer", Objects.requireNonNull(getPlayerByNickname(message.getNickname())).getMyItem(), Objects.requireNonNull(getPlayerByNickname(message.getNickname())).getMyShelf(), turnController.getCurrentPlayer()), message.getNickname()));
        }
        else {
            if(checkActivePlayer(message.getNickname())) {
                try {
                    nColumn = Integer.parseInt(message.getColumn());
                    game.setAction(new AddItemInShelf(game, nColumn, getPlayerByNickname(message.getNickname())));
                    game.doAction();
                    /*for(Cgoal cg : game.getCGoal()){
                        if(cg.isTaken(getPlayerByNickname(message.getNickname()).getMyShelf())){
                            score = cg.getToken().getScore();
                            getPlayerByNickname(message.getNickname()).addMyScore(score);
                            int finalScore = score;
                            notifyObserver(obs->obs.sendToOnePlayer(new GoalTake(cg, finalScore),message.getNickname()));
                        }
                    }*/
                    if(!gameEnded) {
                        if (Objects.requireNonNull(getPlayerByNickname(message.getNickname())).getMyShelf().getNEmpty() == 0)
                            endGameDisconnection();
                        else {
                            notifyObserver(obs -> obs.sendToOnePlayer(new EndTurn(turnController.getCurrentPlayer(), turnController.getNextNickname()), message.getNickname()));
                            nextPlayer();
                        }
                    }
                } catch (ActionException e) {
                    //System.out.println(e);
                    notifyObserver(obs -> obs.sendToOnePlayer(new ColumnRequest(e.getMessage(), Objects.requireNonNull(getPlayerByNickname(message.getNickname())).getMyItem(), Objects.requireNonNull(getPlayerByNickname(message.getNickname())).getMyShelf(), turnController.getCurrentPlayer()), message.getNickname()));
                }
            }
            else {
                notifyObserver(obs -> obs.sendToOnePlayer(new Error("It's not your turn phase"), message.getNickname()));
            }
        }
    }

    private void nextPlayer(){
        turnController.setNextPlayer();
        notifyActivePlayer(turnController.getCurrentPlayer());
        startTurn();
        itemsToOrder = new ArrayList<>();
    }

    @Override
    public void choose1ItemPosition(Item1PositionResponse message) {
        if(checkActivePlayer(message.getNickname())){
            try {
                /*for(Position p : game.getPositionAvailable(null,null)){
                    System.out.println(p.getRow()+"-"+p.getCol()+"   ");
                }*/
                game.setAction(new ChooseItem(game,getPlayerByNickname(message.getNickname()),null,null,message.getP()));
                game.doAction();
                itemsToOrder.add(game.getBoard().getItem(message.getP()));
                checkAvailability(message.getP(),null,message.getNickname());
            } catch (ActionException e) {
                notifyObserver(obs->obs.sendToOnePlayer(new Item1PositionRequest(e.getMessage(),null,null,null,null,null, turnController.getCurrentPlayer()), message.getNickname()));
            }
        }
        else{
            notifyObserver(obs->obs.sendToOnePlayer(new Error("It's not your turn, is turn of "+turnController.getCurrentPlayer().getNickname()), message.getNickname()));
        }
    }

    private void checkAvailability(Position p1, Position p2,String nickname){
        int max =0;
        for(int i =0;i<5;i++){
            if(Objects.requireNonNull(getPlayerByNickname(nickname)).getMyShelf().getFreeRowByColumn(i)>max)
                max = Objects.requireNonNull(getPlayerByNickname(nickname)).getMyShelf().getFreeRowByColumn(i);
        }
        if(game.getPositionAvailable(p1,p2).size()>0 && max- Objects.requireNonNull(getPlayerByNickname(nickname)).getMyItem().size()>0) {
            notifyObserver(obs -> obs.sendToOnePlayer(new ChoosePositionRequest(game.getBoard() ,p1, p2,game.getPositionAvailable(p1,p2)), nickname));
        }
        else{
            if(itemsToOrder.size() != 1){
                notifyObserver(obs -> obs.sendToOnePlayer(new ItemOrderRequest(null,turnController.getCurrentPlayer().getMyItem(),turnController.getCurrentPlayer().getMyShelf(), turnController.getCurrentPlayer()), nickname));
            }
            else{
                notifyObserver(obs -> obs.sendToOnePlayer(new ColumnRequest(null,turnController.getCurrentPlayer().getMyItem(),turnController.getCurrentPlayer().getMyShelf(), turnController.getCurrentPlayer()), nickname));
            }
        }
    }

    @Override
    public void manageChoose(ChoosePositionResponse message) {
        if(game.getPositionAvailable(message.getP1(),message.getP2()).size()>0) {
            if (message.getResponse().equalsIgnoreCase("yes")) {
                if (itemsToOrder.size() == 1)
                    notifyObserver(obs -> obs.sendToOnePlayer(new Item2PositionRequest(game.getBoard() ,null,message.getP1(),game.getPositionAvailable(message.getP1(),null)), message.getNickname()));
                else
                    notifyObserver(obs -> obs.sendToOnePlayer(new Item3PositionRequest(game.getBoard(),null,message.getP1(),message.getP2(),game.getPositionAvailable(message.getP1(),message.getP2())), message.getNickname()));
            } else if (message.getResponse().equalsIgnoreCase("no")) {
                if(itemsToOrder.size() != 1){
                    notifyObserver(obs -> obs.sendToOnePlayer(new ItemOrderRequest(null,turnController.getCurrentPlayer().getMyItem(),turnController.getCurrentPlayer().getMyShelf(), turnController.getCurrentPlayer()), message.getNickname()));
                }
                else{
                    notifyObserver(obs -> obs.sendToOnePlayer(new ColumnRequest(null,turnController.getCurrentPlayer().getMyItem(),turnController.getCurrentPlayer().getMyShelf(), turnController.getCurrentPlayer()), message.getNickname()));
                }
            } else {
                notifyObserver(obs -> obs.sendToOnePlayer(new Error("Input error"), message.getNickname()));
                notifyObserver(obs -> obs.sendToOnePlayer(new ChoosePositionRequest(game.getBoard() ,message.getP1(), message.getP2(),game.getPositionAvailable(message.getP1(),message.getP2())), message.getNickname()));
            }
        }
        else{
            if(itemsToOrder.size() != 1){
                notifyObserver(obs -> obs.sendToOnePlayer(new ItemOrderRequest(null,turnController.getCurrentPlayer().getMyItem(),turnController.getCurrentPlayer().getMyShelf(), turnController.getCurrentPlayer()), message.getNickname()));
            }
            else{
                notifyObserver(obs -> obs.sendToOnePlayer(new ColumnRequest(null,turnController.getCurrentPlayer().getMyItem(),turnController.getCurrentPlayer().getMyShelf(), turnController.getCurrentPlayer()), message.getNickname()));
            }
        }
    }

    @Override
    public void choose2ItemPosition(Item2PositionResponse message) {
        if(checkActivePlayer(message.getNickname())){
            try {
                /*for(Position p : game.getPositionAvailable(message.getP1(),null))
                    System.out.println(p.getRow()+"-"+p.getCol()+"   ");*/
                game.setAction(new ChooseItem(game,getPlayerByNickname(message.getNickname()),message.getP1(),null,message.getP2()));
                game.doAction();
                itemsToOrder.add(game.getBoard().getItem(message.getP2()));
                checkAvailability(message.getP1(),message.getP2(), message.getNickname());
            } catch (ActionException e) {
                notifyObserver(obs->obs.sendToOnePlayer(new Item2PositionRequest(game.getBoard(),e.getMessage(), message.getP1(),game.getPositionAvailable(message.getP1(),null)), message.getNickname()));
            }
        }
        else{
            notifyObserver(obs->obs.sendToOnePlayer(new Error("It's not your turn, is turn of "+turnController.getCurrentPlayer().getNickname()), message.getNickname()));
        }
    }

    @Override
    public void choose3ItemPosition(Item3PositionResponse message) {
        if(checkActivePlayer(message.getNickname())){
            try {
                /*for(Position p : game.getPositionAvailable(message.getP1(),message.getP2()))
                    System.out.println(p.getRow()+"-"+p.getCol()+"   ");*/
                game.setAction(new ChooseItem(game,getPlayerByNickname(message.getNickname()),message.getP1(),message.getP2(),message.getP3()));
                game.doAction();
                itemsToOrder.add(game.getBoard().getItem(message.getP3()));
                checkAvailability(message.getP1(),message.getP2(),message.getNickname());
            } catch (ActionException e) {
                notifyObserver(obs->obs.sendToOnePlayer(new Item3PositionRequest(game.getBoard(), e.getMessage(),message.getP1(),message.getP2(),game.getPositionAvailable(message.getP1(),message.getP2())), message.getNickname()));
            }
        }
        else{
            notifyObserver(obs->obs.sendToOnePlayer(new Error("It's not your turn, is turn of "+turnController.getCurrentPlayer().getNickname()), message.getNickname()));
        }
    }

    @Override
    public void chooseOrderItem(ItemOrderResponse message) {
        if(checkActivePlayer(message.getNickname())){
            game.setAction(new ChooseOrder(game,getPlayerByNickname(message.getNickname()),message.getOrder()));
            try{
                game.doAction();
                notifyObserver(obs->obs.sendToOnePlayer(new ColumnRequest(null, Objects.requireNonNull(getPlayerByNickname(message.getNickname())).getMyItem(), Objects.requireNonNull(getPlayerByNickname(message.getNickname())).getMyShelf(), turnController.getCurrentPlayer()), message.getNickname()));
            }catch(ActionException e){
                notifyObserver(obs->obs.sendToOnePlayer(new ItemOrderRequest(e.getMessage() ,itemsToOrder,turnController.getCurrentPlayer().getMyShelf(), turnController.getCurrentPlayer()), message.getNickname()));
            }
        }
        else{
            notifyObserver(obs -> obs.sendToOnePlayer(new Error("It's not your turn phase"),message.getNickname()));
        }
    }

    @Override
    public void chat(Chat message) {
        notifyObserver(obs->obs.sendToAllPlayers(message));
    }

    @Override
    public void clientDisconnection() {
        System.out.println("Client disconnection");
    }

    @Override
    public void newGame() {
        game.removeObserver(this);
        startGame();
    }

    public void notifyActivePlayer(Player currentPlayer) {
        notifyObserver(obs->obs.sendToOnePlayer(new TurnAlert("It's your turn"),currentPlayer.getNickname()));
    }

    public void notifyAllPlayer(Player currentPlayer) {
        notifyObserver(obs->obs.sendToOnePlayer(new TurnAlert("It's your turn"),currentPlayer.getNickname()));
        for(Player p : players){
            if(!p.equals(currentPlayer))
                notifyObserver(obs->obs.sendToOnePlayer(new TurnAlert("It's turn of "+currentPlayer.getNickname()),p.getNickname()));
        }
    }

    private boolean isInt(String message){
        try{
            Integer.parseInt(message);
            return false;
        }catch (Exception e){
            return true;
        }
    }
}
