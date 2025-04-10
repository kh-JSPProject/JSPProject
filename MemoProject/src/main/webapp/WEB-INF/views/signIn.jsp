<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link rel="stylesheet" href="/resources/css/signIn.css">
</head>
<body>
    <h1>로그인</h1>
    
    <c:if test="${not empty sessionScope.signUpMessage}">
        <script>
            alert("${sessionScope.signUpMessage}");
        </script>
    </c:if>
    <c:remove var="signUpMessage" scope="session"></c:remove>
    
    <c:if test="${not empty requestScope.errorMessage}">
        <script>
            alert("${requestScope.errorMessage}");
        </script>
    </c:if>
    
    <!-- 로그인된 사용자 정보 출력 부분 제거 -->
    <!-- <c:out value="${loginMember.userName}" /> -->
    
    <form action="/signin" method="post">
        아이디: <input type="text" name="userId" class="userId" required><br>
        <hr>
        비밀번호: <input type="password" name="userPw" class="userPw" required><br>
        <hr>
        <button type="submit" class="loginBtn"> login </button>
    </form>
    
    <form action="/signup" method="get">
        <h2>계정이 없으시다면? </h2>
        <h3>지금 당장 회원가입 하세요</h3>
        <button class="signUpBtn" type="submit"> 회원가입</button>
    </form>
    
    <script src="/resources/js/signIn.js"></script>
</body>
</html>
