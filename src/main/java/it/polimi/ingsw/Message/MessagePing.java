package it.polimi.ingsw.Message;

import it.polimi.ingsw.Enumerations.MessageType;

public class MessagePing  extends Message {


    public MessagePing() {
        super(null, MessageType.PING);
    }
}