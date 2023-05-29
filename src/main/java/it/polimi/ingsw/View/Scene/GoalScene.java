package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Model.Goal.CommonGoal.Cgoal;
import it.polimi.ingsw.Model.Goal.PersonalGoal.Pgoal;
import it.polimi.ingsw.Observer.InputObservable;
import javafx.scene.Node;
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
    private ImageView[] tokens;
    private static Stage stagePInstance;
    private static Stage stageCInstance;

    public /*GridPane*/ void start(Stage primaryCStage,Stage primaryPStage, ArrayList<Cgoal> cGoal, Pgoal pgoal) {
        stagePInstance = primaryPStage;
        stageCInstance = primaryCStage;
        gridPane = new GridPane();
        if(cGoal==null){
            primaryPStage.setWidth(280);
            primaryPStage.setHeight(440);
            primaryPStage.setX(1200);
            primaryPStage.setY(0);
            primaryPStage.setTitle("personal goal "+pgoal.getDescription().split(" ")[2]);
        }
        else{
            tokens = new ImageView[cGoal.get(0).getMyTokens().size()];
            for(int i =0;  i< tokens.length;i++){
                tokens[i] = new ImageView(new Image("file:src/main/resources/images/tokens/scoring_"+cGoal.get(0).getMyTokens().get(i).getScore()+".jpg"));
                /*tokens[i].setFitWidth(55);
                tokens[i].setFitHeight(55);*/
            }
            primaryCStage.setWidth(825);
            primaryCStage.setHeight(300);
            primaryCStage.setX(530);
            primaryCStage.setY(565);
            primaryCStage.setTitle("common goals "+cGoal.get(0).getIndex()+", "+cGoal.get(1).getIndex());
        }
        pgoalPane = new StackPane();
        cGoalPane = new GridPane();
        if(pgoal!=null){
            System.out.println("pgoal: "+pgoal.getDescription().split(" ")[2]);
            ImageView iwPgoal = new ImageView(setPGoal(pgoal));
            pgoalPane.setStyle("-fx-background-repeat: no-repeat;"+
                    "-fx-background-size: 200 400;");
            pgoalPane.getChildren().add(iwPgoal);
        }
        if(cGoal!=null) {
            for (Cgoal cg : cGoal) {
                System.out.println("cgoal "+cg.getIndex());
                ImageView lcg = new ImageView(setCgoal(cg));
                /*AnchorPane goal = new AnchorPane(lcg,tokens[tokens.length-1]);
                AnchorPane.setRightAnchor(tokens[tokens.length-1],100.0);
                AnchorPane.setBottomAnchor(tokens[tokens.length-1],100.0);*/
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
        if(cGoal!=null) {
            primaryCStage.setScene(scene);
            primaryCStage.show();
        }
        if(pgoal!=null){
            primaryPStage.setScene(scene);
            primaryPStage.show();
        }
        /*gridPane = new GridPane();
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
        }*/
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


