<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="ko">
    
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>EDIT ${memo.title}</title>
        <link href="/resources/css/update2.css" rel="stylesheet">
        <link href="/resources/css/default.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/ca7ab47691.js" crossorigin="anonymous"></script>
    </head>
    
    <body>
        <div id="header">
            <div class="left">
                <div class="home btn">
                    <a href="/memo/detail?memoNo=${param.memoNo}">
                        <i class="fa-solid fa-chevron-left"></i>
                    </a>
                </div>
            </div>
    
            <div class="mid">
                <p>수정 페이지</p>
            </div>
    
            <div class="right"></div>
        </div>
        
        <div id="container">
            <form action="/memo/update" method="post" id="formUpdate">
            	<input type="hidden" name="memoNo" value="${param.memoNo}">
            	<input type="hidden" name="updateDate" class="updateDate">
            
                <div class="lable">
                    <p>제목</p>
                </div>
                <input class="memo title" name="title" value="${memo.title}" required placeholder="제목을 입력하세요.">
    
                <div class="lable">
                    <p>내용</p>
                </div>
                <textarea class="memo content" name="content" required placeholder="내용을 입력하세요">${memo.content}</textarea>
    
                <div class="tools">
                    <button type="submit" class="update btn">수정 완료</button>
                </div>
            </form>
        </div>
    
        <div id="footer"></div>
        <script src="/resources/js/update.js"></script>
    </body>
    
    </html>