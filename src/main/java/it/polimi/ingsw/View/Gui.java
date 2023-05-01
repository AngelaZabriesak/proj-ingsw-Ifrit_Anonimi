package it.polimi.ingsw.View;

import it.polimi.ingsw.Message.GameState.*;
import it.polimi.ingsw.Message.Request.NPlayerRequest;
import it.polimi.ingsw.Message.Response.BoardResponse;
import it.polimi.ingsw.Message.Response.ShelfResponse;
import it.polimi.ingsw.Message.TurnAlert;
import it.polimi.ingsw.Message.Error.Error;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.Goal.CommonGoal.*;
import it.polimi.ingsw.Model.Goal.PersonalGoal.*;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.*;

import java.util.ArrayList;

public class Gui extends ViewObservable implements View, ViewObserver {
    @Override
    public void askNickname() {

    }

    @Override
    public void askNPlayers() {

    }

    @Override
    public void askItem() {

    }

    @Override
    public void askColumn() {

    }

    @Override
    public void askOrder() {

    }

    @Override
    public void showBoard(Board board) {

    }

    @Override
    public void showShelf(Shelf shelf) {

    }

    @Override
    public void showScore(Player player) {

    }

    @Override
    public void showCGoal(ArrayList<Cgoal> cgoal) {

    }

    @Override
    public void showPGoal(Pgoal pgoal) {

    }

    @Override
    public void showLoginResult(boolean nicknameAccepted, boolean connectionSuccessful, String nickname) {

    }

    @Override
    public void showErrorAndExit(String error) {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void ErrorManager(Error message) {

    }

    @Override
    public void endTurnHandler(EndTurn message) {

    }

    @Override
    public void ConnectionSuccessfulHandler(ConnectionOK message) {

    }

    @Override
    public void CompleteQuestionManager(CompletedQuestion message) {

    }

    @Override
    public void NumOfPlayerHandler(NPlayerRequest message) {

    }

    @Override
    public void showShelfHandler(ShelfResponse message) {

    }

    @Override
    public void showBoardHandler(BoardResponse message) {

    }

    @Override
    public void GameStartedHandler(GameStart message) {

    }

    @Override
    public void TurnAlert(TurnAlert message) {

    }

    @Override
    public void winHandler(Win message) {

    }

    @Override
    public void GameEndedHandler(EndGame message) {

    }
}
