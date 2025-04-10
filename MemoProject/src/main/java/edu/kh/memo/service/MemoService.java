package edu.kh.memo.service;

import java.util.List;

import edu.kh.memo.dto.Memo;
import edu.kh.memo.dto.User;

public interface MemoService {

	/** User 객체 조회
	 * @param userId
	 * @return User user
	 * @throws Exception
	 * @author jaeho
	 */
	User userSelect(String userId) throws Exception;

	/** List<Memo> 객체 조회
	 * @param userId
	 * @return List<Memo> memoList
	 * @throws Exception
	 * @author jaeho
	 */
	List<Memo> memoListSelect(String userId) throws Exception ;
	

}
