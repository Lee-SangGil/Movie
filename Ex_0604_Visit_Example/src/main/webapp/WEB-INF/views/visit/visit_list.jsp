<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
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