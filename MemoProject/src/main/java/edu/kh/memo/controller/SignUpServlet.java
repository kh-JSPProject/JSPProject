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
			
			
			
//			String passwordRegex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\r\n"
//					+ "\r\n"
//					+ "\\[\\]\r\n"
//					+ "\r\n"
//					+ "{};':\"\\\\|,.<>\\/?]).{8,}$";
		
			
			
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
			
			

			
		
//			else if(!userPw.matches(passwordRegex)) {
//				session.setAttribute("REGError", "최소 1개의 특수문자, 1개의 숫자, 그리고 영어(대소문자 무관)를 포함하는 비밀번호로 설정해주세요.");
//				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUp.jsp");
//				dispatcher.forward(req, resp);
//				return;
//			}
//			
			
			
			
			User existingUser = service.userSelect(userId);
			if (existingUser != null) {
			    session.setAttribute("existError", "이미 존재하는 아이디입니다.");
			    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUp.jsp");
			    dispatcher.forward(req, resp);
			    return;
			}
			
			
			
			signup = service.signUp(user);
//			if(signup) 				System.out.println("일단 true긴 함");

			
			if (signup) {
				// 성공 시: 세션에 환영 메시지 저장 후 로그인 페이지로 redirect
				String signUpMessage = userName + "님 환영합니다!";
				session.setAttribute("signUpMessage", signUpMessage);
				resp.sendRedirect("/signin");
			}
			
			

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

























//else {
//
//
//String errorMessage = "회원가입에 실패하셨습니다. 아이디와 비밀번호를 다시 입력해주세요";
//req.setAttribute("errorMessage", errorMessage);
//RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUp.jsp");
//dispatcher.forward(req, resp);
//return; // 여기서 종료
//}

//	if (signup) {
//	    // 1) 메시지 생성
//	    String signUpMessage = user.getUserName() + "님 환영합니다!";
//
//	    // 2) 세션에 메시지 저장
//	    session.setAttribute("signUpMessage", signUpMessage);
//
//	    // 3) 로그인 페이지로 리다이렉트
//	    resp.sendRedirect("/signin");
//
//	} else {
//		String errorMessage2 = "가입 실패!";
//	    req.setAttribute("errorMessage2", errorMessage2);
//	    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUp.jsp");
//	    dispatcher.forward(req, resp);
//	}
/*
 * private UserService service = new UserService();
 * 
 * 
 * @Override protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * 
 * String userId = request.getParameter("userId"); String userPw =
 * request.getParameter("userPw"); String userName =
 * request.getParameter("userName");
 * 
 * // 3) User 객체 생성 후, 받은 파라미터를 세팅 User user = new User();
 * user.setUserId(userId); user.setUserPw(userPw); user.setUserName(userName);
 * 
 * boolean signUpResult = false;
 * 
 * try { // 4) 서비스 레이어를 통해 회원가입 시도 signUpResult = service.signUp(user); } catch
 * (Exception e) { e.printStackTrace(); // 예외 발생 시 로그를 남기고, 가입 실패 처리 }
 * 
 * // 5) 가입 성공 여부에 따라 페이지 이동 if (signUpResult) { // 성공: 로그인 페이지로 리다이렉트 // (이미 있는
 * signIn.jsp 로 이동) response.sendRedirect(request.getContextPath() + "/signin");
 * } else { // 실패: 다시 회원가입 페이지로 돌아감 (forward)
 * request.setAttribute("errorMessage", "회원가입에 실패했습니다. 다시 시도해주세요.");
 * RequestDispatcher dispatcher =
 * request.getRequestDispatcher("/WEB-INF/views/signUp.jsp");
 * dispatcher.forward(request, response); } }
 */
