package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Model.Shelf;
import it.polimi.ingsw.Observer.InputObservable;
import javafx.scene.layout.GridPane;

public class ChatScene  extends InputObservable implements GenericScene {

    private GridPane gridPane;

    public GridPane start() {
        gridPane = new GridPane();
        return gridPane;
    }

}
