package edu.kh.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static edu.kh.memo.common.JDBCTemplate.*;


import edu.kh.memo.dto.User;


public class MemoDAOImpl implements MemoDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs =null;
	
	
	@Override
	public User selectUserById(String userId, Connection conn) throws Exception {
	    User user = null;
		String sql = "SELECT user_no, user_id, user_pw, user_name FROM TB_USERS WHERE user_id = ?";
	    
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, userId);
	        rs = pstmt.executeQuery();
	        
	        if (rs.next()) {
	            user = new User(
	                rs.getInt("USER_NO"),
	                rs.getString("USER_ID"),
	                rs.getString("USER_PW"),
	                rs.getString("USER_NAME")
	            );
	        }
	    } finally {
	        close(rs);
	        close(pstmt);
	    }
	    
	    return user;
	}

	
    @Override
    public int insertUser(User user, Connection conn) throws Exception {
        int result = 0;
        String sql = "INSERT INTO TB_USERS (USER_no,user_id, user_pw, user_name) "
        		+ "VALUES (SEQ_USER_NO.NEXTVAL, ? , ? , ? )";

        // INSERT INTO TB_USERS (USER_no,user_id, user_pw, user_name) VALUES (SEQ_USER_NO.NEXTVAL,'choi05', 'pw05', '최진우')

        try {
        		
             pstmt = conn.prepareStatement(sql);
            
             pstmt.setString(1, user.getUserId());
             pstmt.setString(2, user.getUserPw());
             pstmt.setString(3, user.getUserName());
            
             result = pstmt.executeUpdate();
        }
        finally {
        	close(rs);
 	        close(pstmt);
		}
        return result;
    }
}
