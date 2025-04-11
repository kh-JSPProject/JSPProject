<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="ko">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <!-- <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
            <meta http-equiv="Pragma" content="no-cache" />
            <meta http-equiv="Expires" content="0" /> -->
            <title>로그인</title>

            <!-- css나 js는 main에서의 내용이 바뀌면 이것도 바뀔 수 있기 때문에 확장성이 좋을듯 -->
            <link rel="stylesheet" href="/resources/css/main.css">
            <link rel="stylesheet" href="/resources/css/signIn.css">
        </head>
        <!-- 로그인 페이지에서는 항상 로그인이 안 된 상태이므로 별도의 로그인 상태 표시 없이 사용 -->

        <body>

            <!--  main.jsp의 헤더 영역을 그대로 가져옴.
        사용자 정보와 로그아웃 버튼은 없애고 만듦. -->
            <div id="header">
                <div class="home btn left">
                    <!-- home으로 가는 ahref에 .protectedLink를 해서 못하게 함  -->
                    <a href="/main" class="protectedLink">HOME</a>
                </div>
                <div class="right">
                    <!-- 사용자 정보와 로그아웃이 있었으나 이건 로그인 전이므로 무시-->
                </div>
            </div>

            <!-- 가짜 메뉴 영역을 배껴옴 
   클릭하면 먼저 로그인부터 시키려고 작동하지 않는 버튼을 보여주는 것
   대부분의 사이트가 다 이런듯-->

            <div id="menu">
                <div class="left">
                    <p>적어놓고 싶은 내용이 있으면 마음대로 적어라!!</p>
                    <p>안전한 무료 메모 웹사이트 MEMOAPP!!</p>
                </div>
                <div class="create btn right">
                    <a href="/memo/create" class="protectedLink">메모 작성하기</a>
                </div>
            </div>


            <!-- 여기서부터는 그냥 login내용 그대로임 -->
            <div id="container">
                <div class="loginContainer">
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

                    <form action="/signin" method="post">
                        아이디: <input type="text" name="userId" class="userId" required><br>
                        <hr>
                        비밀번호: <input type="password" name="userPw" class="userPw" required><br>
                        <hr>
                        <button type="submit" class="loginBtn">로그인</button>
                    </form>

                    <form action="/signup" method="get">
                        <h2>계정이 없으시다면?</h2>
                        <h3>지금 당장 회원가입 하세요</h3>
                        <button class="signUpBtn" type="submit">회원가입</button>
                    </form>
                </div>
            </div>

            <c:if test="${not empty sessionScope.message}">
                <script>
                    alert('${sessionScope.message}');
                </script>
                <c:remove var="message" scope="session" />
            </c:if>


            <!-- 여기까지는 그냥 login내용 그대로임 -->




            <!-- css나 js는 main에서의 내용이 바뀌면 이것도 바뀔 수 있기 때문에 확장성이 좋을듯 -->
            <script src="/resources/js/main.js"></script>
            <script src="/resources/js/signIn.js"></script>



        </body>

        </html>