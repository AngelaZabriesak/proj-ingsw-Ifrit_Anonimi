package it.polimi.ingsw.View.Scene;


import it.polimi.ingsw.Model.Game.Game;
import it.polimi.ingsw.Model.Shelf;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Observer.InputObservable;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;



public class ShelfScene extends InputObservable implements GenericScene {
    private GridPane pickedItem;
    private GridPane shelfGrid;  //
    private Shelf shelf;
    private Game game;
    private Player player;
    private static Stage stageInstance;
    private AnchorPane immShelf;
   // private AnchorPane chosenItemShelf;


    public void start(Stage primaryStage, Shelf shelf,Player player) {
        this.stageInstance = primaryStage;
        this.shelf = shelf;
        this.player=player;
        String urlS= "file:src/main/resources/images/ShelfScene.png";


        immShelf = new AnchorPane();
        AnchorPane.setTopAnchor(immShelf,25.0);
        AnchorPane.setLeftAnchor(immShelf,25.0);



        immShelf.setStyle("-fx-background-image: url('" + urlS + "'); " +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-size: 600 600;");
        immShelf.setPrefSize(600, 600);


        //grid for shelf's items

        shelfGrid = new GridPane();
        primaryStage.setWidth(615);
        primaryStage.setHeight(600);
        shelfGrid.setHgap(21.95);
        shelfGrid.setVgap(10.4);
       // AnchorPane.setTopAnchor(shelfGrid,90.0);
        // AnchorPane.setLeftAnchor(shelfGrid,90.0);
     //   shelfGrid.setPadding(new Insets(10));



        for (int row = -1; row < shelf.getRow(); row++) {
            for (int col = 0; col < shelf.getCol(); col++) {
                if (row == -1) {
                    Button button = new Button();
                    button.setPrefSize(50.9, 50.9);
                    button.setAccessibleText("" + col);
                    button.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onClickColumn);
                    String url = "file:src/main/resources/images/buttons/arrow_column_button_img.png";
                    button.setStyle("-fx-background-size: 80% 70%;" +
                            "-fx-background-repeat: no-repeat;" +
                            "-fx-background-color:transparent;"+
                            "-fx-background-image: url('" + url + "');");
                    shelfGrid.add(button, col, 0);
                } else {
                    Button emptyButton = new Button();
                    emptyButton.setPrefSize(50.9,50.9);
                    emptyButton.setStyle("-fx-background-color: transparent;");

                    shelfGrid.add(emptyButton, col, row + 1);
                }
            }
        }

        immShelf.getChildren().add(shelfGrid);


        pickedItem = new GridPane();
        pickedItem.setPrefSize(100, 300);
        pickedItem.setVgap(13);
        AnchorPane.setTopAnchor(pickedItem,151.5);
        AnchorPane.setLeftAnchor(pickedItem,487.0);

       /* pickedItemShelf.setStyle("-fx-background-image: url('" + urlI + "'); " +
                "-fx-background-repeat: stretch; " +
                "-fx-background-size: cover;");  */

        // Aggiunge gli elementi dello StackPane


        immShelf.getChildren().add(pickedItem);


        AnchorPane.setTopAnchor(shelfGrid, 30.7);
        AnchorPane.setLeftAnchor(shelfGrid, 62.25);
        AnchorPane.setBottomAnchor(pickedItem, 300.0);
        AnchorPane.setRightAnchor(pickedItem, 300.0);

        Scene scene = new Scene(immShelf);

        primaryStage.setScene(scene);
        primaryStage.setTitle("shelf");
        primaryStage.setX(600);
        primaryStage.setY(0);


       // AnchorPane.setTopAnchor(immShelf, (primaryStage.getHeight() - immShelf.getPrefHeight()) / 2);
        //AnchorPane.setLeftAnchor(immShelf, (primaryStage.getWidth() - immShelf.getPrefWidth()) / 2);

        primaryStage.show();
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



        //this.player= game.getCurrentPlayer();

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
        ImageView imageView = new ImageView(imagePath);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(true);
        Image image = new Image(imagePath);
        imageView.setImage(image);



        return imageView;
    }


    @FXML
    public void initialize() {
        System.out.println("Size children: "+shelfGrid.getChildren().size());
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