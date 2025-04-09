package edu.kh.memo.dao;

import java.sql.Connection;

public interface MemoDAO {
	
	
	
	
	int memoDelete(Connection conn, int memoNo) throws Exception;
}
