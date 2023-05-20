package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Message.Action.*;
import it.polimi.ingsw.Message.Error.ErrorPlayer;
import it.polimi.ingsw.Message.GameState.*;
import it.polimi.ingsw.Message.Request.*;
import it.polimi.ingsw.Message.Response.*;
import it.polimi.ingsw.Message.*;
import it.polimi.ingsw.Message.Error.Error;

/**
 * Custom observer interface for views. It supports different types of notification.
 */
public interface ViewObserver {
    void ErrorManager(Error message);
    void endTurnHandler(EndTurn message);
    void ConnectionSuccessfulHandler(ConnectionOK message);
    void CompleteQuestionManager(CompletedQuestion message);
    void NumOfPlayerHandler(NPlayerRequest message);
    void errorPlayerManager(ErrorPlayer message);
    void showShelfHandler(ShelfResponse message);
    void showBoardHandler(BoardResponse message);
    void GameStartedHandler(GameStart message);
    void TurnAlert(TurnAlert message);
    void winHandler(Win message);
    void GameEndedHandler(EndGame message);
    void chooseItemPosition(Item1PositionRequest message);
    void chooseOtherItemPosition(Item2PositionRequest message);
    void chooseOtherItemPosition(Item3PositionRequest message);
    void chooseItem(ChoosePositionRequest message);
    void chooseOrderItemOK(ChooseOrder_OK message);
    void addItemInShelf(AddItemInShelf_OK message);
    void chooseItemOk(ChooseItem_OK message);
    void chooseOrderItem(ItemOrderRequest message);
    void chooseColumn(ColumnRequest message);
    void nicknameHandler(LoginRequest message);
    void chat(Chat message);
    void newGame();
}
