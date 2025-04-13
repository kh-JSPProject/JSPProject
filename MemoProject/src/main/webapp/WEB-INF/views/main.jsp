<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% long now = System.currentTimeMillis(); %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>${loginMember.userName}님의 메모</title>
	<link rel="stylesheet" href="/resources/css/main.css?ver=<%=now%>">
	<link rel="stylesheet" href="/resources/css/default.css">
</head>

<body>
	<div id="header">
		<div class="home btn left">
			<a href="/main" class="btn">HOME</a>
		</div>

		<div class="right">
			<div class="userInfo">
				<p>${loginMember.userName}님</p>
			</div>
			<button type="button" class="signOut btn" id="logout">로그아웃</button>
		</div>
	</div>

	<div id="menu">
		<div class="left">
			<h2 class="neon-title">메모 목록</h2>
		</div>

		<div class="create btn right">
			<a href="/memo/create" class="btn create">메모 작성하기</a>
		</div>
	</div>

	<div id="container">
		<div class="memo-count">총 메모 : ${fn:length(memoList)}개</div>

		<c:forEach items="${memoList}" var="memo" varStatus="vs">
			<div class="memo item">
				<a href="/memo/detail?memoNo=${memo.memoNo}">
					<div class="memo title">${memo.title}</div>
					<div class="memo info">
						<span class="memo userName">${loginMember.userName}</span> 
						<span class="memo editDate">${memo.updateDate}</span>
					</div>
					<div class="memo content">
						<c:out value="${memo.content}" escapeXml="false" />
					</div>
				</a>
			</div>
		</c:forEach>
	</div>

	<c:if test="${not empty sessionScope.message}">
		<script>
			alert('${sessionScope.message}');
		</script>
		<c:remove var="message" scope="session" />
	</c:if>

	<script src="/resources/js/main.js"></script>
</body>
</html>
