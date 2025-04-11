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

@WebServlet("/memo/update")
public class UpdateServlet extends HttpServlet {
	
	private MemoService service = new MemoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {			
			int memoNo = Integer.parseInt(req.getParameter("memoNo"));
			
			Memo memo = service.memoDetail(memoNo);
			
			req.setAttribute("memo", memo);
			
			req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			int memoNo = Integer.parseInt(req.getParameter("memoNo"));
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String updateDate = req.getParameter("updateDate");
			
			int result = service.memoUpdate(memoNo, title, content, updateDate);
			
			String message = null;
			
			if(result> 0) message = "메모 수정 성공!";
			else 		  message = "메모 수정 실패...";
			
			session.setAttribute("message", message);
			
			resp.sendRedirect("/memo/detail?memoNo="+memoNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
