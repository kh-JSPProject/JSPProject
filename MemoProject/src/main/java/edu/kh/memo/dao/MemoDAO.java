package edu.kh.memo.dao;

import java.sql.Connection;
import java.util.List;

import edu.kh.memo.dto.Memo;
import edu.kh.memo.dto.User;

public interface MemoDAO {

    /** 아이디로 회원 조회 */
    User selectUserById(String userId, Connection conn) throws Exception;

    /** 회원 가입 (유저 삽입) */
    int insertUser(User user, Connection conn) throws Exception;

    /** 회원 조회 (Properties SQL 기반) */
    User userSelect(Connection conn, String userId) throws Exception;

    /** 특정 유저의 메모 리스트 조회 */
    List<Memo> memoListSelect(Connection conn, String userId) throws Exception;
}
