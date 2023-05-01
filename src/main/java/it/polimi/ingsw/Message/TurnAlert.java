package it.polimi.ingsw.Message;

import it.polimi.ingsw.Enumerations.MessageType;

public class TurnAlert extends Message{
    private String descr="It's your turn";
    public TurnAlert() {
        super(MessageType.TURN_ALERT);
    }


    public String getDescr() {
        return descr;
    }
}
