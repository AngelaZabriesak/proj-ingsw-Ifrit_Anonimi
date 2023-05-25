package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Observer.InputObservable;
import it.polimi.ingsw.Observer.InputObserver;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;


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

}
