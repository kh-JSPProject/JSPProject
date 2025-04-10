package edu.kh.memo.service;
import java.sql.Connection;

import edu.kh.memo.dao.MemoDAO;
import edu.kh.memo.dao.MemoDAOImpl;
import edu.kh.memo.dto.User;
import static edu.kh.memo.common.JDBCTemplate.*;


public class MemoServiceImpl implements MemoService {
	Connection conn = getConnection();
    private MemoDAO dao  = new MemoDAOImpl();

    
    
    
    @Override
    public User memoLogin(String userId, String userPw) throws Exception {
       
    
        User daoUser = dao.selectUserById(userId, conn);
        
        if(daoUser==null) return null;
        if(userId.equals(daoUser.getUserId()) && userPw.equals(daoUser.getUserPw())) {
            return daoUser;
        }
        return null;
    }

    
    @Override
    public boolean signUp(User user) throws Exception {
        // 이미 해당 ID가 존재하는가?

    	int result = dao.insertUser(user, conn);
    	if(result>0) {commit(conn); return true;}
    	
    	else {rollback(conn); return false;}
    	
    }



	
	

}
