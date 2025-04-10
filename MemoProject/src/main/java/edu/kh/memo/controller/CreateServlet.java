package edu.kh.memo.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/memo/create")
public class CreateServlet extends HttpServlet{

	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	String title = req.getParameter("title");
	
	String detail = req.getParameter("content");
	
	
	
	String sql = "";
	
	
	}
}
