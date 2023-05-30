package it.polimi.ingsw.View;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.Message.ViewMessageManager;
import it.polimi.ingsw.Networking.Client.ObsClient;
import it.polimi.ingsw.View.Scene.MenuScene;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiJavaFX extends Application {

    @Override
    public void start(Stage stage) {
        ViewMessageManager viewMessageManager=new ViewMessageManager();
        ClientController clientcontroller = new ClientController(viewMessageManager,new ObsClient(viewMessageManager));
        Gui view = new Gui(stage);
        VirtualView vView = new VirtualView(view);
        view.addObserver(clientcontroller);
        viewMessageManager.addObserver(vView);

        // Load root layout from fxml file.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/menu_scene.fxml"));
        Parent rootLayout = null;
        try {
            rootLayout = loader.load();
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
        MenuScene controller = loader.getController();
        controller.addObserver(clientcontroller);

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setMaximized(false);
        stage.setFullScreen(false);
        stage.setFullScreenExitHint("");
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setTitle("myShelfie");
        stage.show();
}

    @Override
    public void stop() {
        Platform.exit();
        System.exit(0);
    }
}
