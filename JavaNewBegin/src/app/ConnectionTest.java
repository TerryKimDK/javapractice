package app;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
   ConnectionTest connection;
   public void connect() {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver"); 
          DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "1234");
      }catch(ClassNotFoundException | SQLException e) {
         System.out.println("오류 : " + e.getStackTrace());
      } 
   }
   public static void main(String[] args) {
      new ConnectionTest();
      System.out.println("Db 연결");
   }

}