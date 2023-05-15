package it.polimi.ingsw.View;

import it.polimi.ingsw.Message.Action.AddItemInShelf_OK;
import it.polimi.ingsw.Message.Action.ChooseItem_OK;
import it.polimi.ingsw.Message.Action.ChooseOrder_OK;
import it.polimi.ingsw.Message.GameState.*;
import it.polimi.ingsw.Message.Request.ChoosePositionRequest;
import it.polimi.ingsw.Message.Request.ItemOrderRequest;
import it.polimi.ingsw.Message.Request.NItemRequest;
import it.polimi.ingsw.Message.Request.NPlayerRequest;
import it.polimi.ingsw.Message.Response.BoardResponse;
import it.polimi.ingsw.Message.Response.ShelfResponse;
import it.polimi.ingsw.Message.TurnAlert;
import it.polimi.ingsw.Message.Error.Error;
import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.Goal.CommonGoal.*;
import it.polimi.ingsw.Model.Goal.PersonalGoal.*;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.*;

import java.util.ArrayList;

public class Gui extends ViewObservable implements View {
    @Override
    public void askNickname() {

    }

    @Override
    public void askNPlayers() {

    }

    @Override
    public void askItem(Position p1,Position p2) {

    }

    @Override
    public void askOther(ChoosePositionRequest message) {

    }

    @Override
    public void askColumn() {

    }

    @Override
    public void askOrder(ArrayList<Item> itemToOrder) {

    }

    @Override
    public void showBoard(Board board) {

    }

    @Override
    public void showShelf(Shelf shelf) {

    }

    @Override
    public void showItemToOrder(ArrayList<Item> itemToOrder) {

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

    /*@Override
    public void showLoginResult(boolean nicknameAccepted, boolean connectionSuccessful, String nickname) {

    }*/

    @Override
    public void showErrorAndExit(String error) {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showMessage(String message) {

    }
}
