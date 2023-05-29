package it.polimi.ingsw.View;

import it.polimi.ingsw.Message.Action.*;
import it.polimi.ingsw.Message.Error.Error;
import it.polimi.ingsw.Message.GameState.*;
import it.polimi.ingsw.Message.Request.*;
import it.polimi.ingsw.Message.Response.*;
import it.polimi.ingsw.Message.*;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.*;

public class VirtualView implements ViewObserver {
    private final View view;

    public VirtualView(View view){
        this.view = view;
    }

    @Override
    public void ErrorManager(Error message) {
        view.showError(message.getError());
    }

    @Override
    public void endTurnHandler(EndTurn message) {
        view.showShelf(message.getActualPlayer().getMyShelf(), message.getActualPlayer());
        view.showMessage(message.getActualPlayer().getNickname() + ", your turn ended! Now is " + message.getNextPlayer() + "'s turn");
    }

    @Override
    public void ConnectionSuccessfulHandler(ConnectionOK message) {
        view.askNickname();
    }

    @Override
    public void CompleteQuestionManager(CompletedQuestion message) {
        view.showMessage(message.getMessage());
    }

    @Override
    public void showShelfHandler(ShelfResponse message) {
        view.showShelf(message.getShelf(), message.getPlayer());
    }

    @Override
    public void showBoardHandler(BoardResponse message) {
        view.showBoard(message.getBoard());
    }

    @Override
    public void GameStartedHandler(GameStart message) {
        view.initGame(message);
    }

    @Override
    public void TurnAlert(TurnAlert message) {
        view.showMessage(message.getDescr());
    }

    //tells the game winner
    @Override
    public void winHandler(Win message) {
        for(Player p : message.getPlayers())
            view.showScore(p);
        view.askEnd();
    }

    //tells the game ended because of player disconnection
    @Override
    public void GameEndedHandler(EndGame message) {
        view.showMessage("THE GAME ENDED, PLAYER " + message.getNickname() + "DISCONNECTED!");
    }

    @Override
    public void chooseItemPosition(Item1PositionRequest message) {
        if(message.getBoard()!=null && message.getCommonGoals()!=null && message.getMyPgoal()!=null) {
            view.showTable(message.getBoard(),message.getAvailablePosition(),message.getShelf(),message.getCommonGoals(),message.getMyPgoal(),message.getPlayer());
        }
        if (message.getError()!=null)
            view.showError(message.getError());
        view.askItem(message.getBoard(),null,null,message.getAvailablePosition());
    }

    @Override
    public void chooseOtherItemPosition(Item2PositionRequest message) {
        if (message.getError()!=null)
            view.showError(message.getError());
        view.askItem(message.getBoard(),message.getP1(),null,message.getPositionAvailable());
    }

    @Override
    public void chooseOtherItemPosition(Item3PositionRequest message) {
        if (message.getError()!=null)
            view.showError(message.getError());
        view.askItem(message.getBoard(),message.getP1(),message.getP2(),message.getPosAvailable());
    }

    @Override
    public void chooseItem(ChoosePositionRequest message) {
        view.askOther(message);
    }

    @Override
    public void chooseOrderItemOK(ChooseOrder_OK message) {
        view.showMessage(message.getDescription());
    }

    @Override
    public void addItemInShelf(AddItemInShelf_OK message) {
        view.showShelf(message.getShelf(),message.getPlayer());
    }

    @Override
    public void chooseItemOk(ChooseItem_OK message) {
        view.showMessage(message.getDescription());
    }

    @Override
    public void chooseOrderItem(ItemOrderRequest message) {
        view.showShelf(message.getShelf(), message.getPlayer());
        view.showItemToOrder(message.getItems());
        view.askOrder(message.getItems());
    }

    @Override
    public void chooseColumn(ColumnRequest message) {
        view.showMessage("Your item ordered are: ");
        view.showItemToOrder(message.getItemOrdered());
        view.showShelf(message.getShelf(), message.getPlayer());
        view.askColumn();
    }

    @Override
    public void nicknameHandler(LoginRequest message) {
        view.askNickname();
    }

    @Override
    public void chat(Chat message) {
        view.showMessage(message.getNickname()+": "+message.getMsg());
    }

    @Override
    public void newGame() {
        view.showMessage("Starting a new game");
    }

    @Override
    public void goalTake(GoalTake message) {
        view.showMessage("You conquered the goal "+message.getGoal().getDescription()+"\nYou have "+message.getScore()+" points");
    }

    // method that asks for number of players
    @Override
    public void NumOfPlayerHandler(NPlayerRequest message) {
        view.askNPlayers();
    }


    @Override
    public void waitPlayers(Wait message) {
        view.showWait(message.getnPlayer());
    }

}
