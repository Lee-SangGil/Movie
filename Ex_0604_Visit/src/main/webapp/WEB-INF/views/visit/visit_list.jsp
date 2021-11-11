<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
			<!-- 외부 스타일시트 참조 -->
			<!-- 스프링은 ../로 한단계 밖으로 접근이 불가. -->
			<!-- 바로 webapp폴더로 접근할 수 있는 경로가 필요. -->
			 <link rel="stylesheet"
				  href="${ pageContext.request.contextPath }/resources/css/visit.css">
				
		<!-- ajax사용을 위한 자바스크립트 참조 -->  
		<script src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>
				  
		<script type="text/javascript">
		
			function modify(f){
				
				var pwd = f.pwd.value.trim();
				var c_pwd = f.c_pwd.value.trim();
				
				if(pwd != c_pwd){
					alert("비밀번호 불일치");
					return;
				
				}else{
					location.href="modify_form.do?idx="+f.idx.value;
				}
			}
			
			function del(f){
				
				var pwd = f.pwd.value.trim();
				var c_pwd = f.c_pwd.value.trim();
				
				if(pwd != c_pwd){
					alert("비밀번호 불일치");
					return;
				}
				
				if( !confirm("정말 삭제하시겠습니까?")){
					return;
				}
				
				var url = "delete.do";
				var param = "idx="+f.idx.value;
				sendRequest( url, param, resultFn, "GET");
			}
			
			//삭제 후 콜백메서드
			function resultFn(){
				
				if(xhr.readyState == 4 && xhr.status == 200){
					
					var data = xhr.responseText;
					
					if(data == 'no'){
						alert("삭제 실패");
						return;
						
					
					}else{
						alert("삭제 성공");
						location.href = "list.do";
					}
					
				}

					
			}
		
		</script>
	</head>
<body>
	<div id="main_box">
		<h1>::방명록 리스트::</h1>
		<div align="center">
			<input type="button" value="새 글 남기기" 
				   onclick="location.href='insert_form.do'">
		</div>
		
		<c:forEach var="vo" items="${ list }">
			<div class="visit_box">
				<div class="type_content"><pre>${ vo.content }</pre></div>
				
				<c:if test="${ vo.filename ne 'no_file' }">
					<img src="resources/upload/${ vo.filename }" width="200">
				</c:if>
				<div class="type_name">작성자 : ${ vo.name }( ${ vo.ip })</div>
				<div class="type_regidate">작성일 : ${ vo.regidate }</div>
			
			<div>
				<form>					
					<input type="hidden" name="idx" value="${ vo.idx }">
					<input type="hidden" name="pwd" value="${ vo.pwd }">
					
					비밀번호 <input type="password" name="c_pwd">
					
					<input type="button" value="수정" onclick="modify(this.form);">
					<input type="button" value="삭제" onclick="del(this.form);">
					
				</form>
				</div>
			</div>
		
		</c:forEach>
		
	</div>
</body>
</html>