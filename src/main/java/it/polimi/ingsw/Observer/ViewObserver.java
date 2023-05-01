package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Message.GameState.*;
import it.polimi.ingsw.Message.Request.NPlayerRequest;
import it.polimi.ingsw.Message.Response.BoardResponse;
import it.polimi.ingsw.Message.Response.ShelfResponse;
import it.polimi.ingsw.Message.TurnAlert;
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
    void showShelfHandler(ShelfResponse message);
    void showBoardHandler(BoardResponse message);
    void GameStartedHandler(GameStart message);
    void TurnAlert(TurnAlert message);
    void winHandler(Win message);
    void GameEndedHandler(EndGame message);
}
