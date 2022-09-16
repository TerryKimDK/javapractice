package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex30 {
	private static Ex30 instance;
	private Connection conn;

	public Ex30() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "1234");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("오류 : " + e.getStackTrace());
		}
	}
	
	public static Ex30 getInstance(){
		if(instance == null) {
			instance = new Ex30();
		}
		return instance;
	
	}
	public Connection getConnection() {
		return this.conn;
	}
}