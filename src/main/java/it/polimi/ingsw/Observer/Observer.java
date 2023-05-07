package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Message.Message;

public interface Observer {
    void update(Message message);
}