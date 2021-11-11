<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% UserVO vo = (UserVO)session.getAttribute("vo"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		
		<div class="head">
			<a href="#">게시판</a> &nbsp
			<a href="#">업로드</a> &nbsp
			<a href="list.do">상품목록</a> &nbsp
			
			<%if(vo != null ){ 
				%>
			<a href="mypage.do">장바구니</a> &nbsp
			<a href="logout.do">로그아웃</a> 
			<%=vo.getName()%> 님 환영합니다.
			
			<%
			}else{ %>
			<a href="login.do">로그인</a> &nbsp
			<a href="register_form.do">회원가입</a>
			<%
			}
			%>
		
		</div>
		
		<style>
			a{
				color: black;
				border-bottom: 3px;
				margin: auto;
			}
			
			h2{
				padding-top: 150px;
			}
			
			.head{
				position: absolute;
				left: 50%;
				transform: translateX(-50%);
				font-size: 17px;
			}
			body{
				margin-left: 680px;
			}
			
		</style>
		
		<script src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>
		
		<script type="text/javascript">
			
			function login(f){
				
				var email = f.email.value.trim();
				var pwd = f.pwd.value.trim();
				
				var url = "login_1.do";
				var param = "email="+encodeURIComponent(email)
							+"&pwd="+encodeURIComponent(pwd)
			
				sendRequest(url, param, resLogin, "post");
			}
			
			function resLogin(){
				
				if(xhr.readyState == 4 && xhr.status == 200){
						
					var email = xhr.responseText;
					
					if(email != null){
						alert(email+"님 환영합니다.");
						location.href = "list.do?email="+email;
					}
					else{
						alert("id 또는 비밀번호가 일치하지 않습니다.");
						return;
					}
					
					
				}
				
			}
			
		</script>
		
	</head>
	<body>
		<h2>:: 로그인 ::</h2>
		<form>
			<input type="text" name="email" id="email" placeholder="email"><br>
			
			<input type="password" name="pwd" id="pwd" placeholder="password"><br><br>
			
			<button type="button" onclick="login(this.form);">로그인</button>
			<button type="button" onclick="location.href='list.do'">취소</button>
		</form>
	</body>
</html>





