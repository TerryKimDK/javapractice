package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect { //Ex20
    private static DbConnect instance;
    private Connection conn;

    public DbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("오류 : " + e.getStackTrace());
        }
    }

    public static DbConnect getInstance(){
        if(instance == null) {
            instance = new DbConnect();
        }
        return instance;

    }
    public Connection getConnection() {
        return this.conn;
    }
}