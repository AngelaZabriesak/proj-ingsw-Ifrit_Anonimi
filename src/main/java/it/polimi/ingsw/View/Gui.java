package it.polimi.ingsw.View;

import it.polimi.ingsw.Message.Request.*;
import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.Goal.CommonGoal.*;
import it.polimi.ingsw.Model.Goal.PersonalGoal.*;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.InputObservable;
import it.polimi.ingsw.View.Scene.SelectNpScene;
import javafx.application.Platform;

import java.util.*;

public class Gui extends InputObservable implements View {
    @Override
    public void askNickname() {
        //Platform.runLater(() -> SceneController.changeRootPane(observers, "login_scene.fxml"));
    }

    @Override
    public void askNPlayers() {
        /*SelectNpScene pnsc = new SelectNpScene();
        pnsc.addAllObservers(observers);
        pnsc.setPlayersRange(2, 3);
        Platform.runLater(() -> SceneController.changeRootPane(pnsc, "select_np_scene.fxml"));*/
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
