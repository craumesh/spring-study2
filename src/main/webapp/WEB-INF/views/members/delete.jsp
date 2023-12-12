<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form method="post">
			<input type="hidden" name="userid" value="${id }">
			<label>비밀번호 <input type="password" name="userpw"></label>
			<div><input type="submit" value="탈퇴"></div>
		</form>
	</div>
</body>
</html>