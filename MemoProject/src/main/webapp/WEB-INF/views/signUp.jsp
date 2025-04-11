<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" href="/resources/css/signUp.css">
</head>
<body>

    <div id="container">
        <div class="signUpContainer">
            <h1>SIGN UP</h1>

            <c:if test="${not empty requestScope.errorMessage}">
                <script>
                    alert("${requestScope.errorMessage}");
                </script>
            </c:if>

            <form action="/signup" method="post">

                <div class="formRow">
                    <label for="userName">이름</label>
                    <input type="text" name="userName" id="userName" required>
                </div>

                <div class="formRow">
                    <label for="userId">아이디</label>
                    <input type="text" name="userId" id="userId" required>
                </div>

                <div class="formRow">
                    <label for="userPw">비밀번호</label>
                    <input type="password" name="userPw" id="userPw" required>
                </div>

                <div class="formRow">
                    <label for="userPwCheck">비밀번호 확인</label>
                    <input type="password" name="userPwCheck" id="userPwCheck" required>
                </div>

                <!-- 오류 메시지 -->
                <c:if test="${not empty sessionScope.PWEqualsError}">
                    <script>alert("${sessionScope.PWEqualsError}");</script>
                </c:if>
                <c:remove var="PWEqualsError" scope="session"/>

                <c:if test="${not empty sessionScope.REGError}">
                    <script>alert("${sessionScope.REGError}");</script>
                </c:if>
                <c:remove var="REGError" scope="session"/>

                <c:if test="${not empty sessionScope.existError}">
                    <script>alert("${sessionScope.existError}");</script>
                </c:if>
                <c:remove var="existError" scope="session"/>

                <c:if test="${not empty sessionScope.spaceError}">
                    <script>alert("${sessionScope.spaceError}");</script>
                </c:if>
                <c:remove var="spaceError" scope="session"/>

                <c:if test="${not empty sessionScope.signUpMessage}">
                    <script>alert("${sessionScope.signUpMessage}");</script>
                </c:if>
                <c:remove var="signUpMessage" scope="session"/>

                <button type="submit" class="singInBtn">WELCOME!!</button>
            </form>
        </div>
    </div>

    <script src="/resources/js/signUp.js"></script>
</body>
</html>
