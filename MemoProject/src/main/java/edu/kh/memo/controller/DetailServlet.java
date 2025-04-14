package edu.kh.memo.controller;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/memo/detail")
public class DetailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 할 일 상세 조회 요청 처리 Servlet
		try {
			// 세션 객체 생성
			HttpSession session = req.getSession();
			User loginMember = (session != null) ? (User) session.getAttribute("loginMember") : null;

			// 로그인 정보 세션이 말료 됫을때
			if (loginMember == null) {
				resp.sendRedirect("/main"); // 다시 메인으로 던져준다
				return;
			}

			String userName = loginMember.getUserName();

			// 서비스 객체 생성
			MemoService service = new MemoServiceImpl();

			// 요청시 전달받은 파라미터 얻어오기
			int memoNo = Integer.parseInt(req.getParameter("memoNo"));
			String content = req.getParameter("content");
			String title = req.getParameter("title");
			String regDage = req.getParameter("regDate");
			String updateDate = req.getParameter("updateDate");

			// 알맞은 서비스 호출 후 결과 반환받기
			Memo memo = service.memoDetail(memoNo);

			// MEMO_NO 컬럼값이 todoNo와 같은 memo 가
			// 있으면 해당 Memo 객체 반환
			// 없으면 null 반환

			// memo가 존재하지 않을 경우
			// ->메인페이지 redirect 후
			// "할일이 존재하지 않습니다" alert 출력
			if (memo == null) {

				// session 객체 생성 후 message 세팅하기
				session.setAttribute("message", "메모가 존재하지 않습니다.");

				resp.sendRedirect("/main");
				return;
			}

			List<Memo> memoList = service.memoListSelect(loginMember.getUserId());
			List<Integer> memoNoList = new ArrayList<>();
			for (Memo m : memoList) {
				memoNoList.add(m.getMemoNo());
			}

			// memoNoList는 내림차순
			int prevNo = -1;
			int nextNo = -1;

			// 현재 해당하는 번호가 몇번인가?
			for (int i = 0; i < memoNoList.size(); i++) {
				if (memoNoList.get(i) == memoNo) {
					if (i > 0) { // 이전 메모가 존재한다면, 즉 처음글이 아니어서 이전글을 클릭할 수 있을 때는
						nextNo = memoNoList.get(i - 1); // prevNo가 바뀌어야지
					}
					if (i < memoNoList.size() - 1) { // 만약 다음 메모도 존재한다면 다음글을 클릭할 수 있을 때는
						prevNo = memoNoList.get(i + 1); // nextNo가 바뀌어야지
					}
				}
			}

			// memo가 존재하는 경우
			// detail.jsp 로 forward로 응답
			req.setAttribute("memo", memo);
			req.setAttribute("content", content);
			req.setAttribute("title", title);
			req.setAttribute("regDate", regDage);
			req.setAttribute("updateDate", updateDate);
			req.setAttribute("memo", memo);

			// 이것도 같이 보내자
			req.setAttribute("prevNo", prevNo);
			req.setAttribute("nextNo", nextNo);

			String path = "/WEB-INF/views/detail.jsp";

			// 요청발송자 이용해서 요청 위임
			req.getRequestDispatcher(path).forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
