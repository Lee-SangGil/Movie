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
			<caption>:::고객정보 목록:::</caption>
			<tr> 
				<td>고객 번호 </td> 
				<td>이름 </td> 
				<td>주소 </td> 
				<td>담당자 </td> 
			</tr>
			
			<c:forEach var="vo" items="${ list }">
				<tr>
					<td>${ vo.gobun }</td>
					<td>${ vo.goname }</td>
					<td>${ vo.goaddr }</td>
					<td>${ vo.godam }</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>