<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.Product"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>물품 리스트</title>
<style type="text/css">
#productList {
	/* 	width: 900px; */
	margin: auto;
	/* 	border: 1px solid gray; */
	
}

#productList table {
	width: 850px;
	margin: auto;
	text-align: center;
}

#productList ul {
	list-style-type: none;
	width: 100%;
	padding: 20px;
}

#productList td {
	padding: 4px;
}

#productList tr:nth-child(even) {
	background-color: #B7F0B1;
}
</style>
<script>
	function checkDel(productCode) {
		if (confirm('물품을 삭제하시겠습니까?')) {
			location.href = 'proDelAction.pro?ProductCode=' + productCode;
		}
	}
</script>
</head>
<body>

	<section id="productList">
		<table>
			<tr>
				<td colspan=6>
					<h1>물품목록</h1>
				</td>
				<td colspan="2"><a href=productAddForm.pro>물품 추가하기</a> <a
					href="invenList.pro">재고관리</a></td>
			</tr>
			<tr>
				<td>물품 번호</td>
				<td>물품 이름</td>
				<td>카테고리</td>
				<td>구매 가격</td>
				<td>판매가격</td>
				<!-- 			<td>메모</td> -->
				<!-- 메모는 길어질거 같아 제외합니다 -->
				<td>재고</td>
				<td>표시</td>
				<td></td>

			</tr>

			<c:forEach var="proList" items="${proList }">
				<tr>
					<td>${proList.productCode }</td>
					<td>${proList.productName }</td>

					<td><c:choose>
							<c:when test="${proList.category eq 1}">
					축구
					</c:when>
							<c:when test="${proList.category eq 2}">
					야구
					</c:when>
							<c:when test="${proList.category eq 3}">
					골프
					</c:when>
							<c:when test="${proList.category eq 4}">
					테니스
					</c:when>
						</c:choose></td>

					<td>${proList.productBuyPrice }</td>
					<td>${proList.productSellPrice }</td>
					<%-- 					<td> ${proList.note }</td> --%>
					<td>${proList.totalCount}</td>
					<td><c:choose>
							<c:when test="${proList.hidden eq 1 }">
					보임
					</c:when>
							<c:when test="${proList.hidden eq 2 }">
					숨김
					</c:when>
							<c:otherwise>미등록</c:otherwise>
						</c:choose></td>
					<td><a href="proModForm.pro?ProductCode=${proList.productCode }">수정</a>
						 <%-- <a href="javascript:checkDel('${proList.productCode }')">삭제</a>  --%>
						<!-- 						삭제하면 재고와 꼬이기 때문에 봉인 --> 
						<a href="invenListfilter.pro?Code=${proList.productCode }">재고관리</a>
						<a href="invenModForm.pro?productCode=${proList.productCode }">재고추가</a>
					</td>
				</tr>
			</c:forEach>
		</table>

		<!-- 	    [이전] 부분 시작  -->
		<c:choose>
			<c:when test="${pageInfo.page <= 1 }">
			[이전]
			</c:when>
			<c:otherwise>
				<a href="productList.pro?page=${pageInfo.page -1}">[이전]</a>
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
		<%
			for (int a = startPage; a <= endPage; a++) {
			if (a == nowpage) {
		%>
		[<%=a%>]
		<%
			} else {
		%>
		<a href="productList.pro?page=<%=a%>">[<%=a%>]
		</a>
		<%
			}
		%>
		<%
			}
		%>
		<!-- 			페이지 부분 끝 -->

		<!-- 			[다음] 부분 -->
		<c:choose>
			<c:when test="${pageInfo.page >= pageInfo.maxPage }">
			[다음]			
			</c:when>
			<c:otherwise>
				<a href="productList.pro?page=${pageInfo.page + 1 }">[다음]</a>
			</c:otherwise>
		</c:choose>
		<!-- 			[다음]부분 끝 -->
	</section>


</body>
</html>