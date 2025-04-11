<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<!-- CSS 연결 -->
	<link rel="stylesheet" href="/resources/css/detail.css">
<title>${memo.title}</title>
</head>
<body>
	<%--<h1>${sessionScope.loginMember}</h1> --%>
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
	


	<h1>${memo.title}</h1>
	

	
	<div class="content">${memo.content}</div>
		
	<div class = "memo-info">
	작성자 : ${loginMember.userName}
	작성일 : ${memo.regDate} 
	수정일 : ${memo.updateDate}
	</div>
	
	
	<div>
	</div>
	
	
	<div class= "btn-container">
		<div>
			<button type="button" id="goMain">목록으로</button>
		</div>
		
		<div>
			<button id="updateBtn">수정</button>
			<button id="deleteBtn">삭제</button>
		</div>
	</div>
	
	<div class = "btn-next">
		<button>이전글</button>
		<button>다음글</button>
	</div>
	
		<%-- session 범위에 message가 있을 경우 --%>
	<c:if test="${not empty sessionScope.message}">
		<script>
			//JS 영역
			alert("${message}");
			// JSP 해석 순위
			// 1순위 : Java(EL/JSTL)
			// 2순위 : Front(HTML/CSS/JS)
		</script>
		
		<%--message를 한번만 출력하고 제거 --%>
		<c:remove var="message" scope="session"/>
	</c:if>

<%--자바 연결 --%>
<script src="/resources/js/detail.js"></script>
</body>
</html>