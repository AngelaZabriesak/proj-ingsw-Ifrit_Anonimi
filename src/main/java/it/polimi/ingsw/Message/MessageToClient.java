package it.polimi.ingsw.Message;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Model.Game.Game;

import java.io.*;

public class MessageToClient implements Serializable {
    private final String nickname;
    private final MessageType messageType;
    private final String message;
    private Game game;

    public MessageToClient(String nickname, MessageType messageType, String message) {
        this.nickname = nickname;
        this.messageType = messageType;
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public String getNickname() {
        return nickname;
    }

    public MessageType getMessageType() {
        return messageType;
    }


}
