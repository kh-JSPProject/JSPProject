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


@WebServlet("/memo/create")
public class CreateServlet extends HttpServlet{


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

				try {
					
					
					// 1. 세션에서 로그인된 사용자 정보 가져오기
			        HttpSession session = req.getSession();
			        User loginMember = (User) session.getAttribute("loginMember");

			     // 로그인 안 되어 있으면 메인으로 리다이렉트
			        if (loginMember == null) {
			            session.setAttribute("message", "로그인 후 이용해주세요.");
			            resp.sendRedirect("/");
			            return;
			        }
					
					
			        int userNo = loginMember.getUserNo(); // 
			        
			        
					//2. 요청시에 전달 받은 파라미터 데이터 얻어오기
					String title = req.getParameter("title");
					String content = req.getParameter("content");
					
					
					
					  if (title == null || title.trim().isEmpty() ||
					            content == null || content.trim().isEmpty()) {

					            session.setAttribute("message", "제목과 내용을 모두 작성해주세요.");
					            resp.sendRedirect("/memo/create");
					            return;
					        }
					
					
					
					
					MemoService service = new MemoServiceImpl();
					int result = service.memoCreate(userNo,title,content);
					
					//4.성공/실패 메시지 세팅하기
					String message = null;
					
					if(result> 0) message = "메모 추가 성공!";
					else 		  message = "메모 추가 실패...";
					
					//5.기존 req를 사용할 수 없기 때문에 
					//session 을 이용해서 message를 세팅
					session.setAttribute("message", message);
					
					
			
					
					resp.sendRedirect("/main");
					
				}catch(Exception e){
					e.printStackTrace();
				}
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    HttpSession session = req.getSession();
	    User loginMember = (User) session.getAttribute("loginMember");

	    if (loginMember == null) {
	        // 로그인 안 된 경우, 메인으로 보내고 메시지 띄우기
	        session.setAttribute("message", "로그인 후 이용해주세요.");
	        resp.sendRedirect("/main");
	        return;
	    }

	    // 로그인 되어 있으면 작성 페이지로 포워딩
	    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/create.jsp");
	    dispatcher.forward(req, resp);
	}
}
