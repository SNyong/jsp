<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>데일리 스포츠</title>
<style>

#itemView * {
	padding: 0px;
	margin: 0px auto;
}


#itemView .ss {
	width: 50%;
}

#itemView .table_1 {
	width: 90%;
}

#itemView .table_1 td {
	width: 48%;
}

#itemView .table_2 {
	text-align: center;
	line-height: 2.3;
}

#itemView ul {
	list-style-type: none;
	width: 100%;
	padding: 20px;
}
#itemView img {
	width: 250px;
	margin-right: 50px;
}
</style>
</head>
<body>
<section id="itemView">
	<div class="ss">
		<!-- 	윗부분 시작 -->
		<table class="tabel_1">
			<tr>
				<td>
					<div>
						<img src="./image/${product.image }" id="productImage" />
					</div>
				</td>
				<td>
					<div>
					<form action="bucketAdd.buc" name="form" method="post">
					<input type="hidden" name="productCode" value="${product.productCode }"/>
						<table class="table_2">
							<tr>
								<td>물품이름</td>
								<td>${product.productName }</td>
							<tr>
								<td>가격</td>
								<td>${product.productSellPrice }</td>
							</tr>
							<tr>
								<td>현재 재고</td>
								<c:if test="${product.totalCount eq 0}">
								<td>매진입니다</td>
								</c:if>
								<c:if test="${product.totalCount ne 0}">
								<td>${product.totalCount}</td>
								</c:if>
								
							</tr>
							<tr>
								<td colspan="2">
									<hr>
								</td>
							</tr>
							<tr>
								<td>수량</td>
								<td><input type="text" name="count" id="count" value="1"></td>
							</tr>
							<tr>
								<td colspan="2">
									<hr>
								</td>
							</tr>
							<tr>
								<td colspan="2">
								<c:if test="${product.totalCount eq 0}">
								주문 불가능
								</c:if>
								<c:if test="${product.totalCount ne 0}">
								<input type="submit" value="장바구니"/>&nbsp;&nbsp;
<%-- 								<a href="bucketAdd.buc?code=${product.productCode}&bucketQ=${param.count}">장바구니</a> &nbsp;&nbsp; --%>
								<button onclick="orderList.or?code=${product.productCode}">바로구매</button>
								</c:if>
								<br>
								<a href="javascript:history.back()">쇼핑 계속하기</a>
								</td>
							</tr>
						</table>
						</form>
					</div>
				</td>
			</tr>
		</table>



		<!-- 윗부분 종료 -->
		<h1>상품 안내</h1>
		<hr>
		${product.note}

	</div>
	</section>
</body>
</html>