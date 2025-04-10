package edu.kh.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static edu.kh.memo.common.JDBCTemplate.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

import edu.kh.memo.dto.Memo;
import edu.kh.memo.dto.User;

public class MemoDAOImpl implements MemoDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
  
  	public MemoDAOImpl() {
      
		try {
			String filePath = MemoDAOImpl.class.getResource("/xml/sql.xml").getPath();
			
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			System.out.println("sql.xml 로드 중 예외 발생");
			e.printStackTrace();
		}
	}

	@Override
	public User userSelect(Connection conn, String userId) throws Exception {

		User user = null;
		
		try {
			
			String sql = prop.getProperty("userSelect");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int userNo = rs.getInt("user_no");
				String userPw = rs.getString("user_pw");
				String userName = rs.getString("user_name");
				
				user = User.builder()
						.userNo(userNo)
						.userId(userId)
						.userPw(userPw)
						.userName(userName)
						.build();
			}	
		} finally {
			close(rs);
			close(pstmt);
		}
		return user;
	}

	@Override
	public List<Memo> memoListSelect(Connection conn, String userId) throws Exception {

		List<Memo> memoList = new ArrayList<Memo>();
		
		try {
			String sql = prop.getProperty("memoListSelect");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int memoNo = rs.getInt("memo_no");
				int userNo = rs.getInt("user_no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String reqDate = rs.getString("req_date");
				String updateDate = rs.getString("update_date");
				
				Memo memo = Memo.builder()
						.memoNo(memoNo)
						.userNo(userNo)
						.title(title)
						.content(content)
						.regDate(reqDate)
						.updateDate(updateDate)
						.build();
				
				memoList.add(memo); 
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return memoList;
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
 	        close(pstmt);
		}
        return result;
    }
}