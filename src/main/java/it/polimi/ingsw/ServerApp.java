package it.polimi.ingsw;

import it.polimi.ingsw.Networking.Server.*;

public class ServerApp {

    public static void main(String[] args) {
        int serverPort = 16847; // valore di default

        for (int i = 0; i < args.length; i++) {
            if (args.length >= 2 && (args[i].equals("--port") || args[i].equals("-p"))) {
                try {
                    serverPort = Integer.parseInt(args[i + 1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid port. Using default port.");
                }
            }
        }
        MainSocketServer server = new MainSocketServer(serverPort);
        server.startServer();
    }
}
