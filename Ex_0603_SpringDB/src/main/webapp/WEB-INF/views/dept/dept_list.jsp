<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table border="1" align="center">
			<caption>:::부서목록:::</caption>
			<tr>
				<td> 부서 번호</td>
				<td> 부서 이름</td>
				<td> 위치</td>
			</tr>
			<c:forEach var="vo" items="${ list }">
			<tr>
				<td>${ vo.deptno }</td>
				<td>${ vo.dname }</td>
				<td>${ vo.loc }</td>	
			</tr>			
			</c:forEach>
		
		</table>
		
	</body>
</html>