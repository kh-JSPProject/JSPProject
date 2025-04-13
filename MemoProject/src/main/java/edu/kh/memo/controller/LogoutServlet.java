package edu.kh.memo.controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	 @Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	    try {
	    	HttpSession session = req.getSession();
	    	session.invalidate();
		 
		    resp.sendRedirect("/main"); // JSP 없이 바로 메인 이동
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 }
}