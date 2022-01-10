<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="vo.*, java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
<style>
#memberList {
	margin: auto;
}

#memberList table {
	width: 550px;
	margin: auto;
	text-align: center;
}

#memberList ul {
	list-style-type: none;
	width: 100%;
	padding: 10px;
}

#memberList td {
	padding: 4px;
}

#memberList tr:nth-child(even) {
	background-color: #B7F0B1;
}
</style>
<script>
	function checkDel(id) {
		if (confirm('회원 정보를 삭제하시겠습니까?')) {
			location.href = 'memberDeleteAction.mem?id=' + id;
		}
	}
</script>
</head>
<body>
	<section id="memberList">
		<form name="memberList" action="./memberListAction.mem" method="post">
			<table>
				<tr>
					<td colspan="3" class="td_tatle">회원 목록</td>
					<td colspan="2"><a href="index.pro">메인으로</a>
				</tr>

				<c:forEach var="memberList" items="${memberList }">

					<tr>
						<td colspan="4"><a
							href="memberInfo.mem?id=${memberList.getMemberId() }">
								${memberList.getMemberId() } </a></td>
						<td><a
							href="memberModifyFormAction.mem?id=${memberList.getMemberId() }">수정</a>

							<a href="javascript:checkDel('${memberList.getMemberId() }')">삭제
						</a></td>
					</tr>

				</c:forEach>
			</table>
		</form>
		<c:choose>
			<c:when test="${pageInfo.page <= 1 }">
			[이전]
			</c:when>
			<c:otherwise>
				<a href="memberList.mem?page=${pageInfo.page -1}">[이전]</a>
			</c:otherwise>
		</c:choose>
		<%@ page import="vo.PageInfo"%>
		<%
		PageInfo PageInfo = (PageInfo) request.getAttribute("pageInfo");
		int listCount = PageInfo.getListCount();
		int nowpage = PageInfo.getPage();
		int maxPage = PageInfo.getMaxPage();
		int startPage = PageInfo.getStartPage();
		int endPage = PageInfo.getEndPage();
		%>
		
<% for(int a = startPage; a<= endPage; a++){
				if(a==nowpage){%>
					[<%=a %>]
				<%}else {%>
					<a href="memberListAction.mem?page=<%=a %>">[<%=a %>] </a>
					<%} %>
				<%} %>
		<c:choose>
			<c:when test="${pageInfo.page >= pageInfo.maxPage }">
			[다음]			
			</c:when>
			<c:otherwise>
				<a href="memberlist.mem?page=${pageInfo.page + 1 }">[다음]</a>
			</c:otherwise>
		</c:choose>
	</section>
</body>
</html>