package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Model.Goal.CommonGoal.Cgoal;
import it.polimi.ingsw.Model.Goal.PersonalGoal.Pgoal;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.util.*;

public class GoalScene {
    private GridPane gridPane;
    private Pane pgoalPane;
    private GridPane cGoalPane;

    public /*GridPane*/ void start(Stage primaryStage, ArrayList<Cgoal> cGoal, Pgoal pgoal) {
        gridPane = new GridPane();
        if(cGoal==null){
            primaryStage.setWidth(280);
            primaryStage.setHeight(440);
            primaryStage.setX(1200);
            primaryStage.setY(0);
            primaryStage.setTitle("personal goal "+pgoal.getIndex());
        }
        else{
            primaryStage.setWidth(825);
            primaryStage.setHeight(300);
            primaryStage.setX(530);
            primaryStage.setY(565);
            primaryStage.setTitle("common goals "+cGoal.get(0).getIndex()+", "+cGoal.get(1).getIndex());
        }
        pgoalPane = new StackPane();
        cGoalPane = new GridPane();
        if(pgoal!=null){
            ImageView iwPgoal = new ImageView(setPGoal(pgoal));
            pgoalPane.setStyle("-fx-background-repeat: no-repeat;"+
                    "-fx-background-size: 200 400;");
            pgoalPane.getChildren().add(iwPgoal);
        }
        Rotate rotate = new Rotate(90);
        if(cGoal!=null) {
            for (Cgoal cg : cGoal) {
                ImageView lcg = new ImageView(setCgoal(cg));
                //lcg.getTransforms().add(rotate);
                System.out.println(cg.getIndex());
                cGoalPane.setStyle("-fx-background-repeat: no-repeat;"+
                        "-fx-background-size: 400 400;");
                cGoalPane.add(lcg, cGoal.indexOf(cg),0);
            }
        }
        gridPane.add(pgoalPane,1,0);
        gridPane.add(cGoalPane,0,0);
        String url = "file:src/main/resources/images/parquet_background.jpg";
        gridPane.setStyle("-fx-background-image: url('" + url + "'); " +"-fx-background-repeat: no-repeat;");
        //return gridPane;
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Image setPGoal(Pgoal pgoal){
        String imagePath="file:src/main/resources/images/personalgoals/personalgoal"+pgoal.getIndex()+".jpg";
        Image image = new Image(imagePath);
        return image;
    }
    public Image setCgoal(Cgoal cgoal){
        String imagePath="file:src/main/resources/images/commongoals/commongoal"+cgoal.getIndex()+".jpg";
        Image image = new Image(imagePath);
        return image;
    }
}
