package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/* 
 * order by 문 - order by (asc[ascending], desc[desceding])
 * 정령 [테이블 생성]
 * ob test
 *  create table obtest ( num int, id varchar(10));
 */

public class Ex38 {
	public static void main(String[] args) {
		Connection conn = Ex30.getInstance().getConnection();
		//PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			/*
			 * 
			 */
			String sql = orderBy();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			for(int i=1; i <= cols; i++) {
				String columnName = rsmd.getColumnName(i);
				System.out.println(columnName + "\t");
			}
			System.out.println("\n--------------------------------------");
			while(rs.next()) {
				for(int i = 1; i <= cols; i++) {
					System.out.println(rs.getString(i)+ "\t");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static String insert() {
		String sql = "insert into obtest values(3, 'ghi')";
		return sql;
	}

	public static String orderBy() {
		String sql = "select * from order by id desc";
		return sql;
	}
}
