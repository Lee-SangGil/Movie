<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>장바구니</title>
		
		<div class="head">
			<a href="#">게시판</a> &nbsp;
			<a href="#">후기</a> &nbsp;
			<a href="list.do?email=${email }">상품목록</a> &nbsp;
			
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
		<style>
			.p_list{
				margin-left: 600px;
			}
		</style>		  
		
		
		<script src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>
		
		<script type="text/javascript">
			
			function cart_del(f){
				
				if(confirm("정말로 삭제 하시겠습니까")){
					
					var email = f.email.value.trim();
					
					var cart_idx = f.cart_idx.value.trim();
					
					var url = "cart_del.do";
								
					var param = "cart_idx="+cart_idx
									+"&email="+encodeURIComponent(email);
					
					sendRequest(url, param, resCart_del, "post");
				}
			}
			
			function resCart_del(){
				
				if(xhr.readyState==4 && xhr.status == 200){
					
					var data = xhr.responseText;
					
					var json = eval(data);
					
					if(json[0].res == "no"){
						alert("장바구니 삭제에 실패하였습니다.");
						return;
					
					}else{
						alert("장바구니 삭제에 성공하였습니다.");
						location.href="list.do?email=${email}"; // 로그인 유지
					}	
				}
			}
		
		</script>
		
		
	</head>
	<body>
		
		<h2>::장바구니 확인::</h2>
		<form>
			<input type="hidden" name="email" value="${email }">
			<table border="1">
			
				
				<tr>
					<th align="center" width="80px">상품명</th>
					<th align="center" width="80px">단가</th>
					<th align="center" width="40px">수량</th>
					<th align="center" width="90px">금액</th>
					<th width="45px"></th>
				</tr>
				
				<c:forEach var="vo" items="${list }">
				<input type="hidden" name="cart_idx" value="${vo.cart_idx }">
				<tr>
					<td align="center">${vo.p_name }</td>
					<td align="right">${vo.price}</td>
					<td align="center">${vo.count }</td>
					<td align="right">${vo.amount }</td>
					<td align="center"><button type="button" onclick="cart_del(this.form)">취소</button></td>
				</tr>
				
				</c:forEach>
				
			</table>
			
		</form><br><br>
		<div class="p_list"><a href="list.do?email=${email}">상품목록</a></div>
	</body>
</html>








