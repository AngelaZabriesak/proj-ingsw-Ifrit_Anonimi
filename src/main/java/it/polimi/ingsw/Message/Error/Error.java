package it.polimi.ingsw.Message.Error;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class Error extends Message {
    private String error;

    public Error(String error) {
        super(MessageType.ERROR);
        this.error = error;
    }

    public String getError() {
        return error;
    }
}