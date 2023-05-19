package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class EndTurn extends Message {

    private String actualPlayer,nextPlayer;
    public EndTurn(String actualPlayer,String nextPlayer) {
        super(MessageType.END_TURN);
        this.nextPlayer = nextPlayer;
        this.actualPlayer = actualPlayer;
    }

    public String getActualPlayer(){
        return actualPlayer;
    }
    public String getNextPlayer(){
        return nextPlayer;
    }
}
