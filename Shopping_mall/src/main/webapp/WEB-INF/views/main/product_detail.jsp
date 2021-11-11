<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 상세 정보</title>
		
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
		
		<link rel="stylesheet"
				  href="${ pageContext.request.contextPath }/resources/css/style.css">
		
		<script src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>
		
		<script type="text/javascript">
		
		function cart_insert(f){
			
		
			var count = f.count.value.trim();
			var p_name = f.p_name.value.trim();
			var p_price = f.p_price.value.trim();
			
			var email = f.email.value.trim();
			
			//유효성 검사
			if(email == ''){
				
				alert("로그인 후 진행 해주세요.");
				location.href = "list.do";
			}
				
			var url = "cart_insert.do";
			var param = "email="+encodeURIComponent(email)
						+"&p_name="+encodeURIComponent(p_name)
						+"&p_price="+encodeURIComponent(p_price)
						+"&count="+encodeURIComponent(count);
			
			sendRequest(url, param, resCart, "post");
			
		}
		
		function resCart(){
			
			if(xhr.readyState==4 && xhr.status == 200){
				
				var data = xhr.responseText;
				
				var json = eval(data);
				
				if(json[0].res == "no"){
					alert("장바구니 넣기에 실패하였습니다.");
					return;
				
				}else{
					alert("장바구니 넣기에 성공하였습니다.");
					location.href="list.do?email=${email}"; // 로그인 유지
				}	
			}
		}
		
		</script>
		
	</head>
	<body>
		
		<h2>상품 상세 정보</h2>
		<form>
		<input type="hidden" name="email" value="${email }">
		<table border="1">
		
			<c:forEach var="vo_p" items="${list}">
				<input type="hidden" name="p_name" value="${vo_p.p_name }">
				<input type="hidden" name="p_price" value="${vo_p.p_price }">
				<tr>
					<td rowspan="4"><img src="resources/upload/${vo_p.p_url}" width="280ox" height="250px"></td>
					<td align="center" width="100px">상품명</td>
					<td align="center" width="250px">${vo_p.p_name }</td>
				</tr>
				<tr>
					<td align="center">가격</td>
					<td align="center">${vo_p.p_price }</td>
				</tr>
				<tr>
					<td align="center">상품 소개</td>
					<td align="center">${vo_p.p_desc }</td>
				</tr>
			</c:forEach>
				
			
				<tr>
					<td colspan="2" align="center">
						<select name="count">
							<c:forEach begin="1" end="10" var="i">
								<option value="${i}"> ${i} </option>
							</c:forEach>
						</select> &nbsp; 개
						<button type="button" onclick="cart_insert(this.form);">장바구니에 담기</button><br>
						
						<a href="list.do?email=${email}">상품목록</a>
					</td>
				</tr>
				
			
		</table>
		
		</form>
	</body>
</html>





