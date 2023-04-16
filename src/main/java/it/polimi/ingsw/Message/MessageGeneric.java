package it.polimi.ingsw.Message;

import it.polimi.ingsw.Enumerations.MessageType;

public class MessageGeneric extends Message{
    private final String message;


    public MessageGeneric(String message) {
        super("server", MessageType.GENERIC_MESSAGE);
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

}
