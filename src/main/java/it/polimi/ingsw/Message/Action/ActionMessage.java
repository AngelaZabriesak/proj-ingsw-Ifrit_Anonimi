package it.polimi.ingsw.Message.Action;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public abstract class ActionMessage extends Message {

    private final String description;

    public ActionMessage(String description, MessageType type){
        super(type);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
