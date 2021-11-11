<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			function send_check(){
				
				var f = document.f;  // f라는 name을 가진 form태그를 가지고온다.
				
				//유효성체크
				
				f.submit();
			}
		
		</script>
	</head>
	<body>
		<form name="f" method="post" action="insert.do">
			<table width="700" align="center" border="1"
				   style="border-collapse:collapse;">
				   
				<caption>:::새 글 작성하기:::</caption>
					
				<tr>
					<td width="120" height="25">제목</td>
					<td>
						<input name="subject" style="width:570px">
					</td>
				</tr>
				<tr>
					<td width="120" height="25">작성자</td>
					<td>
						<input name="name" style="width:570px">
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea rows="9" cols="79" name="content"></textarea>
					</td>
				</tr>
				<tr>
					<td width="120" height="25">비밀번호</td>
					<td>
						<input name="pwd" type="password">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="right">
						<img src="${ pageContext.request.contextPath }/resources/img/btn_reg.gif"
							 onclick="send_check()">
						<img src="${ pageContext.request.contextPath }/resources/img/btn_back.gif"
							 onclick="location.href='list.do'">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>