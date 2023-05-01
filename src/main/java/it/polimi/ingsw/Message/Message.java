package it.polimi.ingsw.Message;

import it.polimi.ingsw.Enumerations.MessageType;

import java.io.Serializable;

public abstract class Message implements Serializable {
    private String nickname;
    private MessageType type;

    public Message(MessageType type){
        this.type = type;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void manage(MessageManager messageManager){
        messageManager.manage(this);
    }
}
