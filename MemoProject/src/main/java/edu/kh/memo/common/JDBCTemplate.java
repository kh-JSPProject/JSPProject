package edu.kh.memo.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	private static Connection conn = null;

	public static Connection getConnection() {
		
		try {

			if (conn !=null && !conn.isClosed()) {
				return conn;
			}
			

			Properties prop = new Properties();

			String filePath = JDBCTemplate.class.getResource("/xml/driver.xml").getPath();

			System.out.println(filePath);
			
			prop.loadFromXML(new FileInputStream(filePath));
					
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("userName"), prop.getProperty("password"));
			
			conn.setAutoCommit(false);		
			
		} 
		catch (Exception e) 
		{
			System.out.println("커넥션 생성 중 예외가 발생");
			e.printStackTrace();
		}
		return conn;
	}

	public static void commit(Connection conn) {
		try {
			
			if(conn!=null && !conn.isClosed()) 
			conn.commit();			
		} 
		
		catch (Exception e) {
			System.out.println("커밋 중 예외 발생");
			e.printStackTrace();
		}	
	}

	public static void rollback(Connection conn) {
		try {			
			if(conn!=null && !conn.isClosed())
			conn.rollback();			
		} 
		
		catch (Exception e) {
			System.out.println("롤백 중 예외 발생");
			e.printStackTrace();
		}
		
	}
	
	public static void close(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) conn.close();
			
		} 
		catch (Exception e) {
			System.out.println("커넥션을 닫는 중에 예외가 발생");
			e.printStackTrace();
		}	
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt!=null && !stmt.isClosed() )
			stmt.close();
		} 
		
		catch (Exception e) {
			System.out.println("Statement를 닫는 중에 예외가 발생");
			e.printStackTrace();
		}	
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs!=null && !rs.isClosed()) rs.close();
			
		} 
		catch (Exception e) {
			System.out.println("커넥션을 닫는 중에 예외가 발생");
			e.printStackTrace();
		}	
	}
}