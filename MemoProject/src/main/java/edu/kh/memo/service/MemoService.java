package edu.kh.memo.service;

import edu.kh.memo.dto.Memo;

public interface MemoService {

	/**메모 상세 조회 서비스
	 * @param memoNo
	 * @returnnull 또는 Memo 객체
	 * @throws Exception
	 * @author 호연
	 */
	Memo memoDetail(int memoNo) throws Exception;


}
