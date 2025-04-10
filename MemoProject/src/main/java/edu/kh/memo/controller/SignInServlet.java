package edu.kh.memo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import edu.kh.memo.dto.User;
import edu.kh.memo.service.MemoService;
import edu.kh.memo.service.MemoServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/signin")
public class SignInServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.removeAttribute("errorMessage");
	    req.getSession().removeAttribute("errorMessage");
		String path = "/WEB-INF/views/signIn.jsp";
		RequestDispatcher request =  req.getRequestDispatcher(path);
		request.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		
        User login = null;  

		try {
			// service 요청. 즉 userId와 userPw가 둘 다 일치하는 회원이 있는지 일단 DB에서 조회하게 됨 =>
			// 그에따른 결과를 반환받아 alert로 띄워주는 것이 로그인
			// 결과값을 반환하는 (User객체 & null)
			MemoService service = new MemoServiceImpl();
			login = service.memoLogin(userId, userPw);
		
			HttpSession session = req.getSession();
			// 세션 스코프에 로그인한 회원의 정보를 저장
			// 브라우저 종료 및 세션 만료 외에는 모든 페이지에서 로그인한 정보를 이용할 수 있게 함
			String loginMessage = "반갑습니다.";
			String errorMessage = "로그인에 실패하셨습니다. 아이디와 비밀번호를 다시 확인해주세요";
			session.setAttribute("loginMember", login); 
			
			// 로그인이 성공했는지 실패했는지 체크하는 memoCheck의 결과

			if(memoCheck(userId, userPw, login)) {
				// 그 함수의 결과가 참이면 인증에 성공했으니까 main으로 보낸다. loginMessage를 set으로 보내고 
				session.setAttribute("logInmessage", loginMessage);
				// 메시지를 단순히 반갑습니다만 전하고 user의 이름을 어차피 JSP에서 받을 예정이므로 JSP단에서 처리하기로 한다.
				
				resp.sendRedirect("/main");
				// 여기서는 진짜 main.jsp페이지로의 리다이렉트가 사용될 것

			}
			
			else {
				
				 req.setAttribute("errorMessage", errorMessage);
				    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signIn.jsp");
				    dispatcher.forward(req, resp);
					// 하지만 만약 실패했다면 errorMessage를 set으로 보내고 그냥 포워딩으로 
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	boolean memoCheck(String userId, String userPassword, User login) {
	if (login == null) {
		        return false; // login 객체가 없으면 바로 실패
		    }

	if( (userId.equals(login.getUserId())  
			&& userPassword.equals((login.getUserPw())))
	) 
		return true;

	else return false;

	}

}
