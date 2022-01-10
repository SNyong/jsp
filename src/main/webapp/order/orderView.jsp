<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 조회</title>
<style>
#orderView * {
	padding: 0;
	margin: 0;
}

#orderView ul {
	list-style-type: none;
	width: 100%;
	padding: 20px;
	display: flex;
}

#orderView th, td {
	text-align: center;
}

#orderView * {
	padding: 0;
	margin: 0;
}

#orderView ul {
	list-style-type: none;
	width: 100%;
	padding: 20px;
}

#orderView #List {
	width: 800px;
	height: 400px;
	border: 0px solid gray;
	padding: 40px 10px 0 10px;
	margin: auto;
}

#orderView #delivery {
	width: 800px;
	height: 300px;
	border: 0px solid gray;
	padding: 40px 10px 0 10px;
	margin: auto;
}

#orderView #totalPay {
	width: 800px;
	height: 200px;
	padding: 0;
	margin: auto;
	font-size: 1.6em;
	text-align: right;
}

#orderView #commandCell {
	text-align: center;
}

#orderView table {
	margin: auto;
	width: 800px;
	height: auto;
	font-size: 1.6em;
	font-family: "돋움";
}

#orderView .tr_up {
	text-align: center;
	background-color: #B7F0B1;
	padding: 10px;
}

#orderView .td_left {
	width: 200px;
	background-color: #B7F0B1;
	padding: 10px;
}

#orderView .td_right {
	width: 600px;
	text-align: left;
	padding-left: 10px;
}
</style>
</head>
<body>
	<form action="index.jsp" method="post" name="writeForm">
		<section id="orderView">
			<section id="List">

				<table>
					<caption>주문 내역</caption>
					<tr class="tr_up">
						<td>상품명</td>
						<td>가격</td>
						<td>수량</td>
						<td>금액</td>
					</tr>
					<c:set var="total" value="0" />
					<c:forEach var="orderList" items="${orderList }">
						<tr>
							<td>${orderList.productName}</td>
							<td style="text-align: right">${orderList.productSellPrice}</td>
							<td>${orderList.detailQ}</td>
							<td style="text-align: right">${orderList.productSellPrice * orderList.detailQ}</td>
							<c:set var="amout"
								value="${orderList.productSellPrice * orderList.detailQ}" />
							<c:set var="total" value="${total + amout}" />
						</tr>
					</c:forEach>
				</table>
			</section>

			<section id="delivery">
				<table>
					<tr>
						<td class="td_left">받는 사람</td>
						<td class="td_right">${member.name}</td>
					</tr>
					<tr>
						<td class="td_left">연락처</td>
						<td class="td_right">${member.number}</td>
					</tr>
					<tr>
						<td class="td_left">이메일</td>
						<td class="td_right">${member.email}</td>
					</tr>
					<tr>
						<td class="td_left">주소</td>
						<td class="td_right">${member.address}${member.address1}</td>
					</tr>
				</table>
			</section>
			<section id="totalPay">
				총 결제 금액:
				<c:out value="${total}" />
				<table>
					<tr>
						<td><input type="button" style="padding: 0.7em"
							value="이전 페이지로" onclick="history.back();"/></td>
					</tr>
				</table>
			</section>

		</section>
	</form>
</body>




</html>