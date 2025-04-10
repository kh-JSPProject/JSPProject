package edu.kh.memo.dao;

import java.sql.Connection;

import edu.kh.memo.dto.User;

public interface MemoDAO {

	User selectUserById(String userId,  Connection conn) throws Exception;

	int insertUser(User user, Connection conn) throws Exception;
}
