package it.polimi.ingsw.Message;

import it.polimi.ingsw.Enumerations.MessageType;

public class Chat extends Message{

    private String msg;

    public Chat(String msg){
        super(MessageType.CHAT);
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
