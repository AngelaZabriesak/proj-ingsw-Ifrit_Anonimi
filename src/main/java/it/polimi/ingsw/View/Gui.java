package it.polimi.ingsw.View;

import it.polimi.ingsw.Message.Request.ChoosePositionRequest;
import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Game.Board;
import it.polimi.ingsw.Model.Goal.CommonGoal.Cgoal;
import it.polimi.ingsw.Model.Goal.PersonalGoal.Pgoal;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Position;
import it.polimi.ingsw.Model.Shelf;
import it.polimi.ingsw.Observer.InputObservable;
import it.polimi.ingsw.View.Scene.ChangeScene;
import it.polimi.ingsw.View.Scene.SelectNpScene;
import javafx.application.Platform;

import java.util.ArrayList;

public class Gui extends InputObservable implements View {
    @Override
    public void askNickname() {
        Platform.runLater(() -> ChangeScene.changeRootPane(observers, "login_scene.fxml"));
    }

    @Override
    public void askNPlayers() {
        SelectNpScene npsc = new SelectNpScene();
        npsc.addAllObservers(observers);
        Platform.runLater(() -> ChangeScene.changeRootPane(npsc, "select_np_scene.fxml"));
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
