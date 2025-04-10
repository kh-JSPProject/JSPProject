<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>${loginMember.userName}님의 메모</title>
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
				<p>${loginMember.userName}</p>
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
		<c:forEach items="${memoList}" var="memo" varStatus="vs">
			<div class="memo item">
				<a href="/memo/detail?memoNo=${memo.memoNo}">
					<div class="memo title">${memo.title}</div>
					<div class="memo info">
						<span class="memo userName">${loginMember.userName}</span>
						<span class="memo editDate">${memo.updateDate}</span>
					</div>
					<div class="memo content">${memo.content}</div>
				</a>
			</div>
		</c:forEach>
	</div>


	
		<c:if test="${not empty sessionScope.message}">
		<script>
    		alert("<c:out value='${sessionScope.message}' escapeXml='false'/>");
		</script>

		
		<%--message를 한번만 출력하고 제거 --%>
		<c:remove var="message" scope="session"/>
	</c:if>

<!-- JS 파일 연결 -->
<script src="/resources/js/main.js"></script>

<c:if test="${not empty sessionScope.message}">
  <script>
    alert("<c:out value='${sessionScope.message}' escapeXml='false'/>");
  </script>
  <c:remove var="message" scope="session"/>
</c:if>
</body>
</html>
