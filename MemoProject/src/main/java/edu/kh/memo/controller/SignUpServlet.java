package edu.kh.memo.controller;

import java.io.IOException;

import edu.kh.memo.dto.User;
import edu.kh.memo.service.MemoService;
import edu.kh.memo.service.MemoServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.*;
import edu.kh.memo.dto.User;


@WebServlet("/signup")
// 사인업 JSP로 보낼 때 
public class SignUpServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher= req.getRequestDispatcher("WEB-INF/views/signUp.jsp");
		dispatcher.forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		String userName = req.getParameter("userId");
		
		User user = null;
		user = User.builder().userId(userId)
				.userName(userName)
				.userPw(userPw)
				.build();
		
		 boolean signup = false;

			try {
				
				
				MemoService service = new MemoServiceImpl();
				signup = service.signUp(user);
				HttpSession session = req.getSession();		
				String singUpMessage = "회원가입이 완료되셨습니다..";
				String errorMessage = "회원가입에 실패하셨습니다. 아이디와 비밀번호를 다시 입력해주세요";
				session.setAttribute("loginMember", signup);
				session.setAttribute("user", user);
				if(signup) {
					session.setAttribute("logInmessage", singUpMessage);
					resp.sendRedirect("/signin");
				}		
				else {
					 req.setAttribute("errorMessage", errorMessage);
					    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUp.jsp");
					    dispatcher.forward(req, resp);
				}			
			} 
			
			catch (Exception e) {
				e.printStackTrace();
			}
			
		
		
	}
	
	
	
	
	

}

































/*
 *  private UserService service = new UserService();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userId   = request.getParameter("userId");
        String userPw   = request.getParameter("userPw");
        String userName = request.getParameter("userName");

        // 3) User 객체 생성 후, 받은 파라미터를 세팅
        User user = new User();
        user.setUserId(userId);
        user.setUserPw(userPw);
        user.setUserName(userName);

        boolean signUpResult = false;

        try {
            // 4) 서비스 레이어를 통해 회원가입 시도
            signUpResult = service.signUp(user);
        } catch (Exception e) {
            e.printStackTrace();
            // 예외 발생 시 로그를 남기고, 가입 실패 처리
        }

        // 5) 가입 성공 여부에 따라 페이지 이동
        if (signUpResult) {
            // 성공: 로그인 페이지로 리다이렉트
            // (이미 있는 signIn.jsp 로 이동)
            response.sendRedirect(request.getContextPath() + "/signin");
        } else {
            // 실패: 다시 회원가입 페이지로 돌아감 (forward)
            request.setAttribute("errorMessage", "회원가입에 실패했습니다. 다시 시도해주세요.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/signUp.jsp");
            dispatcher.forward(request, response);
        }
    }
 * */
