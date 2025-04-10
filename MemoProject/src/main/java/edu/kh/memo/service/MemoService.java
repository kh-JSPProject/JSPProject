package edu.kh.memo.service;

public interface MemoService {
	
	
	/** 메모 추가 서비스
	 * @param title
	 * @param content
	 * @return int 성공시 추가된 행의 개수 / 실패시 0 반환
	 * @throws Exception
	 * @author yoonjin
	 */
	int memoCreate(String title, String content) throws Exception;
	
	
	
	/** 메모 삭제 서비스
	 * @param memoNo
	 * @return int 행의 갯수
	 * @throws Exception
	 * @author yoonjin
	 */
	int memoDelete(int memoNo)throws Exception;
	
	
}
