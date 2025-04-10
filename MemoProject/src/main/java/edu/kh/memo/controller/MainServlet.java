package edu.kh.memo.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // (선택) 로그인 여부 확인 (세션에 loginMember 있는지 검사)
        // 없다면 resp.sendRedirect("/signin") 등

        // main.jsp로 forward
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main.jsp");
        dispatcher.forward(req, resp);
    }
}