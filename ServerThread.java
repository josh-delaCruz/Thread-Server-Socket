package it.itismeucci.com;

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
            System.out.println("Server chiuso da un'altro Thread");
        }
    }
    
    public void comunica() throws Exception{
        inDalClient = new BufferedReader(new InputStreamReader (client.getInputStream()));
        outVersoClient = new DataOutputStream(client.getOutputStream());
        
        for(;;){
            stringaRicevuta = inDalClient.readLine();
            if(stringaRicevuta == null || stringaRicevuta.equals("fine")){
                outVersoClient.writeBytes(stringaRicevuta + " (=>server in chiusura)");
                System.out.println("Echo sul server in chiusura: " + stringaRicevuta);
                break;
            }else{
                outVersoClient.writeBytes(stringaRicevuta + stringaRicevuta);
            }

            outVersoClient.close();
            inDalClient.close();
            System.out.println("9) chiusura socket" + client);
        }
    }
}