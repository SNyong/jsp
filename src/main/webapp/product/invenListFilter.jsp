<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.Product"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고히스토리</title>
<style type="text/css">
#invenList * {
	text-align: center;
}

#invenList {
/* 	width: 700px; */
	margin: auto;
	border: 0px solid gray;
}

#invenList table {
	width: 600px;
	margin: auto;
	text-align: center;
}
#invenList td{
padding-bottom: 5px;
}
</style>

</head>
<body>
<section id="invenList">
		<table>
			<tr>
				<td colspan=5>
					<h1>재고 수정 이력</h1>
				</td>
			</tr>
			<tr>

				<td colspan=5>
					<form action="invenListfilter.pro" method="post" name="filter">
						물품번호 입력 : <input type="text" id="Code" name="Code" /> <a
							href="invenList.pro">필터 삭제</a>
					</form>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td>물품 번호</td>
				<td>이름</td>
				<td>입, 출고</td>
				<td>변동 날짜</td>
				<td>입출고 갯수</td>
				<td>합계</td>
			</tr>
			<c:forEach var="invenList" items="${invenList }">
				<c:choose>
			<c:when test="${invenList.inOutcomming eq 1}"> <tr style="background-color: #B7F0B1;"> </c:when>
			<c:when test="${invenList.inOutcomming eq 2}"> <tr> </c:when>
			</c:choose>
				
					<td>${invenList.productCode }</td>
					<td>${invenList.productName }</td>
					<td><c:choose>
							<c:when test="${invenList.inOutcomming eq 1}"> 입고 </c:when>
							<c:when test="${invenList.inOutcomming eq 2}"> 출고 </c:when>
						</c:choose></td>
					<td>${invenList.i_Date }</td>
					<td>${invenList.productCount }</td>
					<td>${invenList.totalCount }</td>

					<td></td>
				</tr>
			</c:forEach>
			<tr>
			<td colspan="5">
<!-- 	    [이전] 부분 시작  -->
		<c:choose>
			<c:when test="${pageInfo.page <= 1 }">
			[이전]
			</c:when>
			<c:otherwise>
			<a href="invenListfilter.pro?page=${pageInfo.page -1}&Code=${Code}">[이전]</a> 
			</c:otherwise>	
			</c:choose>
<!-- 		[이전] 부분 끝 -->
			
			
	<!-- 			1,2,3 페이지 부분 시작 -->
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
					<a href="invenListfilter.pro?page=<%=a %>&Code=${Code}">[<%=a %>] </a>
					<%} %>
				<%} %>
<!-- 			페이지 부분 끝 -->
			
<!-- 			[다음] 부분 -->
			<c:choose>
			<c:when test="${pageInfo.page >= pageInfo.maxPage }">
			[다음]			
			</c:when>
			<c:otherwise>
			<a href="invenListfilter.pro?page=${pageInfo.page + 1 }&Code=${Code}">[다음]</a>
			</c:otherwise>
			</c:choose>
<!-- 			[다음]부분 끝 -->
			</td>
			</tr>
			<tr>
				<td colspan="5"><a href="productList.pro">물품 목록으로 돌아가기</a>
					&nbsp;</td>
			</tr>
		</table>
		
		
		
</section>
</body>
</html>