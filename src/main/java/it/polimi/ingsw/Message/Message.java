package it.polimi.ingsw.Message;

import it.polimi.ingsw.Enumerations.*;

public abstract class Message {
    private final String nickname;
    private final MessageType messageType;

    Message(String nickname, MessageType messageType) {
        this.nickname = nickname;
        this.messageType = messageType;
    }

    public String getNickname() {
        return nickname;
    }

    public MessageType getMessageType() {
        return messageType;
    }

}
