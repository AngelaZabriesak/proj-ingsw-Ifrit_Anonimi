package it.polimi.ingsw;

import it.polimi.ingsw.Controller.*;
import it.polimi.ingsw.Message.*;
import it.polimi.ingsw.Networking.Client.*;
import it.polimi.ingsw.View.*;


public class ClientAppCLI {
    public static void main(String[] args) {
        final ViewMessageManager messageManager = new ViewMessageManager();
        Cli view = new Cli();
        VirtualView vView = new VirtualView(view);
        ClientController clientController = new ClientController(messageManager,new ObsClient(messageManager));
        view.addObserver(clientController);
        messageManager.addObserver(vView);
        view.init();
    }
}