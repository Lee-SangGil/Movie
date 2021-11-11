<%@page import="vo.PersonVO"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	//applicationScope로 접근 할 수 있도록 클래스 생성
	WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(application);

	PersonVO p1 = (PersonVO)wc.getBean("p1");
	PersonVO p2 = (PersonVO)wc.getBean("p2");
	
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









