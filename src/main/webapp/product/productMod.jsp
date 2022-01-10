<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

#productMod h2 {
	text-align: center;
}

#productMod table {
	margin: auto;
	width: 450px;
}

#productMod .td_left {
	width: 150px;
}

#productMod .td_right {
	width: 300px;
}

#productMod #commandCell {
	text-align: center;
}
</style>
</head>
<body>

	<section id="productMod">
		<header>
			<h2>물품 수정</h2>
		</header>
		<form action="productMod.pro" method="post" name="writeForm" enctype="multipart/form-data">
		<input type="hidden" name="code" id="code" value="${product.productCode }"/>
<%-- 		<input type="text" name="code" id="code" value="${product.productCode }"/> --%>
			<table>
				<tr>
					<td colspan="2"><a href="productList.pro">목록보기</a></td>
				</tr>

				<tr>
					<td class="td_left"><label for="name"> 품명 : </label></td>
					<td class="td_rigth"><input type="text" name="name" id="name"
						required="required" value="${product.productName }"/></td>
				</tr>

				<tr>
					<td class="td_left"><label for="category">카테고리 : </label></td>
					<td class="td_right">
					<c:choose>
					<c:when test="${product.category eq 1}">
					축구
					</c:when>
					<c:when test="${product.category eq 2}">
					야구
					</c:when>
					<c:when test="${product.category eq 3}">
					골프
					</c:when>
					<c:when test="${product.category eq 4}">
					테니스
					</c:when>
					</c:choose>
					</td>
				</tr>

				<tr>
					<td class="td_left"><label for="buyprice">매입 가격 : </label></td>
					<td class="td_right"><input type="text" name="buyprice"
						id="buyprice" value="${product.productBuyPrice }"/></td>
				</tr>

				<tr>
					<td class="td_left"><label for="sellprice">판매 가격 : </label></td>
					<td class="td_right"><input type="text" name="sellprice"
						id="sellprice" value="${product.productSellPrice }"/></td>
				</tr>

				<tr>
					<td class="td_left"><label for="note">메모 : </label></td>
					<td class="td_right"><textarea name="note" id="note" rows="5"
							cols="20" wrap="soft">${product.note }</textarea></td>
				</tr>

				<tr>
					<td class="td_left"><label for="note">메인이미지 : </label></td>
					<td class="td_right"><input type="file" name="image" id="image"/> </td>
				</tr>
				<tr>
					<td class="td_left"><label for="hidden">숨김기능 : </label></td>
					<td class="td_right">
					<c:choose>
					<c:when test="${product.hidden eq 1 }">
					<input type="radio" name="hidden" id="hidden" value="1" checked/>보이기
					<input type="radio" name="hidden" id="hidden" value="2" />숨김
					</c:when>
					<c:when test="${product.hidden eq 2 }">
					<input type="radio" name="hidden" id="hidden" value="1" />보이기
					<input type="radio" name="hidden" id="hidden" value="2" checked/>숨김
					</c:when>
					</c:choose>
				</tr>
				
				<tr>
					<td colspan="2" id="commandCell"><input type="submit"
						value="수정하기" /> <input type="reset" value="다시작성" /> <input
						type="button" value="물품 목록으로"
						onClick="window.location.href='productList.pro'" /></td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>