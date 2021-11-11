<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% UserVO vo = (UserVO)session.getAttribute("vo"); %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		
		<div class="head">
			<a href="#">게시판</a> &nbsp;
			<a href="#">업로드</a> &nbsp;
			<a href="list.do">상품목록</a> &nbsp;
			
			<%if(vo != null ){ 
				%>
			<a href="mypage.do">장바구니</a> &nbsp;
			<a href="logout.do">로그아웃</a> 
			<%=vo.getName()%> 님 환영합니다.
			
			<%
			}else{ %>
			<a href="login.do">로그인</a> &nbsp;
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
		
			function emailCheck(){
								
				var email = document.getElementById("email").value;
				
				var url = "emailCheck.do";
				
				var param = "email="+encodeURIComponent(email);
				
				sendRequest(url, param, resEmailCheck, "get");	
			}
			
			function resEmailCheck(){
				
				if(xhr.readyState==4 && xhr.status == 200){
					
					var data = xhr.responseText;
					
					var json = eval(data);
					
					if(json[0].res == "no"){
						alert("이미 사용중인 이메일 입니다.");
						return;
						
					}else{
						alert("사용 가능한 이메일 입니다.");
					}
				}
			}
		
			
			function register(f){
				
				var email = f.email.value.trim();
				var pwd = f.pwd.value.trim();
				var name = f.name.value.trim();
				var phone = f.phone.value.trim();
				
				var url = "register.do";
				var param = "email="+encodeURIComponent(email)
							+"&pwd="+encodeURIComponent(pwd)
							+"&name="+encodeURIComponent(name)
							+"&phone="+encodeURIComponent(phone);
				
				sendRequest(url, param, resRegister, "POST");
				
			}
			
			function resRegister(){
				
				if(xhr.readyState == 4 && xhr.status == 200){
					
					var data = xhr.responseText;
					var json = eval(data);
					
					if(json[0].res == "no"){
						alert("회원가입에 실패하였습니다. 처음부터 다시 진행해주세요.");
						return;
					}
					else{
						alert("회원가입에 성공하였습니다.");
						location.href = "list.do";
					}
				}
			}
		
		</script>
	</head>
	<body>
		<h2>:: 회원가입 ::</h2>
		<form>
			<input type="text" name="email" id="email" placeholder="email">
			<button type="button" onclick="emailCheck();">email 중복 확인</button><br>
			
			<input type="password" name="pwd" id="pwd" placeholder="password"><br>
			
			<input type="text" name="name" id="name" placeholder="name"><br>
			
			<input type="text" name="phone" id="phone" placeholder="phone number"><br><br>
			
			<button type="button" onclick="register(this.form);">등록</button>
			<button type="button" onclick="location.href='list.do'">취소</button>
		</form>
	</body>
</html>



