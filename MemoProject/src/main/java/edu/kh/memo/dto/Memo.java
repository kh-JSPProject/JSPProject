package edu.kh.memo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Memo {
	private int memoNo;		// 메모 번호
	private int userNo;		// 유저 번호
	private String title;	// 제목
	private String content;	// 내용
	private String regDate;	// 작성 날짜
	private String updateDate; // 수정 날짜
}
