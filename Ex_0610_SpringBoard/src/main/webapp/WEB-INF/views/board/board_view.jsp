<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>
		
		<script type="text/javascript">
		
			function del(){
				
				if(confirm("정말로 삭제하시겠습니까?")){
					
					var pwd = document.getElementById("c_pwd").value;
					
					var url = "del.do";
					var param = "idx=${vo.idx}&pwd="+pwd;
					
					sendRequest( url, param, resFn, "post" );
				}
			}//del
			
			function resFn(){
				
				if(xhr.readyState == 4 && xhr.status == 200){
					
					var data = xhr.responseText;
					
					var json = eval(data);
					
					if(json[0].res == 'yes'){
						alert("게시글을 삭제했습니다.");
						location.href="list.do?page=${param.page}";
						
					}else{
						alert("비밀번호가 일치하지 않습니다.");
						return;
					}
				}
			}
		
			function reply(){
				
				location.href="reply_form.do?idx=${vo.idx}&page=${param.page}";
			}
		
		</script>
	</head>
	<body>
		<form>
			<table width="700" border="1">
				<tr>
					<th width="120" height="25">제목</th>
					<td>${ vo.subject }</td>
				</tr>
				<tr>
					<th width="120" height="25">작성자</th>
					<td>${ vo.name }</td>
				</tr>
				<tr>
					<th width="120" height="25">작성일</th>
					<td>${ vo.regidate }</td>
				</tr>
				<tr>
					<th width="120" height="25">IP</th>
					<td>${ vo.ip }</td>
				</tr>
				<tr>
					<th width="120" height="25">내용</th>
					<td><pre>${ vo.content }</pre></td>
				</tr>
				<tr>
					<th width="120" height="25">비밀번호</th>
					<td>
						<input type="password" id="c_pwd">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<img src="${ pageContext.request.contextPath }/resources/img/btn_list.gif" onclick="location.href='list.do?page=${param.page}'"
							 style="cursor:pointer">
							 
						<c:if test="${ vo.depth lt 1 }">
						<img src="${ pageContext.request.contextPath }/resources/img/btn_reply.gif" onclick="reply();" 
							 style="cursor:pointer">
							 
						</c:if>
						
						<img src="${ pageContext.request.contextPath }/resources/img/btn_delete.gif" onclick="del();"
							 style="cursor:pointer">
					</td>
				</tr>
				
			
			</table>
		</form>
	</body>
</html>





