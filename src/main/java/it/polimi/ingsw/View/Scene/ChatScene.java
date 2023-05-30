package it.polimi.ingsw.View.Scene;

import it.polimi.ingsw.Message.Chat;
import it.polimi.ingsw.Observer.InputObservable;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.*;


public class ChatScene extends InputObservable implements GenericScene {

    private GridPane gridPane;
    private TextArea chat;
    private Button send;
    private ListView<String> chatListView;
    private TextArea messageTextArea;
    private static Stage stageInstance;

    public void start(Stage primaryStage) {


        stageInstance = primaryStage;
        gridPane = new GridPane();
        chat = new TextArea();
        send = new Button("Chat");
        String urlT = "file:src/main/resources/images/page_button.png";
        gridPane.add(chat,0,0);

        stageInstance.setTitle("MyShelfie Chat");

        BorderPane root = new BorderPane();

        chatListView = new ListView<>();
        root.setCenter(chatListView);

        HBox inputBox = new HBox();
        inputBox.setPadding(new Insets(10));
        inputBox.setSpacing(10);
        inputBox.setStyle("-fx-background-image: url('" + urlT + "'); " +
                " -fx-background-repeat: no-repeat;" +
                " -fx-background-size: stretch;");
        inputBox.setAlignment(Pos.CENTER);


        messageTextArea = new TextArea();
        messageTextArea.setPrefWidth(200);
        messageTextArea.setStyle("-fx-background-image: url('" + urlT + "'); " +
                "-fx-background-repeat: no-repeat;"  +
                " -fx-background-size: stretch;");
        inputBox.getChildren().add(messageTextArea);

        send = new Button("Send");
        send.setOnAction(e -> sendMessage());
        inputBox.getChildren().add(send);

        root.setBottom(inputBox);

        String urlB = "file:src/main/resources/images/parquet_background.jpg";
        root.setStyle("-fx-background-image: url('" + urlB + "'); " +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-size: 400 300;");

        Scene scene = new Scene(root, 400, 300);
        stageInstance.setScene(scene);
        stageInstance.show();
    }

    private void sendMessage() {
        String message = messageTextArea.getText();
        notifyInObserver(obs->obs.chat(new Chat(message)));
        //chatListView.getItems().add(message);
        messageTextArea.clear();
    }

    public static Stage getStageInstance() {
        return stageInstance;
    }

    public void update(String message){
            chatListView.getItems().add(message);
    }

}
