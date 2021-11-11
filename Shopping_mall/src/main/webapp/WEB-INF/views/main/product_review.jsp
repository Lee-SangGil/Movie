<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 리뷰</title>
		
		<link rel="stylesheet"
				  href="${ pageContext.request.contextPath }/resources/css/style.css">
		
		
		<div class="head">
			<a href="#">게시판</a> &nbsp;
			<a href="#">업로드</a> &nbsp;
			<a href="list.do">상품목록</a> &nbsp;
			
			<c:choose>
				<c:when test="${ email ne null }">
					<a href="cart.do?cart_email=${email }">장바구니</a> &nbsp;
					<a href="logout.do">로그아웃</a> <br><br>
					
					<div class="name">
						${vo.getName()} 님 환영합니다.
					</div>
				</c:when>
				<c:when test="${ email eq null }">
					<a href="login.do">로그인</a> &nbsp;
					<a href="register_form.do">회원가입</a>
					
				</c:when>
			</c:choose>
		
		</div>
	</head>
	<body>
	
		<h2>::상품 리뷰::</h2>
		<table border="1">
			<tr>
				<th width="80px">상품명</th>
				<th>리뷰</th>
				<th width="150px">작성자</th>
				<th width="170px">작성일</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				
				<tr>
					<td align="center">${vo.p_name }</td>
					<td>${vo.content }</td>
					<td align="center">${vo.email }</td>
					<td align="center">${vo.regidate }</td>
				</tr>
			</c:forEach>
		</table>
		
	</body>
</html>











