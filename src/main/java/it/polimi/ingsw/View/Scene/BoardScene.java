package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Message.Response.ChoosePositionResponse;
import it.polimi.ingsw.Message.Response.Item1PositionResponse;
import it.polimi.ingsw.Message.Response.Item2PositionResponse;
import it.polimi.ingsw.Message.Response.Item3PositionResponse;
import it.polimi.ingsw.Model.Bag.ColorItem;
import it.polimi.ingsw.Model.Game.Board;
import it.polimi.ingsw.Model.Position;
import it.polimi.ingsw.Observer.InputObservable;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.util.*;

public class BoardScene extends InputObservable implements GenericScene {
    private GridPane itemBoardGrid;
    private AnchorPane boardBackground;
    private Board board;
    private ArrayList<Position> availablePositions;
    private Button okItem;
    private Position p1,p2;
    private static Stage stageInstance;

    public /*GridPane*/ void start(Stage primaryStage, Board board, ArrayList<Position> availablePositions, Position p1, Position p2) {



        this.stageInstance = primaryStage;
        this.board=board;
        this.availablePositions = availablePositions;
        okItem = new Button();
        String urlBtn = "file:src/main/resources/images/buttons/ok_button.png";
        okItem.setStyle("-fx-background-image: url('"+urlBtn+"');"+"\n" +
                "-fx-background-size: stretch;" +
                "-fx-border-color: transparent;" +
                "-fx-background-color: transparent;");
        okItem.setPrefSize(50,50);
        this.p1 = p1;
        this.p2 = p2;

        //grid made of buttons representing the items on the board

        itemBoardGrid = new GridPane();
        primaryStage.setWidth(615);
        primaryStage.setHeight(635);
        itemBoardGrid.setHgap(4.5);
        itemBoardGrid.setVgap(4.5);

        okItem = createOkItem();

        //function that dynamically fills the grid

        boolean ok;
        for (int row = 0; row < board.getRow(); row++) {
            for (int col = 0; col < board.getCol(); col++) {
                ok = false;
                if(board.getMyBoardItem()[row][col]!=null) {
                    if(!board.getMyBoardItem()[row][col].getColor().equals(ColorItem.X)){
                        Button button = new Button();
                        button.setGraphic(createRandomImageView(row,col));
                        button.setAccessibleText(row+"-"+col);
                      //  button.setMaxSize(42,122);
                        button.setPrefSize(42,55);
                        for(int i = 0; i<availablePositions.size() && !ok; i++){
                            Position p = availablePositions.get(i);
                            if(p.getRow()==row && p.getCol() == col){
                                button.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onClickItem);
                                button.setStyle("-fx-background-color: blue;"+"\n" +
                                        "    -fx-background-size: stretch;");
                                ok = true;
                            }
                        }
                        itemBoardGrid.add(button, col, row);
                    }
                    else{
                        Button emptyButton = new Button();
                         emptyButton.setPrefSize(42,55);
                         emptyButton.setStyle("-fx-background-color: transparent;"+"\n" +
                                "    -fx-background-size: stretch;");
                         itemBoardGrid.add(emptyButton, col, row);
                    }

                }
            }
        }
        initialize();
        String url = "file:src/main/resources/images/board.png";

        okItem.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onClickOk);

        //set the AnchorPane with the image of the board
        
        boardBackground = new AnchorPane(itemBoardGrid,okItem);
        boardBackground.setPrefSize(600, 600);
        boardBackground.setStyle("-fx-background-image: url('" + url + "'); " +"-fx-background-repeat: no-repeat;" +
                "-fx-background-size: 600 600;");
        AnchorPane.setTopAnchor(itemBoardGrid,32.0);
        AnchorPane.setLeftAnchor(itemBoardGrid,41.0);
        AnchorPane.setBottomAnchor(okItem,35.0);
        AnchorPane.setLeftAnchor(okItem,45.0);

        Scene scene = new Scene(boardBackground);
        primaryStage.setScene(scene);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.setTitle("board");
        primaryStage.show();
    }

    public static Stage getStageInstance(){
        if(stageInstance == null)
            stageInstance = new Stage();
            //stageInstance.initStyle(StageStyle.TRANSPARENT);
        return stageInstance;
    }

    private Button createOkItem() {
        Button okItem = new Button();
        String urlBtn = "file:src/main/resources/images/buttons/ok_button.png";
        okItem.setStyle("-fx-background-image: url('"+urlBtn+"');"+"\n" +
                        "-fx-background-size: 100% 100%;"+
                "-fx-border-color: transparent;" +
                "-fx-background-color: transparent;");
        okItem.setPrefSize(50,50);
       AnchorPane.setBottomAnchor(okItem,20.0);
       AnchorPane.setLeftAnchor(okItem,45.0);

        return okItem;
    }


    //function that returns the imageview based on the color of the item

    private ImageView createRandomImageView(int row, int col) {
        String imagePath=null;
        ImageView imageView = new ImageView();
        imageView.setFitWidth(40);
        imageView.setFitHeight(55);
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

    //function that implements the click action on the items

    private void onClickItem(MouseEvent event){
        int row = Integer.parseInt(((Button)event.getSource()).getAccessibleText().split("-")[0]);
        int col = Integer.parseInt(((Button)event.getSource()).getAccessibleText().split("-")[1]);
        System.out.println("Click on "+row+"-"+col);
        okItem = createOkItem();
        Position p = new Position(row,col);
        if(p1==null)
            notifyInObserver(obs -> obs.onUpdateChooseItem(new Item1PositionResponse(p)));
        else if (p2==null)
            notifyInObserver(obs -> obs.onUpdateChooseItem(new Item2PositionResponse(p1,p)));
        else
            notifyInObserver(obs -> obs.onUpdateChooseItem(new Item3PositionResponse(p1,p2,p)));

    }

    private void onClickOk(MouseEvent event){
        notifyInObserver(obs->obs.onUpdateChoose(new ChoosePositionResponse("no",p1,p2)));
    }


    @FXML
    public void initialize(){
        System.out.println("Size children: "+itemBoardGrid.getChildren().size());
    }

    public void updateBoard(Stage primaryStage, Board board, ArrayList<Position> availablePositions, Position p1, Position p2){

        this.board=board;

        this.p1 = p1;
        this.p2 = p2;
        primaryStage.setWidth(615);
        primaryStage.setHeight(635);

        okItem = createOkItem();

        for (int row = 0; row < board.getRow(); row++) {
            for (int col = 0; col < board.getCol(); col++) {
                if(board.getMyBoardAdjacency()[row][col]>4) {
                    Button emptyButton = new Button();
                    emptyButton.setPrefSize(42,55);
                    emptyButton.setStyle("-fx-background-color: transparent;"+"\n" +
                            "    -fx-background-size: stretch;");
                    itemBoardGrid.add(emptyButton, col, row);
                }
            }
        }



        boardBackground.setPrefSize(600, 600);
        AnchorPane.setTopAnchor(itemBoardGrid,87.0);
        AnchorPane.setLeftAnchor(itemBoardGrid,83.0);




        boardBackground = new AnchorPane(itemBoardGrid,okItem);
        boardBackground.setPrefSize(600, 600);

        AnchorPane.setTopAnchor(itemBoardGrid,87.0);
        AnchorPane.setLeftAnchor(itemBoardGrid,83.0);

        okItem.addEventHandler(MouseEvent.MOUSE_CLICKED,this::onClickOk);

        Scene scene = new Scene(boardBackground);
        primaryStage.setScene(scene);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.setTitle("board");
        primaryStage.show();
    }

}
