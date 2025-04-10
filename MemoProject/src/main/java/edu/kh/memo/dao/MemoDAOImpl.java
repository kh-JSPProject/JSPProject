package edu.kh.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static edu.kh.memo.common.JDBCTemplate.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

import edu.kh.memo.dto.Memo;
import edu.kh.memo.dto.User;

public class MemoDAOImpl implements MemoDAO {

    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private Properties prop;

    public MemoDAOImpl() {
        try {
            String filePath = MemoDAOImpl.class.getResource("/xml/sql.xml").toURI().getPath();
            prop = new Properties();
            prop.loadFromXML(new FileInputStream(filePath));
        } catch (IOException e) {
            System.out.println("sql.xml 로드 중 예외 발생");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** 유저 조회 */
    @Override
    public User userSelect(Connection conn, String userId) throws Exception {
        User user = null;

        try {
            String sql = prop.getProperty("userSelect");
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
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

    /** 메모 리스트 조회 */
    @Override
    public List<Memo> memoListSelect(Connection conn, String userId) throws Exception {
        List<Memo> memoList = new ArrayList<>();

        try {
            String sql = prop.getProperty("memoListSelect");

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Memo memo = Memo.builder()
                        .memoNo(rs.getInt("memo_no"))
                        .userNo(rs.getInt("user_no"))
                        .title(rs.getString("title"))
                        .content(rs.getString("content"))
                        .regDate(rs.getString("req_date"))
                        .updateDate(rs.getString("update_date"))
                        .build();

                memoList.add(memo);
            }
        } finally {
            close(rs);
            close(pstmt);
        }
        return memoList;
    }

    /** 회원 가입 */
    @Override
    public int insertUser(User user, Connection conn) throws Exception {
        int result = 0;
        String sql = "INSERT INTO TB_USERS (USER_NO, USER_ID, USER_PW, USER_NAME) "
                   + "VALUES (SEQ_USER_NO.NEXTVAL, ?, ?, ?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserPw());
            pstmt.setString(3, user.getUserName());

            result = pstmt.executeUpdate();
        } finally {
            close(pstmt);
        }
        return result;
    }

    /** 메모 작성 */
    @Override
    public int memoCreate(Connection conn, String title, String content) throws Exception {
        int result = 0;

        try {
            String sql = prop.getProperty("memoCreate");
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, title);
            pstmt.setString(2, content); // 여기 오타 수정함(detail ➔ content)

            result = pstmt.executeUpdate();
        } finally {
            close(pstmt);
        }

        return result;
    }

    /** 메모 삭제 */
    @Override
    public int memoDelete(Connection conn, int memoNo) throws Exception {
        int result = 0;

        try {
            String sql = prop.getProperty("memoDelete");
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, memoNo);

            result = pstmt.executeUpdate();
        } finally {
            close(pstmt);
        }

        return result;
    }

	@Override
	public Memo memoDetail(Connection conn, int memoNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
