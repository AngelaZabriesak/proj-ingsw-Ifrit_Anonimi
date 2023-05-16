package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.*;
import it.polimi.ingsw.Model.*;

import java.util.*;

public class Item3PositionRequest extends Message {

    private final Position p1,p2;

    private final ArrayList<Position> posAvailable;
    private final String error;

    public Item3PositionRequest(String error,Position p1, Position p2,ArrayList<Position> posAvailable) {
        super(MessageType.ITEM_3POSITION_REQUEST);
        this.p1 = p1;
        this.p2 = p2;
        this.posAvailable = posAvailable;
        this.error = error;
    }

    public Position getP1() {
        return p1;
    }

    public Position getP2() {
        return p2;
    }

    public ArrayList<Position> getPosAvailable() {
        return posAvailable;
    }

    public String getError(){
        return error;
    }
}
