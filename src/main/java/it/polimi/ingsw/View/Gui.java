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
import it.polimi.ingsw.View.Scene.GameScene;
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
        Platform.runLater(() -> ChangeScene.changeRootPane(observers, "game_scene.fxml"));
    }

    @Override
    public void askOther(ChoosePositionRequest message) {
        Platform.runLater(() -> ChangeScene.changeRootPane(observers, "game_scene.fxml"));
    }

    @Override
    public void askColumn() {
        Platform.runLater(() -> ChangeScene.changeRootPane(observers, "game_scene.fxml"));
    }

    @Override
    public void askOrder(ArrayList<Item> itemToOrder) {
        Platform.runLater(() -> ChangeScene.changeRootPane(observers, "game_scene.fxml"));
    }

    @Override
    public void showBoard(Board board) {
      //  Platform.runLater(() -> GameScene.setBoardGrid(board));
        Platform.runLater(() -> ChangeScene.changeRootPane(observers, "game_scene.fxml"));
    }

    @Override
    public void showShelf(Shelf shelf) {
        Platform.runLater(() -> ChangeScene.changeRootPane(observers, "game_scene.fxml"));
    }

    @Override
    public void showItemToOrder(ArrayList<Item> itemToOrder) {
        Platform.runLater(() -> ChangeScene.changeRootPane(observers, "game_scene.fxml"));
    }

    @Override
    public void showScore(Player player) {
        Platform.runLater(() -> ChangeScene.changeRootPane(observers, "game_scene.fxml"));
    }

    @Override
    public void showCGoal(ArrayList<Cgoal> cgoal) {
       /*GameScene gamescene= new GameScene();
       gamescene.addAllObservers(observers);
       Platform.runLater(()->GameScene.setGuiCGoals(goals));*/
    }

    @Override
    public void showPGoal(Pgoal pgoal) {
        Platform.runLater(() -> ChangeScene.changeRootPane(observers, "game_scene.fxml"));
    }

    @Override
    public void showError(String error) {
        Platform.runLater(() -> ChangeScene.showAlert(error));
    }

    @Override
    public void showMessage(String message) {
        Platform.runLater(() -> ChangeScene.showAlert(message));
    }

    @Override
    public void showWait(int nPlayers) {
        Platform.runLater(() -> ChangeScene.changeRootPane(observers, "wait_scene.fxml"));
        Platform.runLater(() -> ChangeScene.showAlert("Waiting others "+nPlayers+" players!"));
    }

    @Override
    public void askEnd() {

    }

    @Override
    public void exit() {

    }
}
