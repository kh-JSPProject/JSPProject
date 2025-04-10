package edu.kh.memo.service;

import java.util.List;

import edu.kh.memo.dto.Memo;
import edu.kh.memo.dto.User;

public interface MemoService {
	
	/** 로그인 서비스
	 * @param userId
	 * @param userPw
	 * @return 유저 정보 객체
	 * @throws Exception
	 */
	User memoLogin(String userId, String userPw) throws Exception;
   
    /** 회원가입 서비스
     * @param user
     * @return 가입 성공 여부
     * @throws Exception
     */
    boolean signUp(User user) throws Exception;

	/** 유저 조회 서비스
	 * @param userId
	 * @return User 객체
	 * @throws Exception
	 */
	User userSelect(String userId) throws Exception;

	/** 메모 리스트 조회 서비스
	 * @param userId
	 * @return List<Memo>
	 * @throws Exception
	 */
	List<Memo> memoListSelect(String userId) throws Exception;
	
	/** 메모 상세 조회 서비스
	 * @param memoNo
	 * @return null 또는 Memo 객체
	 * @throws Exception
	 */
	Memo memoDetail(int memoNo) throws Exception;
}
