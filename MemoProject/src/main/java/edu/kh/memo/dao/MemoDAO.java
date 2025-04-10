package edu.kh.memo.dao;

import java.sql.Connection;
import java.util.List;

import edu.kh.memo.dto.Memo;
import edu.kh.memo.dto.User;

public interface MemoDAO {

	User userSelect(Connection conn, String userId) throws Exception;

	List<Memo> memoListSelect(Connection conn, String userId) throws Exception;

}
