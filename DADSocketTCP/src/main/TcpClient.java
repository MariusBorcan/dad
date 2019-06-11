package main;
import java.net.*;
import java.io.*;

public class TcpClient {

   public static void main(String [] args) {
      String serverName = "localhost";
      int port = 11000;
      try {
         
         Socket client = new Socket(serverName, port);
         
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
         
         out.writeUTF("Salutari de la client");
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         
         System.out.println(in.readUTF());
         client.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}