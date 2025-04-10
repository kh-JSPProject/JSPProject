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
	private int memoNo;		//메모번호
	private int userNo;		//유저번호
	private String title;	//제목
	private String content;	//내용
	private String regDate;	//날짜
	private String updateDate; //업데이트 날짜
}
