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
		<table border="1" align="center">
				<caption>:::사원목록:::</caption>
				<tr>
					<td> 사원 번호</td>
					<td> 이름</td>
					<td> 직급</td>
					<td> 급여</td>
				</tr>
				<c:forEach var="vo" items="${ list }">
				<tr>
					<td>${ vo.sabun }</td>
					<td>${ vo.saname }</td>
					<td>${ vo.sajob }</td>	
					<td>${ vo.sapay }</td>	
				</tr>			
				</c:forEach>
			
			</table>
	</body>
</html>