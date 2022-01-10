<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="vo.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#invenMod h2 {
	text-align: center;
}

#invenMod table {
	margin: auto;
	width: 600px;
}

#invenMod #commandCell {
	text-align: center;
}
</style>
</head>
<body>

	<section id="invenMod">
		<header>
			<h2>물품등록</h2>
		</header>
		<form action="invenMod.pro" method="post" name="writeForm">
		<input type="hidden" name="ProductCode" id="ProductCode" value="${product.productCode}"/>
		<input type="hidden" name="TotalCount" id="TotalCount" value="${product.totalCount}"/>
<!-- 인벤토리 폼 액션에서 인벤토리 테이블을 불러와야함 -->
<!-- 		<input type="hidden" name="total" id="total" value="11"/> -->
			<table>
				<tr>
					<td>물품 번호</td>
					<td>물품 이름</td>
					<td>카테고리</td>
					<td>현재 재고</td>
				</tr>
				<tr>
				
					<td>${product.productCode}</td>
					<td>${product.productName }</td>
					<td>
					<c:choose>
					<c:when test="${product.category eq 1}">축구</c:when>
					<c:when test="${product.category eq 2}">야구</c:when>
					<c:when test="${product.category eq 3}">골프</c:when>
					<c:when test="${product.category eq 4}">테니스</c:when>
					
					</c:choose>
					
					<td>${product.totalCount}</td>
				</tr>
				<tr>
					<td colspan="4"><hr></td>
				</tr>
				<tr>
					<td>입,출고</td>
<!-- 					<td colspan="2">날자</td> -->
					<td>입출고 개수</td>
				</tr>
				<tr>
					<td><input type="radio" name="inout" id="inout" value="1" />입고<br>
						<input type="radio" name="inout" id="inout" value="2" />출고</td>
<!-- 					<td colspan="2"><input type="date" name="date" id="date"/></td> -->
					<td><input type="text" name="inoutCount" id="inoutCount" /></td>
				</tr>
				<tr>
					<td colspan="4" id="commandCell"><input type="submit"
						value="재고 추가" /> <input type="reset" value="다시작성" /> <input
						type="button" value="물품 목록으로"
						onClick="window.location.href='productList.pro'" /></td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>