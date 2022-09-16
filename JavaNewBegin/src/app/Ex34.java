package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex34 { //alter table

	public static void main(String[] args) {
		Connection conn = Ex30.getInstance().getConnection();
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(alter());
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
	public static String alter() {
	//	ex1)
		String sql = "alter table attest add column weight varchar(10) NOT NULL";
		return sql;
	}
}
// ex2) Age int 수정,
// ex3) Pw를 password로 varchar(30) not null
// ex4) age를 삭제
