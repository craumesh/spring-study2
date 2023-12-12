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
		<label><h3>회원정보</h3></label>
		<label><h4>아이디 : ${memberVO.getUserid() }</h4></label>
		<label><h4>비밀번호 : ${memberVO.getUserpw() }</h4></label>
		<label><h4>이름 : ${memberVO.getUsername() }</h4></label>
		<label><h4>이메일 : ${memberVO.getUseremail() }</h4></label>
		<label><h4>가입일 : ${memberVO.getRegdate() }</h4></label>
		<div>
			<a href="/members/main">메인 페이지로</a>
			<a href="/members/update">회원 정보 수정</a>
			<a href="/members/delete">회원 탈퇴</a>
		</div>
	</div>
</body>
</html>