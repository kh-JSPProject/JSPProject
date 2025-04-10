package edu.kh.memo.dao;

import java.sql.Connection;

public interface MemoDAO {
	
	int memoCreate(Connection conn, String title, String content) throws Exception;
	
	
	int memoDelete(Connection conn, int memoNo) throws Exception;
}
