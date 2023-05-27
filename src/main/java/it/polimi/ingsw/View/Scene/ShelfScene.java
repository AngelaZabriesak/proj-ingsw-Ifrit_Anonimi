package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Message.Response.Item1PositionResponse;
import it.polimi.ingsw.Model.Bag.ColorItem;
import it.polimi.ingsw.Model.Game.Board;
import it.polimi.ingsw.Model.Goal.PersonalGoal.Pgoal;
import it.polimi.ingsw.Model.Position;
import it.polimi.ingsw.Model.Shelf;
import it.polimi.ingsw.Observer.InputObservable;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ShelfScene extends InputObservable implements GenericScene {
    private GridPane tableShelf;
    private StackPane sfondo;
    private GridPane gridPane;
    private Shelf shelf;

    public /*GridPane*/ void start(Stage primaryStage, Shelf shelf) {
        this.shelf = shelf;
        gridPane = new GridPane();
        tableShelf = new GridPane();
        primaryStage.setWidth(600);
        primaryStage.setHeight(500);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(10));

        for (int row = -1; row < shelf.getRow(); row++) {
            for (int col = 0; col < shelf.getCol(); col++) {
                if (row == -1) {
                    Button button = new Button();
                    button.setPrefSize(20, 20);
                    button.setAccessibleText(""+col);
                    button.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onClickColumn);
                    String url = "file:src/main/resources/images/buttons/arrow_column_button_img.png";
                    button.setStyle("-fx-background-size: 100% 100%;" + "-fx-background-repeat: no-repeat;"+"-fx-background-image: url('" + url + "');" );
                    gridPane.add(button, col, 0);
                } else {
                    ImageView iw = new ImageView(new Image("file:src/main/resources/images/parquet_background.jpg"));
                    iw.setFitWidth(40);
                    iw.setFitHeight(40);
                    gridPane.add(iw, col, row + 1);
                }
            }
        }

        String url = "file:src/main/resources/images/shelf.png";
        gridPane.setStyle("-fx-background-image: url('" + url + "'); " +"-fx-background-repeat: no-repeat;"+
                "-fx-background-size: 500 500;");
        Scene scene = new Scene(gridPane);
        tableShelf.add(scene.getRoot(),0,0);
        ImageView orderView = new ImageView(new Image("file:src/main/resources/images/minishelf_pickeditems.png"));
        //Scene order = new Scene(orderView.getParent());
        tableShelf.add(orderView,1,0);
        sfondo = new StackPane(tableShelf);
        AnchorPane.setTopAnchor(gridPane, 20.0);
        AnchorPane.setLeftAnchor(gridPane, 20.0);
        AnchorPane.setBottomAnchor(orderView, 20.0);
        AnchorPane.setRightAnchor(orderView, 20.0);
        Scene sceneFinale = new Scene(sfondo);
        primaryStage.setScene(sceneFinale);
        primaryStage.setTitle("shelf");
        primaryStage.setX(600);
        primaryStage.setY(0);
        primaryStage.show();
        //return tableShelf;

    }

    private void onClickColumn(MouseEvent event){
        int col = Integer.parseInt(((Button)event.getSource()).getAccessibleText().split("-")[0]);
        System.out.println("Click on column "+col);
    }

    @FXML
    public void initialize(){
    }
}
