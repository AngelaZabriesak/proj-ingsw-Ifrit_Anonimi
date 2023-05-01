package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class CompletedQuestion extends Message {
    private String message;

    public CompletedQuestion(String message){
        super(MessageType.OK_QUESTION);
        this.message = message;
    }
}
