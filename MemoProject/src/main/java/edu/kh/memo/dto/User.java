package edu.kh.memo.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
}
