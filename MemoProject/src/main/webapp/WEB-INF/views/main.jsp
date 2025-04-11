<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- 현재 시간 기반 캐시 제거용 변수 선언 --%>
<%
    long now = System.currentTimeMillis();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>${loginMember.userName}님의 메모</title>
	<!-- CSS 파일 연결  변경 now라는 현재시간을 담은 위에서 소환한 변수를 기준으로 다시 로드하는 것
	 그러면 이전에 캐시에 남아있던 css설정이 초기화되며 
	 이전과 같이 다시 로그인했을 때 이상한 css가 적용되던걸 방지할 수 있음
	-->
	<link rel="stylesheet" href="/resources/css/main.css?ver=<%=now%>">
</head>

<body>
	<div id="header">
		<div class="home btn left">
			<a href="/main" class="btn">HOME</a>
		</div>

		<div class="right">
			<div class="userInfo">
				<p>${loginMember.userName} 님 </p>
			</div>
			<button type="button" class="signOut btn">로그아웃</button>
		</div>
	</div>

	<div id="menu">
		<div class="left">
			<p><h2 class="neon-title">메모 목록</h2>
			</p>
		</div>

		<div class="create btn right">
			<a href="/memo/create"  class="btn neon-title">메모 작성하기</a>
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

	<div>
		<c:if test="${not empty sessionScope.message}">
			<script>
				alert('${sessionScope.message}');
			</script>
			<c:remove var="message" scope="session" />
		</c:if>
	</div>

	<script src="/resources/js/main.js"></script>
</body>
</html>
