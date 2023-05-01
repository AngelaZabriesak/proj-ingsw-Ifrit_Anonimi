package it.polimi.ingsw.Message.GameState;

import it.polimi.ingsw.Enumerations.MessageType;
import it.polimi.ingsw.Message.Message;

public class ConnectionOK extends Message {

    private boolean ok;

    public ConnectionOK(boolean ok) {
        super(MessageType.OK_CONNECTION);
        this.ok = ok;
    }

    public boolean isOk() {
        return ok;
    }
}
