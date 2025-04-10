package edu.kh.memo.service;

import java.sql.Connection;

import edu.kh.memo.controller.MemoService;

public class MemoServiceImpl implements MemoService {

	

	@Override
	public int memoCreate(String title, String content) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.memoCreate(conn,title,content);
		
		
		//DML은 트랜잭션 처리 필수!
		if(result>0)commit(conn);
		else		rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	
	
	@Override
	public int memoDelete(int memoNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.memoDelete(conn,memoNo);
		
		//DML은 트랜잭션 처리 필수!
		if(result>0) commit(conn);
		else 		 rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
	
}
