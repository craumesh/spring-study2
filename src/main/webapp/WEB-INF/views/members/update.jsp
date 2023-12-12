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
		<label><h3>회원정보</h3></label>
		<form method="post">
			<label><h4>아이디 : <input type="text" name="userid" value="${memberVO.getUserid() }" readonly="readonly"></h4></label>
			<label><h4>비밀번호 : <input type="password" name="userpw" ></h4></label>
			<label><h4>이름 : <input type="text" name="username" value="${memberVO.getUsername() }" ></h4></label>
			<label><h4>이메일 : <input type="text" name="useremail" value="${memberVO.getUseremail() }"></h4></label>
			<div>
				<input type="submit" value="수정 완료">
			</div>
		</form>
	</div>
</body>
</html>