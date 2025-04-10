package edu.kh.memo.service;

import static edu.kh.memo.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.memo.dao.MemoDAO;
import edu.kh.memo.dao.MemoDAOImpl;
import edu.kh.memo.dto.Memo;
import edu.kh.memo.dto.User;

public class MemoServiceImpl implements MemoService {
	
	MemoDAO dao = new MemoDAOImpl();

	@Override
	public User userSelect(String userId) throws Exception {
		
		Connection conn = getConnection();
		
		User user = dao.userSelect(conn, userId);
		
		close(conn);
		
		return user;
	}

	@Override
	public List<Memo> memoListSelect(String userId) throws Exception {
		
		Connection conn = getConnection();
		
		List<Memo> memoList = dao.memoListSelect(conn, userId);
		
		close(conn);
		
		return memoList;
	}

}
