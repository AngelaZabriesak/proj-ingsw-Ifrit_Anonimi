package Network2;

import it.polimi.ingsw.Message.MessageGeneric;

import java.net.*;
import java.io.*;

public class ClientSocket {
    //attirbuti
    private Socket socket;
    private BufferedReader dalServer;
    private PrintStream alServer;
    private String nome;
    //costruttore
    public ClientSocket(String nome) {
        this.nome=nome;
        try {
            socket= new Socket("127.0.0.1",6000);
            dalServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            alServer = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Errore: "+e.getMessage());
        }
    }
    //metodo che gestisce la conversazione
    public void GestisciConversazione() {
        MessageGeneric messaggio;
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        try {
            do{
                messaggio = new MessageGeneric(dalServer.readLine());
                System.out.println(messaggio.getMessage());
                messaggio= new MessageGeneric(tastiera.readLine());
                alServer.println(nome+" "+messaggio);
            }
            while(!messaggio.getMessage().equals("exit"));
            socket.close();
            System.out.println("Connessione terminata");
        }catch(IOException e) {
            System.out.println("Errore: "+e.getMessage());
        }
    }
    public void disconnetti() {
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Connessione terminata");
        }
    }
    /***************************************************************************************/
    public static void main(String[] args) {
        ClientSocket mioClient = new ClientSocket("Client: ");
        mioClient.GestisciConversazione();
    }
}
