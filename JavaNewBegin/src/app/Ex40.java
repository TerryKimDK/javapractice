package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex40 {

	public static void main(String[] args) {
		Connection conn = Ex30.getInstance().getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		String sql = select();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			int columnCnt = rsmd.getColumnCount();
			for( int i = 1; i <= columnCnt; i++) {
				String columnName = rsmd.getColumnName(i);
				System.out.print(columnName + "\t");
			}
			System.out.println("\n-------------------------------------------");
			while(rs.next()) {
				for( int i = 1; i <= columnCnt; i++ ) {
					String columnValue = rs.getString(i);
					System.out.print(columnValue + "\t");
				}
				System.out.println();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static String select() {
// ex1	
//		String sql="select count (type) from gbtest";
//		return sql;
// ex2
//		String sql="select type, count(name) as cnt from gbtest group by type";
//		return sql;
// ex3
//		String sql="select type, count(name) as cnt from gbtest where type > 1 group by type";
//		return sql;
// ex4
//		String sql="select type, count(name) as cnt from gbtest where type > 1 group by type having cnt >= 2";
//		return sql;
// 연습문제	
		String sql="select type, count(name) as cnt from gbtest where type > 1 group by type having cnt >= 2 order by type desc";
		return sql;
		
	}

}
