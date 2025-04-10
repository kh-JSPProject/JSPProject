package edu.kh.memo.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.memo.dto.Memo;
import edu.kh.memo.dto.User;
import edu.kh.memo.service.MemoService;
import edu.kh.memo.service.MemoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemoService service = new MemoServiceImpl();
		
		String userName;
		String userId;
		List<Memo> memoList = null;
		
		try {
			
			HttpSession session = req.getSession();
			userId = session.getAttribute("userId");
			
			User user = service.userSelect(userId);
			userName = user.getUserName();
			req.setAttribute("userName", userName);
			
			memoList = service.memoListSelect(userId);
			req.setAttribute("memoList", memoList);
			
			String path = "/WEB-INF/views/main.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
