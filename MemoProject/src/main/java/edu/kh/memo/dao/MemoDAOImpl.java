package edu.kh.memo.dao;

import java.sql.Connection;

public class MemoDAOImpl {

	
	
	@Override
	public int memoDelete(Connection conn, int memoNo) throws Exception {
		
		
				//결과 저장용 변수
				int result = 0;
				
				try {
					//sql얻어오기
					
					String sql = prop.getProperty("memoDelete");
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1,,memoNo);
					result = pstmt.executeUpdate();
					
				} finally {
					close(pstmt);
				}

				return result;
	}
	
	
	
	
}
