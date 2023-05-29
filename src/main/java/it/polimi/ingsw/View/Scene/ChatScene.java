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

import java.awt.*;

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
        gridPane.add(chat,0,0);

        stageInstance.setTitle("JavaFX Chat");

        BorderPane root = new BorderPane();

        chatListView = new ListView<>();
        root.setCenter(chatListView);

        HBox inputBox = new HBox();
        inputBox.setPadding(new Insets(10));
        inputBox.setSpacing(10);
        inputBox.setAlignment(Pos.CENTER);

        messageTextArea = new TextArea();
        messageTextArea.setPrefWidth(200);
        inputBox.getChildren().add(messageTextArea);

        send = new Button("Send");
        send.setOnAction(e -> sendMessage());
        inputBox.getChildren().add(send);

        root.setBottom(inputBox);

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
        if (stageInstance == null)
            stageInstance = new Stage();
        return stageInstance;
    }

    public void update(String message){
        chatListView.getItems().add(message);
    }

}
