package it.polimi.ingsw.View.Scene;


import it.polimi.ingsw.Model.Game.Game;
import it.polimi.ingsw.Model.Shelf;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Observer.InputObservable;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
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
    private StackPane arrows;
    private GridPane gridPane;
    private Shelf shelf;
    private Game game;
    private Player player;
    private static Stage stageInstance;
    private AnchorPane immShelf;

    public void start(Stage primaryStage, Shelf shelf) {
        this.stageInstance = primaryStage;
        this.shelf = shelf;




        immShelf = new AnchorPane();
        String urlS = "file:src/main/resources/images/shelf.png";
        immShelf.setStyle("-fx-background-image: url('" + urlS + "'); " +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-size: 500 500;");
        immShelf.setPrefSize(600, 500);

        gridPane = new GridPane();
        gridPane.setPrefSize(600, 500);
        primaryStage.setWidth(600);
        primaryStage.setHeight(500);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(10));

        tableShelf = new GridPane();
        tableShelf.setPrefSize(600, 500);

        for (int row = -1; row < shelf.getRow(); row++) {
            for (int col = 0; col < shelf.getCol(); col++) {
                if (row == -1) {
                    Button button = new Button();
                    button.setPrefSize(20, 20);
                    button.setAccessibleText("" + col);
                    button.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onClickColumn);
                    String url = "file:src/main/resources/images/buttons/arrow_column_button_img.png";
                    button.setStyle("-fx-background-size: 100% 100%;" +
                            "-fx-background-repeat: no-repeat;" +
                            "-fx-background-image: url('" + url + "');");
                    gridPane.add(button, col, 0);
                } else {
                    ImageView iw = new ImageView(new Image("file:src/main/resources/images/parquet_background.jpg"));
                    iw.setFitWidth(40);
                    iw.setFitHeight(40);
                    gridPane.add(iw, col, row + 1);
                }
            }
        }

        arrows = new StackPane();
        arrows.setPrefSize(100, 300);

        // Aggiunge gli elementi dello StackPane
        int pos=  3;  //player.getMyItem().size();

        {

            for (int i = 0; i < pos; i++) {

                Button button = new Button();
                arrows.getChildren().add(button);
                button.setGraphic(createRandomImageView(i));
            }
        }



        AnchorPane.setTopAnchor(gridPane, 25.0);
        AnchorPane.setLeftAnchor(gridPane, 25.0);
        AnchorPane.setBottomAnchor(arrows, 25.0);
        AnchorPane.setRightAnchor(arrows, 25.0);

        Scene scene = new Scene(immShelf);
        primaryStage.setScene(scene);
        primaryStage.setTitle("shelf");
        primaryStage.setX(600);
        primaryStage.setY(0);
        primaryStage.show();
    }

    private void onClickColumn(MouseEvent event) {
        int col = Integer.parseInt(((Button) event.getSource()).getAccessibleText().split("-")[0]);
        System.out.println("Click on column " + col);
    }

    public static Stage getStageInstance() {
        if (stageInstance == null)
            stageInstance = new Stage();
        return stageInstance;
    }

    private ImageView createRandomImageView(int pos) {
        String imagePath=null;

        ImageView imageView = new ImageView("file:src/main/resources/images/items/blueitem1.png");
        imageView.setFitWidth(40);
        imageView.setFitHeight(55);
        imageView.setPreserveRatio(true);

      /*  this.player= game.getCurrentPlayer();

        switch (player.getMyItem().get(pos).getColor()) {
            case BLUE:
                imagePath = "file:src/main/resources/images/items/blueitem1.png";
                break;
            case PINK:
                imagePath = "file:src/main/resources/images/items/pinkitem1.png";
                break;
            case AZURE:
                imagePath = "file:src/main/resources/images/items/azureitem1.png";
                break;
            case WHITE:
                imagePath = "file:src/main/resources/images/items/whiteitem1.png";
                break;
            case GREEN:
                imagePath = "file:src/main/resources/images/items/greenitem1.png";
                break;
            case YELLOW:
                imagePath = "file:src/main/resources/images/items/yellowitem1.png";
                break;
        }

        Image image = new Image(imagePath);
        imageView.setImage(image);

       */

        return imageView;
    }

    @FXML
    public void initialize() {
    }
}















































































































/*public class ShelfScene extends InputObservable implements GenericScene {
    private GridPane tableShelf;
    private StackPane arrows;
    private GridPane gridPane;
    private Shelf shelf;
    private static Stage stageInstance;
    private AnchorPane immShelf;

    public /*GridPane void start(Stage primaryStage, Shelf shelf) {
        this.stageInstance = primaryStage;
        this.shelf = shelf;

        immShelf= new AnchorPane();
        String urlS = "file:src/main/resources/images/shelf.png";
        immShelf.setStyle("-fx-background-image: url('" + urlS+ "'); " +"-fx-background-repeat: no-repeat;"+
        "-fx-background-size: 500 500;");
        immShelf.setPrefSize(600,500);

        gridPane = new GridPane();
        gridPane.setPrefSize(600, 500);
        primaryStage.setWidth(600);
        primaryStage.setHeight(500);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(10));

        tableShelf = new GridPane();
        tableShelf.setPrefSize(600, 500);



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



        Scene scene =new Scene(immShelf);
        tableShelf.add(scene.getRoot(),0,0);
        ImageView orderView = new ImageView(new Image("file:src/main/resources/images/minishelf_pickeditems.png"));
        //Scene order = new Scene(orderView.getParent());
        tableShelf.add(orderView,1,0);
        arrows = new StackPane(tableShelf);
        arrows.setPrefSize(500, 400);
        immShelf= new AnchorPane(tableShelf,arrows);
        AnchorPane.setTopAnchor(gridPane, 25.0);
        AnchorPane.setLeftAnchor(gridPane, 25.0);
        AnchorPane.setBottomAnchor(orderView, 25.0);
        AnchorPane.setRightAnchor(orderView, 25.0);
        // Scene sceneFinale = new Scene(arrows);
        // primaryStage.setScene(sceneFinale);
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

public static Stage getStageInstance(){
        if(stageInstance == null)
        stageInstance = new Stage();
        return stageInstance;
        }

@FXML
public void initialize(){
        }
        }
*/