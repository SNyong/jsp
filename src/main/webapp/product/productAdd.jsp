<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#productAdd h2 {
	text-align: center;
}

#productAdd table {
	margin: auto;
	width: 450px;
}

#productAdd .td_left {
	width: 150px;
}
#productAdd .td_right {
	width: 300px;
}

#productAdd #commandCell {
	text-align: center;
}
</style>
</head>
<body>

	<section id="productAdd">
		<header>
			<h2>물품등록</h2>
		</header>
		<form action="productAdd.pro" method="post" name="writeForm" enctype="multipart/form-data">

			<table>
				<tr>
					<td class="td_left"><label for="name"> 품명 : </label></td>
					<td class="td_rigth"><input type="text" name="name" id="name"
						required="required" /></td>
				</tr>

				<tr>
					<td class="td_left"><label for="category">카테고리 : </label></td>
					<td class="td_right"><input type="radio" name="category"
						id="category" value="1" checked/>축구 <input type="radio" name="category"
						id="category" value="2" />야구 <input type="radio" name="category"
						id="category" value="3" />골프 <input type="radio" name="category"
						id="category" value="4" />테니스</td>
				</tr>

				<tr>
					<td class="td_left"><label for="buyprice">매입 가격 : </label></td>
					<td class="td_right"><input type="text" name="buyprice"
						id="buyprice" required="required"/></td>
				</tr>

				<tr>
					<td class="td_left"><label for="sellprice">판매 가격 : </label></td>
					<td class="td_right"><input type="text" name="sellprice"
						id="sellprice" required="required"/></td>
				</tr>

				<tr>
					<td class="td_left"><label for="note">메모 : </label></td>
					<td class="td_right"><textarea name="note" id="note" rows="5"
							cols="20" wrap="soft"></textarea></td>
				</tr>

				<tr>
					<td class="td_left"><label for="note">메인이미지 : </label></td>
					<td class="td_right"><input type="file" name="image" id="image"/> </td>
				</tr>

				<tr>
					<td class="td_left"><label for="hidden">숨김기능 : </label></td>
					<td class="td_right">
					<input type="radio" name="hidden" id="hidden" value="1" checked/>보이기
					<input type="radio" name="hidden" id="hidden" value="2" />숨김
				</tr>

				<tr>
					<td colspan="2" id="commandCell">
					<input type="submit" value="물품 추가" /> 
					<input type="reset" value="다시작성" /> 
					<input type="button" value="물품 목록으로"
						onClick="window.location.href='productList.pro'" /></td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>