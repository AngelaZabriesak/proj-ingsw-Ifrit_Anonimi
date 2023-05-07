package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class EndTurn extends Message {

    private String nextPlayer;
    public EndTurn(String nextPlayer) {
        super(MessageType.END_TURN);
        this.nextPlayer = nextPlayer;
    }

    public String getNextPlayer(){
        return nextPlayer;
    }
}
