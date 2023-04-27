package it.polimi.ingsw.Message;

import it.polimi.ingsw.Enumerations.*;

public class MessageError extends Message {

    private final String error;

    public MessageError(String nickname, String error) {
        super(nickname, MessageType.ERROR, "");
        this.error = error;
    }

    public String getError() {
        return error;
    }

}