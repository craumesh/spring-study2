<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- http://localhost:8088/members/login	 -->
	<div>
		<label><h1> Spring MVC 로그인 </h1></label>
		<form method="post">
			<label>아이디 <input type="text" name="userid"></label><br>
			<label>비밀번호 <input type="password" name="userpw"></label><br>
			<div>
				<input type="submit" value="로그인">
				<input type="button" value="회원가입" onclick="location.href='./join'">
			</div>
		</form>
	</div>
</body>
</html>