package edu.kh.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MemoDAOImpl implements MemoDAO{


	  // JDBC 객체 잠조 변수 선언 + Properties 참조 변수 선언
	   private Statement stmt;
	   private PreparedStatement pstmt;
	   private ResultSet rs;
	   
	   private Properties prop; 
	
	

	
	
	@Override
	public int memoCreate(Connection conn, String title, String content) throws Exception {
		
		//1. 결과 저장용 변수
		int result = 0;
		
		//2.익셉션은 throws하고있으니 try finally
		
		try {
			String sql = prop.getProperty("memoCreate");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,title);
			pstmt.setString(2,detail);
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
	@Override
	public int memoDelete(Connection conn, int memoNo) throws Exception {
		
		
				//결과 저장용 변수
				int result = 0;
				
				try {
					//sql얻어오기
					
					String sql = prop.getProperty("memoDelete");
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1,memoNo);
					result = pstmt.executeUpdate();
					
				} finally {
					close(pstmt);
				}

				return result;
	}
	
	
	
	
}
