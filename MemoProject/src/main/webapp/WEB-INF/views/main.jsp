<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ONLINE MEMO APP</title>
<link href="/resources/css/main.css" rel="stylesheet">
</head>
<body>
    <div id="header">
		<div class="userInfo">
			<p>${sessionScope.userName}</p>
		</div>
		<button type="button" class="signOut" class="btn">SIGN OUT</button>
</div>

<div id="menu">
	<div class="home btn">
		<a href="/main">HOME</a>
	</div>

	<div class="create btn">
		<a href="/memo/create">CREATE MEMO</a>
	</div>
</div>

<div id="container">
	<div class="memo item">
		<a href="/memo/detail">
			<div class="memo title"></div>
			<div class="memo userName"></div>
			<div class="memo editDate"></div>
			<div class="memo content"></div>
		</a>
	</div>
</div>

	<script src="/resources/js/main.js"></script>
</body>
</html>