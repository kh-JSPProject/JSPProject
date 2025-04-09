package edu.kh.memo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

	private int userNo;			//유저번호
	private String userId;		//유저아이디
	private String userPw;		//유저비밀번호
	private String userName;	//유저이름
}
