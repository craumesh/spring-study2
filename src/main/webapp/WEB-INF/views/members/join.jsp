<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- http://localhost:8088/members/join	 -->
	<div>
		<label><h1>Spring MVC 회원가입</h1></label>
		<!-- action 속성 생략 가능, 생략 시 자기 자신의 주소를 호출 -->
		<form method="post">
			<label>아이디 <input type="text" name="userid"></label><br>
			<label>비밀번호 <input type="password" name="userpw"></label><br>
			<label>이름 <input type="text" name="username"></label><br>
			<label>이메일 <input type="text" name="useremail"></label><br>
			<div>
				<input type="submit" value="회원가입">
			</div>
		</form>
	</div>
</body>
</html>