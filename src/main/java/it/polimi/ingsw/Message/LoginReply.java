package it.polimi.ingsw.Message;

import it.polimi.ingsw.Enumerations.*;

/**
 * Message used to confirm or discard a login request of a client.
 */
public class LoginReply extends Message {
    private final boolean nicknameAccepted;
    private final boolean connectionSuccessful;

    public LoginReply(boolean nicknameAccepted, boolean connectionSuccessful) {
        super("server", MessageType.LOGIN_REPLY, "");
        this.nicknameAccepted = nicknameAccepted;
        this.connectionSuccessful = connectionSuccessful;
    }

    public boolean isNicknameAccepted() {
        return nicknameAccepted;
    }

    public boolean isConnectionSuccessful() {
        return connectionSuccessful;
    }
}
