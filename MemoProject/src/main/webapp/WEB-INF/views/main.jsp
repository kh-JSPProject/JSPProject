<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
		<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

			<% long now=System.currentTimeMillis(); %>

				<!DOCTYPE html>
				<html lang="ko">

				<head>
					<meta charset="UTF-8">
					<meta name="viewport" content="width=device-width, initial-scale=1.0">
					<title>${loginMember.userName}님의 메모</title>
					<link rel="stylesheet" href="/resources/css/main.css?ver=<%=now%>">
					<link rel="stylesheet" href="/resources/css/default.css">
					<script src="https://kit.fontawesome.com/ca7ab47691.js" crossorigin="anonymous"></script>
				</head>

				<body>
					<div id="header">
						<div class="home btn left">
							<a href="/main" class="btn">HOME</a>
						</div>

						<div class="mid">
							<input type="text" id="searchInput">
							<i class="fa-solid fa-magnifying-glass"></i>
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
							<p class="memo-count">총 메모 : ${fn:length(memoList)}개</p>
						</div>

						<div class="create btn right">
							<a href="/memo/create" class="btn create">메모 작성하기</a>
						</div>
					</div>

					<div class="tools">
						<div class="toggle-box">
							<div class="toggle-input">
								<input type="radio" name="sort" value="col" checked>
								<input type="radio" name="sort" value="row">
							</div>
							<div class="toggle-img">
								<img src="/resources/img/sort-c-f.png" class="toggle left icon">
								<img src="/resources/img/sort-r.png" class="toggle right icon">
							</div>
							<div class="toggle-bar"></div>
						</div>

						<div class="sort-select">
							<select name="sort" id="orderSelect">
								<option value="desc">최신순</option>
								<option value="asc">오래된순</option>
							</select>
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
									<div class="memo content">
										<p>
											<c:out value="${memo.content}" escapeXml="false" />
										</p>
									</div>
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