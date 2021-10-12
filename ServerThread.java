
package Server;

import java.net.*;
import java.io.*;

public class ServerThread extends Thread{
    protected ServerSocket server = null;
    protected Socket client = null;
    
    protected String stringaRicevuta = null;
    protected String stringaModificata = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    
    public ServerThread(Socket socket){
        this.client = socket;
        
    }
    
    public void run(){
        try{
            comunica();
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
    
    public void comunica() throws Exception{
        inDalClient = new BufferedReader(new InputStreamReader (client.getInputStream()));
        outVersoClient = new DataOutputStream(client.getOutputStream());
        
        for(;;){
            stringaRicevuta = inDalClient.readLine();
            if(stringaRicevuta == null || stringaRicevuta.equals("fine")){
                outVersoClient.writeBytes(stringaRicevuta + " (=>server in chiusura)");
            }
        }
    }
}
