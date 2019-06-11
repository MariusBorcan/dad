package main;
import java.net.*;
import java.io.*;

public class TcpServer extends Thread {
   private ServerSocket serverSocket;
   
   public TcpServer(int port) throws IOException {
      serverSocket = new ServerSocket(port);
   }

   public void run() {
      while(true) {
         try {
            Socket server = serverSocket.accept();
        
            DataInputStream in = new DataInputStream(server.getInputStream());
            
            System.out.println(in.readUTF());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("Salutari de la server");
            server.close();
            
         } catch (IOException e) {
            e.printStackTrace();
            break;
         }
      }
   }
   
   public static void main(String [] args) {
      int port = 11000;
      try {
         Thread t = new TcpServer(port);
         t.start();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}