ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER memo IDENTIFIED BY memo1234;

GRANT RESOURCE, CONNECT TO memo;

ALTER USER memo DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;

	select user_no, user_pw, user_name
	from tb_users;
	

SELECT memo_no, user_no, title, content, 
	to_char(reg_date,'YYYY-MM-DD HH:MI') reg_date, to_char(update_date,'YYYY-MM-DD HH:MI')
FROM tb_memos
WHERE user_no = (SELECT user_no
								 FROM TB_USERS
								 WHERE user_id = 'hong01');