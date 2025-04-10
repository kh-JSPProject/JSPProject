package edu.kh.memo.controller;

import java.io.IOException;

import edu.kh.memo.dto.Memo;
import edu.kh.memo.service.MemoService;
import edu.kh.memo.service.MemoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("detail")
public class DetailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				//할 일 상세 조회 요청 처리 Servlet
				try {
					
					//서비스 객체 생성
					MemoService service = new MemoServiceImpl();
					
					//요청시 전달받은 파라미터 얻어오기
					int memoNo = Integer.parseInt(req.getParameter("memoNo"));
					
					//알맞은 서비스 호출 후 결과 반환받기
					Memo memo = service.memoDetail(memoNo);
					// MEMO_NO 컬럼값이 todoNo와 같은 memo 가
					//있으면 해당 Memo 객체 반환
					//없으면 null 반환
					
					//memo가 존재하지 않을 경우
					//->메인페이지 redirect 후
					//"할일이 존재하지 않습니다" alert 출력
					if(memo ==null) {
	
						// session 객체 생성 후 message 세팅하기
						HttpSession session = req.getSession();
						session.setAttribute("message", "메모가 존재하지 않습니다.");
						
						resp.sendRedirect("/");
						return;
					}
					
					//memo가 존재하는 경우
					//detail.jsp 로 forward로 응답
					req.setAttribute("memo", memo);
					
					String path = "/WEB-INF/views/detail.jsp";
					
					//요청발송자 이용해서 요청 위임
					req.getRequestDispatcher(path).forward(req, resp);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
}
	