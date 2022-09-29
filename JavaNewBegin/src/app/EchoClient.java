package app;
import java.util.*;
import java.io.*;
import java.net.*;

public class EchoClient {
   private Socket socket;
   public EchoClient(String host, int port) throws Exception {
      socket = new Socket(host, port);
   }
   public void echo() throws IOException{

      InputStream is = socket.getInputStream();
      OutputStream os = socket.getOutputStream();
      BufferedReader in = new BufferedReader(new InputStreamReader(is));
      PrintWriter out = new PrintWriter(os, true);
      BufferedReader con = new BufferedReader(new InputStreamReader(System.in));
      
      while(true) {
         String msg = con.readLine();
         out.println(msg);
         if(msg.equals("bye")) {
            break;
         }
         System.out.println(in.readLine());
      }
   }
   public void close() throws IOException {
      socket.close();
   }
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      try {
         EchoClient ec;
         System.out.println("메시지를 입력하세요");
         if(args.length > 0) {
            ec = new EchoClient(args[0], 7979);
         }else {
            ec = new EchoClient("localhost", 7979);
         }
         ec.echo();
         ec.close();
      }catch(Exception e) {
         e.printStackTrace();
      }
   }

}