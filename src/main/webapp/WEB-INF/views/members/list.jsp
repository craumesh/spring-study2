<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table border="1">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>이메일</td>
			<td>회원가입일</td>
			<td>최종수정일</td>			
		</tr>	
		<c:forEach var="member" items="${memberVOList }">
			<tr>
				<td>${member.getUserid() }</td>
				<td>${member.getUserpw() }</td>
				<td>${member.getUsername() }</td>
				<td>${member.getUseremail() }</td>
				<td>${member.getRegdate() }</td>
				<td>${member.getUpdatedate() }</td>			
			</tr>	
		</c:forEach>
		</table>	
	</div>
</body>
</html>