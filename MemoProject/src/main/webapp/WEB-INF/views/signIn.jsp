<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="ko">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>로그인</title>

            <link rel="stylesheet" href="/resources/css/default.css">
            <% long now=System.currentTimeMillis(); %>
                <link rel="stylesheet" href="/resources/css/signin2.css?ver=<%=now%>">
        </head>

        <body>
            <c:remove var="loginMember" scope="session" />

            <div class="wrap">
                <div class="slogan">
                    <p>ONLINE MEMO WEBAPP</p>
                </div>

                <div id="container">
                    <div class="loginContainer">
                        <h1>LOGIN</h1>

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

                        <form action="/signin" method="post" class="loginForm">
                            <div class="formRow">
                                <label for="userId">아이디</label>
                                <input type="text" name="userId" id="userId" class="userInput" required>
                            </div>

                            <div class="formRow">
                                <label for="userPw">비밀번호</label>
                                <input type="password" name="userPw" id="userPw" class="userInput" required>
                            </div>

                            <div class="btn-container">
                                <button class="signUpBtn" type="button">회원가입</button>
                                <button type="submit" class="loginBtn">로그인</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- 알림 스크립트 -->
            <c:if test="${not empty sessionScope.message}">
                <script>
                    alert('${sessionScope.message}');
                </script>
                <c:remove var="message" scope="session" />
            </c:if>

            <script src="/resources/js/main.js"></script>
            <script src="/resources/js/signIn.js"></script>
        </body>

        </html>