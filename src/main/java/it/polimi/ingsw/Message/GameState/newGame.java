package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;

public class newGame extends Message {

    public newGame(){
        super(MessageType.NEW_GAME);
    }
}
