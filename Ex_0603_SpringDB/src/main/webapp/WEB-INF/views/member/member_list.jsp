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
			<caption> 멤버 테이블 조회 </caption>
				<tr>
					<th>이름</th>
					<th>id</th>
					<th>pwd</th>
					<th>email</th>
					<th>주소</th>
				</tr>
				<c:forEach var="vo" items="${ list }">
					<tr>
						<td>${ vo.name } </td>
						<td>${ vo.id } </td>
						<td>${ vo.pwd } </td>
						<td>${ vo.email } </td>
						<td>${ vo.addr } </td>
					
					</tr>
				
				</c:forEach>
		
		</table>
	</body>
</html>