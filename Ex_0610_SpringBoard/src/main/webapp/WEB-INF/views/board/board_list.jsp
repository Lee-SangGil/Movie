<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<style>
			table{ border-collapse:collapse; }
			a{text-decoration:none;}
		</style>
	</head>
	
	<body>
		<table border="1" width="700" align="center">
			<tr>
				<td colspan="5">
					<img src="${ pageContext.request.contextPath }/resources/img/title_04.gif">
				</td>
			</tr>
			<tr align="center">
				<td width="60">번호</td>
				<td>제목</td>
				<td width="100">작성자</td>
				<td width="100">작성일</td>
				<td width="60">조회수</td>

			</tr>
			
			<c:forEach var="vo" items="${ list }">
				<tr>
					<td align="center">${ vo.idx }</td>
					
					
					
					<td>
						<!-- 댓글, 대댓글의 경우 들여쓰기 -->
						<c:forEach begin="1" end="${ vo.depth }">
							&nbsp;
						</c:forEach>
					
						<!-- 댓글 기호 -->
						<c:if test="${ vo.depth ne 0 }">
							ㄴ
						</c:if>
						
						<!-- 삭제된 게시글이 아닐경우 클릭 가능 -->
						<c:if test="${ vo.del_info ne -1}">
							<a href="view.do?idx=${vo.idx}&page=${ empty param.page ? 1 : param.page }" 
							   style="text-decoration:none;"> 
								${ vo.subject }</td>
							</a>
						</c:if>
						
						<!-- 삭제된 게시글일 경우 클릭 불가 -->
						<c:if test="${ vo.del_info eq -1}">
							${ vo.subject }
						</c:if>
						
						
					<td align="center">${ vo.name }</td>
					<td align="center">${ vo.regidate }</td>
					<td align="center">${ vo.readhit }</td>
				</tr>
			</c:forEach>
			<!-- 게시물 조회 -->
			
			<!-- 페이징 표시 -->
			<tr align="center">
				<td colspan="5">
					${ pageMenu }
				</td>
			</tr>
			
			<tr align="right">
				<td colspan="5">
					<img src="${ pageContext.request.contextPath }/resources/img/btn_reg.gif" onclick="location.href='insert_form.do'"
						 style="cursor:pointer">
				</td>
			</tr>
			
		</table>
	</body>
</html>









