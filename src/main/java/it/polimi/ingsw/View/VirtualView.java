package it.polimi.ingsw.View;

import it.polimi.ingsw.Message.Action.*;
import it.polimi.ingsw.Message.Error.Error;
import it.polimi.ingsw.Message.GameState.*;
import it.polimi.ingsw.Message.Request.*;
import it.polimi.ingsw.Message.Response.*;
import it.polimi.ingsw.Message.*;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.*;

import java.util.ArrayList;

public class VirtualView implements ViewObserver {
    private View view;

    public VirtualView(View view){
        this.view = view;
    }

    @Override
    public void ErrorManager(Error message) {
        view.showError(message.getError());
    }

    @Override
    public void endTurnHandler(EndTurn message) {
        view.showMessage(message.getNickname() + ", your turn ended! Now is " + message.getNextPlayer() + "'s turn");
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
        view.showShelf(message.getShelf());
    }

    @Override
    public void showBoardHandler(BoardResponse message) {
        view.showBoard(message.getBoard());
    }

    @Override
    public void GameStartedHandler(GameStart message) {
        StringBuilder msg = new StringBuilder("Welcome to My Shelfie \nThe order of player is :\n");
        for(Player p : message.getPlayers())
            msg.append("-> ").append(p.getNickname()).append("\n");
        view.showMessage(msg.toString());
    }

    @Override
    public void TurnAlert(TurnAlert message) {
        view.showMessage(message.getDescr());
    }

    //tells the game winner
    @Override
    public void winHandler(Win message) {
        view.showMessage("AND THE WINNER IS..... \n" + message.getNickname());
    }

    //tells the game ended because of player disconnection
    @Override
    public void GameEndedHandler(EndGame message) {
        view.showMessage("THE GAME ENDED, PLAYER " + message.getNickname() + "DISCONNECTED!");
    }

    @Override
    public void chooseItemPosition(ItemPositionRequest message) {
        view.askItem(message.getnItemToMove());
    }

    @Override
    public void chooseOrderItemOK(ChooseOrder_OK message) {
        view.showMessage(message.getDescription());
    }

    @Override
    public void addItemInShelf(AddItemInShelf_OK message) {
        view.showShelf(message.getShelf());
    }

    // method that asks for number of items to move
    @Override
    public void chooseNumberItem(NItemRequest message) {
        view.askNItem(message);
    }

    @Override
    public void chooseItemOk(ChooseItem_OK message) {
        view.showMessage(message.getDescription());
    }

    @Override
    public void chooseOrderItem(ItemOrderRequest message) {
        view.showItemToOrder(message.getItems());
        view.askOrder(message.getItems());
    }

    @Override
    public void chooseColumn(ColumnRequest message) {
        view.askColumn(message.getItemOrdered(), message.getShelf());
    }

    // method that asks for number of players
    @Override
    public void NumOfPlayerHandler(NPlayerRequest message) {
        view.askNPlayers();
    }
}
