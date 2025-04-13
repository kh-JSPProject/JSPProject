<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/resources/css/detail2.css">
    <link rel="stylesheet" href="/resources/css/default.css">
    <title>${memo.title}</title>
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
            <button type="button" class="signOut btn" id="logout">로그아웃</button>
        </div>
    </div>

    <div class="memo-container">
        <div class="memo-header">
            <h1>${memo.title}</h1>
            <div>
                <button id="updateBtn">수정</button>
                <button id="deleteBtn">삭제</button>
            </div>
        </div>

        <div class="content">${memo.content}</div>

        <div class="memo-info">
            작성자 : ${loginMember.userName} 
            작성일 : ${memo.regDate} 
            수정일 : ${memo.updateDate}
        </div>
    </div>

    <div class="btn-container">
        <c:choose>
            <c:when test="${prevNo != -1}">
                <button onclick="location.href='/memo/detail?memoNo=${prevNo}'">이전글</button>
            </c:when>
            <c:otherwise>
                <button disabled>이전글</button>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${nextNo != -1}">
                <button onclick="location.href='/memo/detail?memoNo=${nextNo}'">다음글</button>
            </c:when>
            <c:otherwise>
                <button disabled>다음글</button>
            </c:otherwise>
        </c:choose>
    </div>

    <c:if test="${not empty sessionScope.message}">
        <script>
            alert("${sessionScope.message}");
        </script>
        <c:remove var="message" scope="session" />
    </c:if>

    <script src="/resources/js/detail.js"></script>
</body>
</html>
