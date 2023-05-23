package it.polimi.ingsw.Message.Error;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;

public class Error extends Message {
    private final String error;

    public Error(String error) {
        super(MessageType.ERROR);
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
