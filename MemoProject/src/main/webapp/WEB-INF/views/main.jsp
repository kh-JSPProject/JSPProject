<%
    edu.kh.memo.dto.User loginUser = (edu.kh.memo.dto.User) session.getAttribute("loginMember");
    // 세션이 없거나, 로그인 정보가 없으면 리다이렉트 등 처리
    if(loginUser == null) {
        // 예: 로그인 페이지로 리다이렉트
        response.sendRedirect("/signin");
        return;
    }
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><%= ((edu.kh.memo.dto.User)session.getAttribute("loginMember")).getUserName() %>님의 메모</title>
<!-- CSS 파일 연결 (webapp 기준 경로 작성) -->
<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
	<div id="header">
		<div class="home btn left">
			<a href="/main">HOME</a>
		</div>
		<div class="right">
			<div class="userInfo">
				<p><%= ((edu.kh.memo.dto.User)session.getAttribute("loginMember")).getUserName() %></p>
			</div>
			<button type="button" class="signOut btn">로그아웃</button>
		</div>
	</div>

	<div id="menu">
		<div class="left">
			<p>메모</p>
		</div>
		<div class="create btn right">
			<a href="/memo/create">메모 작성하기</a>
		</div>
	</div>

	<div id="container">
        <% 
            // memoList는 request scope에 세팅된 List<Memo>라고 가정합니다.
            java.util.List memoList = (java.util.List) request.getAttribute("memoList");
            if(memoList != null) {
                for (Object obj : memoList) {
                    // Memo타입임을 가정
                    edu.kh.memo.dto.Memo memo = (edu.kh.memo.dto.Memo) obj;
        %>
			<div class="memo item">
				<a href="/memo/detail?memoNo=<%= memo.getMemoNo() %>">
					<div class="memo title"><%= memo.getTitle() %></div>
					<div class="memo info">
						<span class="memo userName"><%= ((edu.kh.memo.dto.User)session.getAttribute("loginMember")).getUserName() %></span>
                        <span class="memo editDate"><%= memo.getUpdateDate() %></span>
					</div>
					<div class="memo content"><%= memo.getContent() %></div>
				</a>
			</div>
	</div>

<div>
<c:if test="${not empty sessionScope.message}">
  <script>
    alert('${sessionScope.message}');
  </script>
  <c:remove var="message" scope="session"/>
</c:if>
</div>
<srcript src="/resouces/js/main.js"></srcript>
</body>
</html>
