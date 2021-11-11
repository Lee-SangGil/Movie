<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script>
			function send1(f){
				
				var name = f.name.value.trim();
				var tel = f.tel.value.trim();
				var age = f.age.value.trim();
				
				if(name == ''){
					alert("이름을 입력하세요.");
					return;
				}
				
				var phone_patt = /^\d{3}-\d{3,4}-\d{4}$/;
				if(!phone_patt.test(tel)){
					alert("휴대폰 번호를 정확하게 입력해주세요");
					return;
				}
				
				var age_patt = /^[0-9]{1,3}$/;
				if(!age_patt.test(age)){
					alert("나이는 정수로 입력하세요.");
					return;
				}
				
				f.action = "insert1.do";
				f.method = "post";
				f.submit();
				
			}
			
			function send2(f){
				
				// 유효성 체크
				
				// 파라미터 전달
				f.action = "insert2.do";
				f.method = "post";
				f.submit();
			}
			
		</script>
	</head>
	<body>
		<form>
			<table border="1" align="center">
				<caption>::회원 가입::</caption>
				
				<tr>
					<th>이름</th>
					<td><input name="name"></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input name="age"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input name="tel"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="낱개로 전송" onclick="send1(this.form);">
						<input type="button" value="객체로 전송" onclick="send2(this.form);">
						
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>