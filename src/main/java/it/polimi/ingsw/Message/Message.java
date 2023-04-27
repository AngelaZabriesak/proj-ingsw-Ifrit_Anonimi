package it.polimi.ingsw.Message;

import it.polimi.ingsw.Enumerations.*;

public abstract class Message {
    private final String nickname;
    private final MessageType messageType;

    private final String message;

    public Message(String nickname, MessageType messageType, String message) {
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
