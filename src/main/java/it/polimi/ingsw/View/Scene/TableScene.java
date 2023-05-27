package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Model.Game.Board;
import it.polimi.ingsw.Model.Goal.CommonGoal.Cgoal;
import it.polimi.ingsw.Model.Goal.PersonalGoal.Pgoal;
import it.polimi.ingsw.Model.Position;
import it.polimi.ingsw.Model.Shelf;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.util.ArrayList;

public class TableScene {

    public TableScene(Stage primaryStage, Board board, Shelf shelf, ArrayList<Position> availablePositions, ArrayList<Cgoal> cgoal, Pgoal pgoal) {
        GridPane gridPane = new GridPane();

        // Crea il primo layout e la prima scena
        BoardScene bs = new BoardScene();
        //GridPane boardScene = bs.start(board,availablePositions);
        // Creazione dell'immagine di sfondo
        String urlBoard = "file:src/main/resources/images/board.png";
       // boardScene.setStyle("-fx-background-image: url('" + urlBoard + "'); " +
              //  "-fx-background-size: 40% 60%;"+"-fx-background-repeat: no-repeat;");

        // Crea il secondo layout e la seconda scena
        GoalScene gs = new GoalScene();
        //GridPane goalScene = gs.start(cgoal,pgoal);
        // Creazione dell'immagine di sfondo
        String urlGoal = "file:src/main/resources/images/parquet_background.jpg";
       /* goalScene.setStyle("-fx-background-image: url('" + urlGoal + "'); " +
                "-fx-background-size: 40% 40%;"+"-fx-background-repeat: no-repeat;");

        ShelfScene ss = new ShelfScene();
        GridPane shelfScene = ss.start(shelf);
        // Creazione dell'immagine di sfondo
        String urlShelf = "file:src/main/resources/images/shelf.png";
        shelfScene.setStyle("-fx-background-image: url('" + urlShelf + "'); " +
        "-fx-background-size: 40% 40%;"+"-fx-background-repeat: no-repeat;");

        ChatScene cs = new ChatScene();
        GridPane chatScene = cs.start();
        String urlChat = "file:src/main/resources/images/parquet_background.jpg";
        chatScene.setStyle("-fx-background-image: url('" + urlChat + "'); " +
                "-fx-background-size: 40% 40%;"+"-fx-background-repeat: no-repeat;");


        // Aggiungi le scene allo StackPane (....,c.r)
        gridPane.add(goalScene,0,1);
        gridPane.add(boardScene,0,0);
        gridPane.add(shelfScene,1,0);
        gridPane.add(chatScene,1,1);
        gridPane.setGridLinesVisible(true);

        // Mostra lo Stage con lo StackPane
        primaryStage.setScene(new Scene(gridPane, 800, 600));
        primaryStage.show();*/
    }
}
