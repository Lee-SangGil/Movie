<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>

	<script type="text/javascript">
		function send(f){
			
			//유효성 체크(이름, 내용, 비밀번호)
			if( f.name.value == '' ){
				alert("이름을 입력해야 합니다");
				return;
			}
			
			var url = "modify.do";
			var param = "idx=" + f.idx.value + 
			            "&name=" + encodeURIComponent( f.name.value ) + 
			            "&content="+ encodeURIComponent( f.content.value ) + 
			            "&pwd=" + encodeURIComponent( f.pwd.value );
			
			sendRequest(url, param, resModify, "POST");
			
		}
		
		function resModify() {
			
			if( xhr.readyState == 4 && xhr.status == 200 ){
				
				var data = xhr.responseText;
				
				if( data == 'yes' ){
					alert("수정성공");
					location.href="list.do";
				}else{
					alert("수정실패");
				}
				
			}
			
		}
	</script>

</head>

<body>
	<form>
		<input type="hidden" name="idx" value="${ vo.idx }">
		
		<table border="1" align="center">
		
			<caption>:::방명록 수정하기:::</caption>
			
			<tr>
				<th>작성자</th>
				<td><input name="name" value="${ vo.name }"></td>
			</tr>
		
			<tr>
				<th>내용</th>
				<td>
					<pre><textarea rows="5" cols="50" name="content">${ vo.content }</textarea></pre>
				</td>
			</tr>
		
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" value="${ vo.pwd }"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정하기" 
					       onclick="send(this.form);">
					
					<input type="button" value="목록으로" 
					       onclick="location.href='list.do'">
				</td>
			</tr>
		</table>
		
	</form>
</body>

</html>





















