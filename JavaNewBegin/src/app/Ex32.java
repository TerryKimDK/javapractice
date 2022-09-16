package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Ex32 {

	public static void main(String[] args) {
		Connection conn = Ex30.getInstance().getConnection();
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("ID : ");
		String id = sc.next();
		try {
			pstmt = conn.prepareStatement(delete());
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
			String msg = result > -1 ? "성공" : "실패";
			System.out.println(msg);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}catch(Exception e) {}
		}
	}

	public static String delete() {
		String sql = "Delete from dbtest where id=?";
		return sql;
		
	}
	
}
