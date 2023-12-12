<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- http://localhost:8088/members/main -->
	<!-- 로그인 여부(세션정보)에 따라서 페이지 이동 -->
	<c:choose>
		<c:when test="${empty id}">
			<c:redirect url="/members/login"/>
		</c:when>
	</c:choose>
	
	<label><h1>로그인 계정 : ${id }</h1></label>
	<input type="button" value="로그아웃" onclick="location.href='/members/logout';">
	
	<hr>
	
	<h3><a href="/members/info">회원정보 조회</a></h3>
	
	<c:choose>
		<c:when test="${ !empty id && id.equals('admin') }">
			<h3><a href="/members/list">회원목록 조회</a></h3>
		</c:when>
	</c:choose>
</body>
</html>