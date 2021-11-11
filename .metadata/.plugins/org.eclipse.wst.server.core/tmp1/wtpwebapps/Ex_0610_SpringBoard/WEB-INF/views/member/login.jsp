<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form>
			<p><input name="id" value="아이디"></p>
			<p><input name="pwd" value="비밀번호"></p>
			<p><input type="button" value="로그인" onclick="login(this.form);"></p>
			<p><input type="button" value="회원가입" onclick="location.href='newmember.jsp'"></p>
			
		</form>
	</body>
</html>