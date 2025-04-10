<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>회원가입</title>
            </head>

            <body>
                <h1>회원가입페이지에 오신것을 환영합니다</h1>
                <h1>회원가입</h1>
                <c:if test="${not empty requestScope.errorMessage}">
                    <script>
                        alert("${requestScope.errorMessage}");
                    </script>
                </c:if>

                <form action="/signup" method="post">
                    이름: <input type="text" name="userName" class="userName" required><br>
                    아이디: <input type="text" name="userId" class="userId" required><br>
                    <hr>
                    비밀번호: <input type="password" name="userPw" class="userPw" required><br>
                    <hr>
                    비밀번호 확인: <input type="password" name="userPwCheck" class="userPwCheck" required><br>

                    <hr>


                    
                    <c:if test="${not empty sessionScope.PWEqualsError}">
                        <script>
                            alert("${sessionScope.PWEqualsError}");
                        </script>
                    </c:if>
                    <c:remove var="PWEqualsError" scope="session"></c:remove>





                    <c:if test="${not empty sessionScope.REGError}">
                        <script>
                            alert("${sessionScope.REGError}");
                        </script>
                    </c:if>
                    <c:remove var="REGError" scope="session"></c:remove>





                    <c:if test="${not empty sessionScope.existError}">
                        <script>
                            alert("${sessionScope.existError}");
                        </script>
                    </c:if>
                    <c:remove var="existError" scope="session"></c:remove>






                    <c:if test="${not empty sessionScope.spaceError}">
                        <script>
                            alert("${sessionScope.spaceError}");
                        </script>
                    </c:if>
                    <c:remove var="spaceError" scope="session"></c:remove>




                    <c:if test="${not empty sessionScope.signUpMessage}">
                        <script>
                            alert("${sessionScope.signUpMessage}");
                        </script>
                    </c:if>
                    <c:remove var="signUpMessage" scope="session"></c:remove>





                    <button type="submit" class="singInBtn"> WELCOME!! </button>
                </form>


            </body>

            </html>