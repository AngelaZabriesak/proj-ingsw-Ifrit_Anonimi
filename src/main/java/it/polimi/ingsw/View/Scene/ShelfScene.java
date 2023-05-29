package it.polimi.ingsw.View.Scene;


import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Game.Game;
import it.polimi.ingsw.Model.Shelf;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Observer.InputObservable;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;


public class ShelfScene extends InputObservable implements GenericScene {
    private GridPane pickedItem;
    private TextField orderItem;
    private GridPane shelfGrid;  //
    private Shelf shelf;
    private Game game;
    private Player player;
    private static Stage stageInstance;
    private AnchorPane immShelf;
    private Button okItem;
   // private AnchorPane chosenItemShelf;


    public void start(Stage primaryStage, Shelf shelf,Player player) {
        this.stageInstance = primaryStage;
        this.shelf = shelf;
        orderItem = new TextField();
        this.player=player;
        String urlS= "file:src/main/resources/images/ShelfScene.png";



        okItem = new Button();
        String urlBtn = "file:src/main/resources/images/buttons/ok_button.png";
        okItem.setStyle("-fx-background-image: url('"+urlBtn+"');"+"\n" +
                "-fx-background-size: stretch;" +
                "-fx-border-color: transparent;" +
                "-fx-background-color: transparent;");
        okItem.setPrefSize(50,50);
        immShelf = new AnchorPane();
        AnchorPane.setTopAnchor(immShelf,25.0);
        AnchorPane.setLeftAnchor(immShelf,25.0);


        okItem.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onClickOk);

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
                    button.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onClickColumn);
                    shelfGrid.add(button, col, 0);
                } /*else {            //da riga 97 a 110 quella giusta, ma si blocca
                    Button emptyButton = new Button();
                    emptyButton.setPrefSize(50.9,50.9);
                    emptyButton.setStyle("-fx-background-color: transparent;");

                    shelfGrid.add(emptyButton, col, row + 1);*/
                else {
                        if(shelf.getMyShelf()[row][col]!= null){
                            ImageView  shelfItem = new ImageView(getImgUrl(shelf.getMyShelf()[row][col]));
                            shelfItem.setFitHeight(50.9);
                            shelfItem.setFitWidth(50.9);
                            shelfGrid.add(shelfItem, col, row + 1);
                        }
                        else {
                            ImageView emptySpace = new ImageView();
                            emptySpace.setFitHeight(50.9);
                            emptySpace.setFitWidth(50.9);
                            emptySpace.setStyle("-fx-background-color: transparent;");
                            shelfGrid.add(emptySpace, col, row + 1);
                        }
                }
            }
        }

        //immShelf.getChildren().add(shelfGrid);


        pickedItem = new GridPane();
        pickedItem.setPrefSize(100, 300);
        pickedItem.setVgap(13);
        AnchorPane.setTopAnchor(pickedItem,151.5);
        AnchorPane.setLeftAnchor(pickedItem,487.0);


        //add picked items to the gridpane
        //setPickedItem(player.getMyItem());

        int nItems = player.getMyItem().size();
        for (int r = 0; r < nItems; r++) {
            ImageView image = new ImageView(getImgUrl(player.getMyItem().get(r)));
            image.setFitHeight(83);
            image.setFitWidth(81);
            pickedItem.add(image,0,r);
        }

        immShelf.getChildren().addAll(shelfGrid,pickedItem,orderItem,okItem);

        AnchorPane.setTopAnchor(shelfGrid, 30.7);
        AnchorPane.setLeftAnchor(shelfGrid, 62.25);

        AnchorPane.setBottomAnchor(pickedItem, 300.0);
        AnchorPane.setRightAnchor(pickedItem, 300.0);
        AnchorPane.setTopAnchor(okItem,560.0);
        AnchorPane.setLeftAnchor(okItem,560.0);


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
        notifyInObserver(obs->obs.onUpdateColumn(""+col));
        //setPickedItem(player.getMyItem());
    }

    private void setPickedItem(ArrayList<Item> items){
        int nItems = items.size();
        for (int r = 0; r < nItems; r++) {

            /*ImageView image = new ImageView(getImgUrl(r));
            image.setFitHeight(83);
            image.setFitWidth(81);
            pickedItem.add(image,0,r);*/
        }

        immShelf.getChildren().addAll(pickedItem,orderItem,okItem);
    }

    public static Stage getStageInstance() {
        if (stageInstance == null)
            stageInstance = new Stage();
        return stageInstance;
    }

    private String getImgUrl(Item item) {
        String imagePath = "";

        //switch (player.getMyItem().get(r).getColor()) {
        switch(item.getColor()){
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
        return imagePath;

    }


    @FXML
    public void initialize() {
        System.out.println("Size children: "+shelfGrid.getChildren().size());
    }

    private void onClickOk(MouseEvent event){
        String order = orderItem.getText();
        ArrayList<Integer> orderedItem = new ArrayList<>();
        String[] splittedOrder = order.split("-");
        //System.out.println(splittedOrder.toString());
        for(int i = 0;i<splittedOrder.length;i++){
            orderedItem.add(Integer.parseInt(splittedOrder[i]));
        }
        notifyInObserver(obs->obs.onUpdateOrder(orderedItem,player.getMyItem()));
    }

}