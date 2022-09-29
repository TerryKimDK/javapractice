package app;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Ex30 {
	private static Ex30 instance;
	private Connection conn;
	private DataSource ds;

	public Ex30() {
		/*
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "1234");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("오류 : " + e.getStackTrace());
		}*/
		try {
				ds = (DataSource)new InitialContext().lookup("java:/comp/env/jdbc/oracle");
		}catch(NamingException e) { e.printStackTrace();}
	}
	
	public static Ex30 getInstance(){
		if(instance == null) {
			instance = new Ex30();
		}
		return instance;
	
	}
	public Connection getConnection() {
		try {
			conn = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return this.conn;
	}
	
}