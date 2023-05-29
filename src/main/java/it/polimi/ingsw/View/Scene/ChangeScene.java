package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Model.Game.Board;
import it.polimi.ingsw.Model.Goal.CommonGoal.Cgoal;
import it.polimi.ingsw.Model.Goal.PersonalGoal.Pgoal;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Position;
import it.polimi.ingsw.Model.Shelf;
import it.polimi.ingsw.Observer.InputObservable;
import it.polimi.ingsw.Observer.InputObserver;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ChangeScene extends InputObservable {

    private static Scene activeScene;
    private static GenericScene activeController;

  //

    public static Scene getActiveScene() {
        return activeScene;
    }

 //

    public static GenericScene getActiveController() {
        return activeController;
    }


    public static <T> T changeRootPane(List<InputObserver> observerList, Scene scene, String fxml) {
        T controller = null;

        try {
            FXMLLoader loader = new FXMLLoader(ChangeScene.class.getResource("/fxml/" + fxml));
            Parent root = loader.load();
            controller = loader.getController();
            ((InputObservable) controller).addAllObservers(observerList);

            activeController = (GenericScene) controller;
            activeScene = scene;
            activeScene.setRoot(root);
        } catch (IOException e) {
            System.out.println(e);
        }
        return controller;
    }

    //

    public static <T> T changeRootPane(List<InputObserver> observerList, Event event, String fxml) {
        Scene scene = ((Node) event.getSource()).getScene();
        return changeRootPane(observerList, scene, fxml);
    }

    //

    public static <T> T changeRootPane(List<InputObserver> observerList, String fxml) {
        return changeRootPane(observerList, activeScene, fxml);
    }


    //

    public static void changeRootPane(GenericScene controller, Scene scene, String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(ChangeScene.class.getResource("/fxml/" + fxml));

            // Setting the controller BEFORE the load() method.

            loader.setController(controller);
            activeController = controller;
            Parent root = loader.load();

            activeScene = scene;
            activeScene.setRoot(root);
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public static void changeRootPane(GenericScene controller, Event event, String fxml) {
        Scene scene = ((Node) event.getSource()).getScene();
        changeRootPane(controller, scene, fxml);
    }


    public static void changeRootPane(GenericScene controller, String fxml) {
        changeRootPane(controller, activeScene, fxml);
    }
    public static void showAlert(String message) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ChangeScene.class.getResource("/fxml/message_scene.fxml"));
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            System.out.println(e);
        }
        MessageScene errorSceneController = loader.getController();
        javafx.scene.Scene alertScene = new javafx.scene.Scene(parent);
        errorSceneController.setScene(alertScene);
        errorSceneController.setAlertMessage(message);
        errorSceneController.displayAlert();
    }

    public static void showTable(Board board, Shelf shelf, ArrayList<Position> availablePositions, ArrayList<Cgoal> cgoal, Pgoal pgoal){
        new TableScene(new Stage(),board,shelf,availablePositions,cgoal,pgoal);
    }

    public static void showBoard(BoardScene bs,Board board, ArrayList<Position> availablePositions,Position p1, Position p2){
        bs.start(BoardScene.getStageInstance(),board,availablePositions,p1,p2);
    }

    public static void showShelf(ShelfScene ss, Shelf shelf, Player player){
        ss.start(ShelfScene.getStageInstance(),shelf,player);
    }

    public static void showPgoal(GoalScene gs,Pgoal pgoal){
        gs.start(null,GoalScene.getStagePInstance(),null,pgoal);
    }
    public static void showCgoal(GoalScene gs,ArrayList<Cgoal> cgoals){
        gs.start(GoalScene.getStageCInstance(),null,cgoals,null);
    }
    public static void updateBoard(BoardScene bs,Board board, Position p1, Position p2,ArrayList<Position> availablePositions){
        bs.updateBoard(BoardScene.getStageInstance(),board,availablePositions,p1,p2);
    }

    public static void showChat(ChatScene cs,Player player){
        cs.start(ChatScene.getStageInstance());
    }

    public static void chat(ChatScene cs,String message){
        cs.update(message);
    }

}
