package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Player;

public class EndTurn extends Message {

    private final String nextPlayer;
    private final Player actualPlayer;
    public EndTurn(Player actualPlayer,String nextPlayer) {
        super(MessageType.END_TURN);
        this.nextPlayer = nextPlayer;
        this.actualPlayer = actualPlayer;
    }

    public Player getActualPlayer(){
        return actualPlayer;
    }
    public String getNextPlayer(){
        return nextPlayer;
    }
}
