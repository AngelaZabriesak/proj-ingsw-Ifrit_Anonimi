package it.polimi.ingsw.View;

import it.polimi.ingsw.Message.Request.*;
import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.Goal.CommonGoal.*;
import it.polimi.ingsw.Model.Goal.PersonalGoal.*;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.*;

import java.util.*;

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

    @Override
    public void showError(String error) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void askEnd() {

    }

    @Override
    public void exit() {

    }
}
