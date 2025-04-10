package edu.kh.memo.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.memo.dto.Memo;
import edu.kh.memo.dto.User;
import edu.kh.memo.service.MemoService;
import edu.kh.memo.service.MemoServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	private MemoService service = new MemoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            HttpSession session = req.getSession(false); // 세션 가져오기
            User loginMember = (session != null) ? (User) session.getAttribute("loginMember") : null;

            if (loginMember == null) {
                resp.sendRedirect("/signin"); // 로그인 안 한 경우 로그인 페이지로
                return;
            }

            String userId = loginMember.getUserId();

            // 메모리스트 조회
            List<Memo> memoList = service.memoListSelect(userId);

            // request에 세팅
            req.setAttribute("loginMember", loginMember); // userName도 포함되어 있음
            req.setAttribute("memoList", memoList);

            String path = "/WEB-INF/views/main.jsp";
            req.getRequestDispatcher(path).forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}