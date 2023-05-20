package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Position;

public class ChoosePositionRequest extends Message {

    private final Position p1,p2;

    public ChoosePositionRequest(Position p1, Position p2){
        super(MessageType.CHOOSEITEM);
        this.p1 = p1;
        this.p2 = p2;
    }

    public Position getP1(){
        return p1;
    }

    public Position getP2(){
        return p2;
    }
}
