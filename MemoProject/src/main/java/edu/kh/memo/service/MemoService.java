package edu.kh.memo.service;

import edu.kh.memo.dto.User;

public interface MemoService {

	
	/** juwon
	 * 아이디와 비밀번호를 주고 db에서 올라온 정보와 같은지 체크한 뒤 로그인에 성공하면 db로부터 온 정보를 반환하는 메서드
	 * @param userId
	 * @param userPw
	 * @return 유저 정보 객체
	 * @throws Exception
	 */
	User memoLogin(String userId, String userPw) throws Exception;
   
    /** juwon
     * @param user
     * @return 아이디 일치 여부만 검사해서 성공, 실패만 반환하는 메서드
     * @throws Exception
     */
    boolean signUp(User user) throws Exception;

    


}
