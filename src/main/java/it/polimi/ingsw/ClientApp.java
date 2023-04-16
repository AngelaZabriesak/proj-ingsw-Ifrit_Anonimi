package it.polimi.ingsw;

import it.polimi.ingsw.Controller.*;
import it.polimi.ingsw.View.*;


public class ClientApp {
    public static void main(String[] args) {
        Cli view = new Cli();
        ClientController clientcontroller = new ClientController(view);
        view.addObserver(clientcontroller);
        view.init();
    }
}