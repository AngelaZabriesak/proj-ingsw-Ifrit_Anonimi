package it.polimi.ingsw.View;

import it.polimi.ingsw.Controller.*;
import it.polimi.ingsw.Message.*;
import it.polimi.ingsw.Networking.Client.*;
import it.polimi.ingsw.View.Scene.MenuScene;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.input.KeyCombination;
import javafx.stage.*;

import java.io.*;
import java.util.Objects;

public class GuiJavaFX extends Application {

    @Override
    public void start(Stage stage) {
        ViewMessageManager viewMessageManager=new ViewMessageManager();
        ClientController clientcontroller = new ClientController(viewMessageManager,new ObsClient(viewMessageManager));
        Gui view = new Gui();
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
        stage.setWidth(1000d);
        stage.setHeight(650d);
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
