package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Model.Bag.ColorItem;
import it.polimi.ingsw.Model.Game.Board;
import it.polimi.ingsw.Model.Position;
import it.polimi.ingsw.Observer.InputObservable;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.util.*;

public class BoardScene extends InputObservable implements GenericScene {
    private GridPane gridPane;
    private AnchorPane sfondo;
    private Board board;

    public /*GridPane*/ void start(Stage primaryStage, Board board, ArrayList<Position> availablePositions) {
        this.board = board;
        gridPane = new GridPane();
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        gridPane.setHgap(1);
        gridPane.setVgap(1);
        gridPane.setPadding(new Insets(10));
        boolean ok;

        for (int row = 0; row < board.getRow(); row++) {
            for (int col = 0; col < board.getCol(); col++) {
                ok = false;
                if(board.getMyBoardItem()[row][col]!=null) {
                    if(!board.getMyBoardItem()[row][col].getColor().equals(ColorItem.X)){
                        Button button = new Button();
                        button.setGraphic(createRandomImageView(row,col));
                        button.setAccessibleText(row+"-"+col);
                        button.setMaxSize(20,20);
                        for(int i = 0; i<availablePositions.size() && !ok; i++){
                            Position p = availablePositions.get(i);
                            if(p.getRow()==row && p.getCol() == col){
                                button.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onClickItem);
                                button.setStyle("-fx-effect: dropshadow(gaussian, #000000, 20, 0.3, 0, 0);"+"\n" +
                                        "    -fx-background-size: stretch;");
                                ok = true;
                            }
                        }
                        gridPane.add(button, col, row);
                    }
                    /*else{
                        gridPane.add(, col, row);
                    }*/

                }
            }
        }
        String url = "file:src/main/resources/images/board.png";
        gridPane.setStyle("-fx-background-image: url('" + url + "'); " +"-fx-background-repeat: no-repeat;" +
                "-fx-background-size: 525 525;");
        sfondo = new AnchorPane(gridPane);
        AnchorPane.setTopAnchor(gridPane,25.0);
        AnchorPane.setLeftAnchor(gridPane,25.0);
        AnchorPane.setBottomAnchor(gridPane,25.0);
        AnchorPane.setRightAnchor(gridPane,25.0);
        Scene scene = new Scene(sfondo);
        primaryStage.setScene(scene);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.setTitle("board");
        primaryStage.show();
    }

    private ImageView createRandomImageView(int row, int col) {
        String imagePath=null;
        ImageView imageView = new ImageView();
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(true);
        switch (board.getMyBoardItem()[row][col].getColor()) {
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

        return imageView;
    }

    private void onClickItem(MouseEvent event){
        int row = Integer.parseInt(((Button)event.getSource()).getAccessibleText().split("-")[0]);
        int col = Integer.parseInt(((Button)event.getSource()).getAccessibleText().split("-")[1]);
        System.out.println("Click on "+row+"-"+col);
        Position p = new Position(row,col);
        //notifyInObserver(obs->obs.onUpdateChooseItem(new Item1PositionResponse(p)));

    }

    public static void showAvailable(Position p1, Position p2, ArrayList<Position> availablePositions){
    }

    @FXML
    public void initialize(){
        //System.out.println("Size children: "+gridPane.getChildren());
        /*for(Node n : gridPane.getChildren())
            n.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onClickItem);*/
    }
}
