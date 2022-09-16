package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class Ex29 { //insert
	Connection conn;

	public Ex29() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "1234");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("오류 : " + e.getStackTrace());
		}
	}
	
	public void insert() {
		PreparedStatement pstmt = null;
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("ID : ");
			String id = sc.next();
			System.out.println("PW ");
			String pw = sc.next();
			pstmt = conn.prepareStatement("insert into DBTest values(?, ?)");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			int result = pstmt.executeUpdate();
			
			String msg = result > -1 ? "성공" : "실패";
			System.out.println(msg);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}	
		
	}

	public static void main(String[] args) {
		new Ex29().insert();
		
	}

}
