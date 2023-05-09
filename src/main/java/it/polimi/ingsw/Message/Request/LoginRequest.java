package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class LoginRequest extends Message {

    public LoginRequest(){
        super(MessageType.LOGIN_REQUEST);
    }
}
