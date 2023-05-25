package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class Wait extends Message {

    private int nPlayer;

    public Wait(int nPlayer){
        super(MessageType.WAIT);
        this.nPlayer = nPlayer;
    }

    public int getnPlayer(){
        return nPlayer;
    }
}
