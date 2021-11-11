<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
		
		<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
		
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
		
		<style>
			a{
				color: black;
				border-bottom: 3px;
				margin: auto;
			}
			
			h2{
				margin-left: 560px;
				padding-top: 60px;
			}
			
			.head{
				text-align:center;
				font-size: 17px;
			}
			
			form{
				margin-left: 560px;
			}
			
			.name{
				float: right;
			}
			
		</style>
	</head>
	<body>
	
		
		
		<h2>상품 목록</h2>
		<form method="post" enctype="multipart/form-data">
		<table border="1">
			<tr height="50px">
				<th>상품ID</th>
				<th>상품 이미지</th>
				<th>상품명</th>
				<th>가격</th>
				<th>구매자 리뷰</th>
			</tr>
			
			<c:forEach var="vo" items="${list}">
				<tr>
					<td align="center">${vo.p_idx}</td>
					<td>
						<img src="resources/upload/${vo.p_url}" width="160ox" height="140px">
					</td>
					<td width="70px" align="center"><a href="product_detail.do?p_name=${vo.p_name}">${vo.p_name}</a></td>
					<td width="70px" align="center">${vo.p_price} </td>
					<td width="90px" align="center"><a href="product_review.do?p_name=${vo.p_name}"> 후기 </a></td>
				</tr>
			</c:forEach>
		</table>
		
		</form>
		
		 <a href="https://kauth.kakao.com/oauth/authorize
    				?client_id=376a9c9345150705e0b8c5d3c9016c32
    				&redirect_uri=http://localhost:3000/auth/kakao/callback
    				&response_type=code">카카오 로그인</a>
	</body>
</html>







