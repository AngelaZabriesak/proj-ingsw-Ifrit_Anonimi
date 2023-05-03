package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;

public class Win extends Message {

    private String nicknameWinner;
    public Win(String nicknameWinner) {
        super(MessageType.WIN);
        this.nicknameWinner=nicknameWinner;
        setNickname(nicknameWinner);
    }
}
