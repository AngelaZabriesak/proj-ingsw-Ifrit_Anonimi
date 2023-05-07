package it.polimi.ingsw.Networking.Client;

import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Message.ViewMessageManager;
import it.polimi.ingsw.Observer.ObserverNew.*;

public class ObsClient implements SocketClientObserver {

    private ViewMessageManager messageManager;

    public ObsClient(ViewMessageManager messageManager){
        this.messageManager = messageManager;
    }

    @Override
    public void update(Message message) {
        message.manageView(messageManager);
    }
}
