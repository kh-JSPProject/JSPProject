package edu.kh.memo.controller;

import java.io.IOException;

import edu.kh.memo.service.MemoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/memo/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//메모 제거
		try {
			
			//1.memoServiceImple객체 생성
			MemoService service = new MemoServiceImpl();

			// 2. 삭제할 할 일의 ID(번호) 파라미터로 받아오기
			int memoNo = Integer.parseInt(req.getParameter("memoNo"));
			
			// 3. 서비스 호출 후 결과 반환
			  int result = service.todoDelete(memoNo);
			//4.성공/실패 메시지 세팅하기
			 String message = null;
				
				if(result> 0) message = "메모 삭제 성공!";
				else 		  message = "메모 삭제 실패...(memo가 존재하지 않습니다)";
			
			 // 5. 세션에 메시지 저장
				 HttpSession session = req.getSession();
				session.setAttribute("message", message);
			
			//6.진짜 메인 말고 우리가 메인 페이지로 리다이렉트
				resp.sendRedirect("/main");
				
		} catch (Exception e) {
			e.printStackTrace();
			
		}	
	}
}
