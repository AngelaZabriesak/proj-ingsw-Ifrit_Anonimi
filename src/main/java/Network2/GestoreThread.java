package Network2;

import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Message.MessageGeneric;

import java.net.*;
import java.io.*;
public class GestoreThread extends Thread{
    //attributi
    private Socket s;
    //costruttore
    public GestoreThread(Socket s,String nomeThread) {
        super(nomeThread);
        this.s=s;
    }
    //metodo run
    public void run() {
        MessageGeneric msg;
        //float totale=0,valore;
        try {
            do {
                //creiamo lo stream di input
                InputStream in = s.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                //DataInputStream in = new DataInputStream(s.getInputStream());
                //creiamo lo stream di output
                //OutputStream out = s.getOutputStream();
                //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                out.writeChars("BENVENUTI SUL CLIENT");
                msg=new MessageGeneric(br.readLine());
                System.out.println(msg.getMessage());
            }while(!msg.getMessage().equals("STOP"));
        }catch(IOException e) {
            System.out.println("Errore : "+e.getMessage());
        }
    }

}

