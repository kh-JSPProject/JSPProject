<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>${userName}님의 메모</title>
		<link href="/resources/css/main.css" rel="stylesheet">
	</head>
	<body>
		<div id="header">
			<div class="home btn left">
				<a href="/main">HOME</a>
			</div>
	
			<div class="right">
				<div class="userInfo">
					<p>${userName}</p>
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
					<div class="memo userName">${memo.userName}</div>
					<div class="memo editDate">${memo.updateDate}</div>
					<div class="memo content">${memo.content}</div>
				</a>
			</div>
		</c:forEach>
		</div>
	
		<div id="footer"></div>
		<script src="/resources/js/main.js"></script>
	</body>
	</html>