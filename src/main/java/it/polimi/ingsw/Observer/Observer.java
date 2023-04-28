package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Message.*;

public interface Observer {
    void update(MessageToClient message);
}
