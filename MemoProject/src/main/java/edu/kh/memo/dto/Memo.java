package edu.kh.memo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Memo {
	private int memoNo;
	private int userNo;
	private String title;
	private String content;
	private String regDate;
	private String updateDate;
}
