package it.polimi.ingsw.Message;

import it.polimi.ingsw.Enumerations.MessageType;

public class TurnAlert extends Message{
    private final String descr;
    public TurnAlert(String descr) {
        super(MessageType.TURN_ALERT);
        this.descr = descr;
    }

    public String getDescr() {
        return descr;
    }
}
