package edu.kh.memo.dao;

import static edu.kh.memo.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.memo.dto.Memo;
import edu.kh.memo.dto.User;

public class MemoDAOImpl implements MemoDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;

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

}
