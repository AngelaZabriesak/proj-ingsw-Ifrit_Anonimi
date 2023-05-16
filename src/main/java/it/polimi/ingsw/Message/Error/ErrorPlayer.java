package it.polimi.ingsw.Message.Error;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class ErrorPlayer extends Message {

    public ErrorPlayer(){
        super(MessageType.ERROR_PLAYER);
    }
}
