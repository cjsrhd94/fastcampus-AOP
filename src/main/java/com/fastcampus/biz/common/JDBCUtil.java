package com.fastcampus.biz.common;

import java.sql.*;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// JDBC 1단계 : 드라이버 로딩
			DriverManager.registerDriver(new org.h2.Driver());
			
			// JDBC 2단계 : Connection 연결(획득) : Connection은 고속도로다.
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Statement stmt, Connection conn) {
		// JDBC 5단계 : Connection 종료
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		// JDBC 5단계 : Connection 종료
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			rs = null;
		}
		
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
}







