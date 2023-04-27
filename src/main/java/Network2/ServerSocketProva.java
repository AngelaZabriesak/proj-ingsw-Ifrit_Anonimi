package Network2;

import java.io.*;
import java.net.*;

public class ServerSocketProva {
        public static void main(String[] args) {
            try {
                int numThread=0;
                ServerSocket ss = new ServerSocket(6000);
                System.out.println("Server avviato sulla porta 6000");
                while(true) {
                    Socket s = ss.accept();
                    GestoreThread gestore = new GestoreThread(s,"Thread "+numThread);
                    gestore.start();
                    System.out.println("Client con thread: "+numThread);
                    numThread++;
                }
            } catch (IOException e) {
                System.out.println("Errore "+e.getMessage());
            }
        }
}
