package it.polimi.ingsw;

import it.polimi.ingsw.Controller.*;
import it.polimi.ingsw.Message.MessageManager;
import it.polimi.ingsw.Networking.Client.*;
import it.polimi.ingsw.View.*;


public class ClientApp {
    public static void main(String[] args) {
        MessageManager messageManager = new MessageManager();
        Cli view = new Cli();
        ClientController clientController = new ClientController(messageManager,new ObsClient(messageManager));
        view.addObserver(clientController);
        messageManager.addObserver(view);
        view.init();
    }
}