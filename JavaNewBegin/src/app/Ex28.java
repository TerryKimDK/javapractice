package app;

import java.sql.*;

import java.sql.*;

public class Ex28 {
	Connection conn;

	public Ex28() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "1234");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("오류 : " + e.getStackTrace());
		}
	}

	public void createTable() {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate("create table DBTest(ID varchar(50), PW varchar(50))");
			if (result < 0) {
				System.out.println("실행실패");
			} else {
				System.out.println("실행성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
//	public void signIn() {
//		Statement coca = null;
//		try {
//	}

	public static void main(String args[]) {
		new Ex28().createTable();
		System.out.println("test");
	}
}
