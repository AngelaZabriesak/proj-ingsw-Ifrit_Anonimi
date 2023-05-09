package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class Login extends Message {

    private String newNickname;

    public Login(String newNickname){
        super(MessageType.LOGIN);
        setNewNickname(newNickname);
    }

    public void setNewNickname(String newNickname) {
        this.newNickname = newNickname;
        setNickname(newNickname);
    }

    public String getNewNickname() {
        return getNickname();
    }
}
