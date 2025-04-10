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

@WebServlet("/memo/update")
public class UpdateServlet extends HttpServlet {
	
	private MemoService service = new MemoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {			
			int memoNo = Integer.parseInt(req.getParameter("memoNo"));
			
			Memo memo = service.memoDetail(memoNo);
			
			req.setAttribute("memo", memo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int memoNo = Integer.parseInt(req.getParameter("memoNo"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
