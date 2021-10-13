package it.itismeucci.com;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class MultiServer {

   protected ArrayList<ServerThread>listaThread = new ArrayList<>();

    public void start(){
        try{
            ServerSocket serverSocket = new ServerSocket(6789);

            for(;;){
                System.out.println("1) Server in attesa...");
                Socket socket = serverSocket.accept();
                System.out.println("3 Server socket " + socket);
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();

                listaThread.add(e)

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istante del server!");
            System.exit(1);
        }
    }

    public void stop(){

    }
}
