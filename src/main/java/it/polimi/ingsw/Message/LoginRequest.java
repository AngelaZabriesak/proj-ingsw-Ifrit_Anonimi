package it.polimi.ingsw.Message;

import it.polimi.ingsw.Enumerations.*;

/**
 * Message used by the client to request a login to the server.
 */
public class LoginRequest extends Message {

    public LoginRequest(String nickname) {
        super(nickname, MessageType.LOGIN_REQUEST);
    }

}
