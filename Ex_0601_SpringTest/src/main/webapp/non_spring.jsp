<%@page import="vo.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	PersonVO p1 = new PersonVO("홍길동", 30, "010-111-1111");
	PersonVO p2 = new PersonVO("김길동", 35, "010-222-1111");
	
	request.setAttribute("p1", p1);
	request.setAttribute("p2", p2);


%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		${ p1.name } / ${ p1.age } / ${ p1.tel } <br>
		${ p2.name } / ${ p2.age } / ${ p2.tel } <br>
	</body>
</html>