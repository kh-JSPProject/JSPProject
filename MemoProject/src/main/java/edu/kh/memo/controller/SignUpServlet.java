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
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/signUp.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		String userName = req.getParameter("userName");
		String userPwCheck = req.getParameter("userPwCheck");

		User user = null;
		user = User.builder().userId(userId).userName(userName).userPw(userPw).build();

		try {
			boolean signup = false;
			MemoService service = new MemoServiceImpl();

			String passwordRegex = "^(?=\\S{4,}).*$"; // 공백은 제외한 진짜 네자리의 문자, 숫자, 특수문자 중 아무거나 네자리면 됨
			
			if(!(userPw.equals(userPwCheck))) {
				session.setAttribute("PWEqualsError", "비밀번호와 비밀번호확인이 일치하지 않습니다");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUp.jsp");
				dispatcher.forward(req, resp);
				return;
			}

			else if ( userId.contains(" ") ) {
				session.setAttribute("spaceError", "아이디에 공백이 포함될 수 없습니다");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUp.jsp");
				dispatcher.forward(req, resp);
				return;
				
			}
			
			else if ( userName.contains(" ") ) {
				session.setAttribute("spaceError", "이름에 공백이 포함될 수 없습니다");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUp.jsp");
				dispatcher.forward(req, resp);
				return;
				
			}
		
			else if(!userPw.matches(passwordRegex)) {
				session.setAttribute("REGError", "비밀번호는 공백을 제외한 최소 4자리 이상이어야 합니다.");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUp.jsp");
				dispatcher.forward(req, resp);
				return;
			}

			User existingUser = service.userSelect(userId);
			
			if (existingUser != null) {
			    session.setAttribute("existError", "이미 존재하는 아이디입니다.");
			    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUp.jsp");
			    dispatcher.forward(req, resp);
			    return;
			}
			signup = service.signUp(user);
			
			if (signup) {
			    // 가입 성공: 환영 메시지 저장 후 로그인 페이지로 리다이렉트
			    session.setAttribute("signUpMessage", userName + "님 환영합니다!");
			    resp.sendRedirect("/signin");
			} else {
			    // 가입 실패: 에러 메시지 세팅하고 다시 회원가입 폼으로 이동
			    req.setAttribute("errorMessage", "회원가입 실패. 다시 시도해주세요.");
			    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUp.jsp");
			    dispatcher.forward(req, resp);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}