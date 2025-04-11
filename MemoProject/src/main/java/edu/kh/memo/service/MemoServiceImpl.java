package edu.kh.memo.service;

import static edu.kh.memo.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.memo.dao.MemoDAO;
import edu.kh.memo.dao.MemoDAOImpl;
import edu.kh.memo.dto.Memo;
import edu.kh.memo.dto.User;

public class MemoServiceImpl implements MemoService {
	
	private MemoDAO dao = new MemoDAOImpl();
	
	/** 로그인 서비스 */
	@Override
	public User memoLogin(String userId, String userPw) throws Exception {
		Connection conn = getConnection();
		
		User daoUser = dao.userSelect(conn, userId);
		
		close(conn);
		
		if(daoUser == null) return null;
		
		if(userId.equals(daoUser.getUserId()) && userPw.equals(daoUser.getUserPw())) {
			return daoUser;
		}
		
		return null;
	}

	/** 회원 가입 서비스 */
	@Override
	public boolean signUp(User user) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.insertUser(user, conn);
		
		if(result > 0) {
			commit(conn);
			close(conn);
			return true;
		} else {
			rollback(conn);
			close(conn);
			return false;
		}
	}

	/** 유저 조회 */
	@Override
	public User userSelect(String userId) throws Exception {
		Connection conn = getConnection();
		
		User user = dao.userSelect(conn, userId);
		
		close(conn);
		
		return user;
	}

	/** 메모 리스트 조회 */
	@Override
	public List<Memo> memoListSelect(String userId) throws Exception {
		Connection conn = getConnection();
		
		List<Memo> memoList = dao.memoListSelect(conn, userId);
		
		close(conn);
		
		return memoList;
	}
	
	/** 메모 상세 조회 */
	@Override
	public Memo memoDetail(int memoNo) throws Exception {
		Connection conn = getConnection();
		
		Memo memo = dao.memoDetail(conn, memoNo);
		
		close(conn);
		
		return memo;
	}
	
	/** 메모 추가 서비스 */
	@Override
	public int memoCreate(int userNo,String title, String content) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.memoCreate(conn,userNo,title, content);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 메모 삭제 서비스 */
	@Override
	public int memoDelete(int memoNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.memoDelete(conn, memoNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 메모 수정 서비스 */
	@Override
	public int memoUpdate(int memoNo, String title, String content, String updateDate) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.memoUpdate(conn, memoNo, title, content, updateDate);
		
		if(result>0) commit(conn);
		else 		 rollback(conn);
		
		close(conn);
				
		return result;
	}
}
