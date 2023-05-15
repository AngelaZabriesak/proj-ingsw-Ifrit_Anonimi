package it.polimi.ingsw.Message.Response;


import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Position;

import java.util.Objects;

public class ChoosePositionResponse extends Message {

    Position p1,p2;

    private String response;

    public ChoosePositionResponse(String response,Position p1,Position p2){
        super(MessageType.CHOOSEITEM_RESPONSE);
        this.p1 = p1;
        this.p2 = p2;
        this.response = response;
    }

    public String getResponse(){
        return response;
    }


    public Position getP1(){
        return p1;
    }
    public Position getP2(){
        return p2;
    }
}
