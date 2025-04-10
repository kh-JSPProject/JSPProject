package edu.kh.memo.controller;

import java.io.IOException;

import edu.kh.memo.service.MemoService;
import edu.kh.memo.service.MemoServiceImpl;
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
					
					MemoService service = new MemoServiceImpl();
					
					
					//2. 요청시에 전달 받은 파라미터 데이터 얻어오기
					String title = req.getParameter("title");
					String content = req.getParameter("content");
					
					
					//3.서비스 호출 후 결과 반환
					int result = service.memoCreate(title,content);
					
					//4.성공/실패 메시지 세팅하기
					String message = null;
					
					if(result> 0) message = "메모 추가 성공!";
					else 		  message = "메모 추가 실패...";
					
					//5.기존 req를 사용할 수 없기 때문에 
					//session 을 이용해서 message를 세팅
					HttpSession session = req.getSession();
					session.setAttribute("message", message);
					
					
					//6.메인페이지로 rediredct(재요청)
					//forward가 아님!!!
					
					resp.sendRedirect("/");
					//-> "/" 최상위 경로로 재요청을 보냄.
					//우리는 /main임
					//-> "/" 처리하는 Servlet이 재요청됨.
					//->"/"-> "/main"(GET방식 오버라이딩 하고있어야 리다이렉트:get방식)
					//redirect는 무조건 get방식!!!
					
				}catch(Exception e){
					e.printStackTrace();
				}
	}
}
