package it.polimi.ingsw.Message.Request;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Game.Board;
import it.polimi.ingsw.Model.Goal.CommonGoal.Cgoal;
import it.polimi.ingsw.Model.Goal.PersonalGoal.Pgoal;

import java.util.ArrayList;

public class NPlayerRequest extends Message {

    public NPlayerRequest() {
        super(MessageType.N_PLAYER_REQUEST);
    }
}
