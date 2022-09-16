package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex37 {
	
	public static void main(String[] args) {
		Connection conn = Ex30.getInstance().getConnection();
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(Ex38.insert());
			int result = pstmt.executeUpdate(); // -1 , 0 , 1 data manufulation insert, update, delete / create drop 0
			//System.out.println(result); // 0
			String msg = result > -1 ? "성공" : "실패";
			System.out.println(msg);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}
	public static String insert() {
		String sql = "insert into test6(id, pw, mdate, age) values"
				+ "values('abc,'123','2021-09-08, 100)";
		return sql;
	}
	
	public static String select() {
		String sql = "select * from test6";
				return sql;
	}
	
}
