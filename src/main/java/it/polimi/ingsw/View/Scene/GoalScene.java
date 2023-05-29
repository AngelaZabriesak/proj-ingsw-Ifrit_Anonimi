package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Model.Goal.CommonGoal.Cgoal;
import it.polimi.ingsw.Model.Goal.PersonalGoal.Pgoal;
import it.polimi.ingsw.Observer.InputObservable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;


import java.util.*;

public class GoalScene extends InputObservable implements GenericScene {
    private GridPane gridPane;
    private Pane pgoalPane;
    private GridPane cGoalPane;
    private static Stage stagePInstance;
    private static Stage stageCInstance;

    public /*GridPane*/ void start(Stage primaryStage, ArrayList<Cgoal> cGoal, Pgoal pgoal) {
        stagePInstance = primaryStage;
        stageCInstance = primaryStage;
        /*gridPane = new GridPane();
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
            System.out.println("pgoal: "+pgoal.getIndex());
            ImageView iwPgoal = new ImageView(setPGoal(pgoal));
            pgoalPane.setStyle("-fx-background-repeat: no-repeat;"+
                    "-fx-background-size: 200 400;");
            pgoalPane.getChildren().add(iwPgoal);
        }
        if(cGoal!=null) {
            for (Cgoal cg : cGoal) {
                System.out.println("cgoal "+cg.getIndex());
                ImageView lcg = new ImageView(setCgoal(cg));
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
        primaryStage.show();*/

        gridPane = new GridPane();
        String url = "file:src/main/resources/images/parquet_background.jpg";

        if (pgoal != null) {
            pgoalPane = new StackPane();
            ImageView iwPgoal = new ImageView(setPGoal(pgoal));
            pgoalPane.setStyle("-fx-background-repeat: no-repeat;" + "-fx-background-size: stretch;" + "-fx-background-image: url('" + url + "'); ");
            pgoalPane.getChildren().add(iwPgoal);

            Scene pgoalScene = new Scene(pgoalPane, 265, 405);
            Stage stageP = new Stage();
            stageP.setX(1200);
            stageP.setY(0);
            stageP.setTitle("Personal Goal " + pgoal.getDescription().split(" ")[2]);
            stageP.setScene(pgoalScene);
            stageP.show();
        }

        if (cGoal != null) {
            cGoalPane = new GridPane();

            for (Cgoal cg : cGoal) {
                ImageView lcg = new ImageView(setCgoal(cg));
                cGoalPane.setHgap(15);
                cGoalPane.setStyle("-fx-background-repeat: no-repeat;" + "-fx-background-size: stretch;" + "-fx-background-image: url('" + url + "'); ");
                cGoalPane.add(lcg, cGoal.indexOf(cg), 0);
            }

            Scene cgoalScene = new Scene(cGoalPane, 815, 260);
            Stage stageC = new Stage();
            stageC.setX(600);
            stageC.setY(565);
            stageC.setTitle("Common Goals");
            stageC.setScene(cgoalScene);
            stageC.show();
        }
    }

    public Image setPGoal(Pgoal pgoal){
        String imagePath="file:src/main/resources/images/personalgoals/personalgoal"+pgoal.getDescription().split(" ")[2]+".jpg";
        Image image = new Image(imagePath);
        return image;
    }
    public Image setCgoal(Cgoal cgoal){
        String imagePath="file:src/main/resources/images/commongoals/commongoal"+cgoal.getIndex()+".jpg";
        Image image = new Image(imagePath);
        return image;
    }

    public static Stage getStagePInstance(){
        if(stagePInstance == null)
            stagePInstance = new Stage();
        return stagePInstance;
    }


    public static Stage getStageCInstance(){
        if(stageCInstance == null)
            stageCInstance = new Stage();
        return stageCInstance;
    }
}


