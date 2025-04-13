<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

      <!DOCTYPE html>
      <html lang="ko">

      <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>새 메모 작성</title>
        <link rel="stylesheet" href="/resources/css/default.css">
        <link rel="stylesheet" href="/resources/css/create2.css">
        <script src="https://kit.fontawesome.com/ca7ab47691.js" crossorigin="anonymous"></script>
      </head>

      <body>
        <c:if test="${empty sessionScope.loginMember}">
          <c:redirect url="/signin" />
        </c:if>

        <div id="header">
          <div class="left">
            <div class="home btn">
              <a href="/main">
                <i class="fa-solid fa-chevron-left"></i>
              </a>
            </div>
          </div>

          <div class="welcomeText">
            ${sessionScope.loginMember.userName}님, CREATE NEW MEMO!
          </div>

          <div class="right"></div>
        </div>

        <div id="pageWrapper">
          <!-- 메모 작성 폼 -->
          <form action="/memo/create" method="post" id="addForm">
            <input type="text" name="title" placeholder="제목을 작성해주세요">
            <textarea name="content" placeholder="내용을 작성해주세요"></textarea>
            <button>새로운 메모 추가하기</button>
          </form>
        </div>

        <div>
          <!-- 작성 성공/실패 alert -->
          <c:if test="${not empty sessionScope.message}">
            <script>
              alert("${sessionScope.message}");
            </script>
            <c:remove var="message" scope="session" />
          </c:if>
        </div>

      </body>

      </html>