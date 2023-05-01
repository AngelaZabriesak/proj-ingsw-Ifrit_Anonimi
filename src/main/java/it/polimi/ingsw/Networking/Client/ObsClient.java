package it.polimi.ingsw.Networking.Client;

import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Message.MessageManager;
import it.polimi.ingsw.Observer.ObserverNew.*;

public class ObsClient implements SocketClientObserver {

    private MessageManager messageManager;

    public ObsClient(MessageManager messageManager){
        this.messageManager = messageManager;
    }

    @Override
    public void update(Message message) {
        message.manage(messageManager);
    }
}
