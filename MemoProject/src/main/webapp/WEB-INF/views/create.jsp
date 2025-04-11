<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<c:if test="${empty sessionScope.loginMember}">
  <c:redirect url="/signin"/>
</c:if>



<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>새 메모 작성</title>
    <link rel="stylesheet" href="/resources/css/create.css">
</head>
<body>

  <div id="pageWrapper">

   

    <!-- 홍길동님 인사말 -->
    <div class="welcomeText">
      ${sessionScope.loginMember.userName}님, CREATE NEW MEMO!
    </div>

    <!-- 메모 작성 폼 -->
    <form action="/memo/create" method="post" id="addForm" >
      <input type="text" name="title" placeholder="제목을 작성해주세요" >
      <textarea name="content" placeholder="내용을 작성해주세요" ></textarea>
      <button >새로운 메모 추가하기</button>
    </form>

  </div>

  <!-- 작성 성공/실패 alert -->
  <c:if test="${not empty sessionScope.message}">
    <script>
      alert("${sessionScope.message}");
    </script>
    <c:remove var="message" scope="session"/>
  </c:if>

</body>

</html>