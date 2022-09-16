package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginMain {
    Connection conn;
    public LoginMain(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("오류 : " + e.getStackTrace());
        }
    }
}
