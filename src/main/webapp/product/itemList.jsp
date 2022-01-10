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
#itemList * {
	padding: 0px;
	margin: 0px auto;
}

#itemList .row {
	width: 98%;
	border: 0px solid red; /*작업시 숨김처리*/
	height: 350px;
	padding-left: 20px;
	margin: 0 auto;
	display: flex;
}

#itemList .row ul {
display: inline-block;
	border: 0px solid yellow; /*작업시 숨김처리*/
	width : 40%;
}

#itemList ul {
	list-style-type: none;
	width: 100%;
	padding: 20px;
}

#itemList .row li {

	/* display:inline-block; */
	
}

#itemList img {
	width: 230px;
	height: 230px;
}

#itemList .li2 {
	color: red;
	font-size: 0.8em;
}

#itemList .li3 {
	font-size: 0.8em;
	text-align: right;
	margin-right: 10px;
}

</style>
</head>
<body>
	<section id="itemList">
		<div>
			<c:if test="${proList ne null }">
				<div class="row">
					<c:forEach var="proList" items="${proList }" varStatus="status">
						<ul>
							<li><a
								href="itemView.pro?ProductCode=${proList.productCode }"> <img
									src="./image/${proList.image }" id="productImage" /></a></li>
							<li class="li1">${proList.productName }</li>
							<li class="li2">${proList.productSellPrice } 원</li>
							<%-- 						<li class="li3">현재 재고 : ${proList.totalCount}</li> --%>
							<c:if test="${proList.totalCount eq 0}">
								<p class="li2">현재 매진입니다.</p>
							</c:if>
						</ul>
						<c:if test="${((status.index+1) mod 4) == 0 }">
							<!-- 4개가 넘으면 줄 넘김 -->
				</div>
				<div class="row">
			</c:if>
			</c:forEach>
		</div>
		</c:if>
		<c:if test="${proList == null }">
			<div class="div_empty">상품이 없습니다.</div>
		</c:if>
		</div>
	</section>
</body>
</html>