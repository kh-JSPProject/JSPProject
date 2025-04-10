package edu.kh.memo.service;

import java.sql.Connection;

import static edu.kh.memo.common.JDBCTemplate.*;
import edu.kh.memo.dto.Memo;

public class MemoServiceImpl implements MemoService{

	private MemoDAO dao = new MemoDAOImpl();
	
	@Override
	public Memo memoDetail(int memoNo) throws Exception {
		
		Connection conn = getConnection();
		
		
		
		return null;
	}


	
}
