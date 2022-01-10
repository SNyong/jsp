<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DailySports</title>
<style>
#mail table {
	width: 700px;
	margin: auto;
	border: 2px solid #B7F0B1;
}

#mail h1 {
	text-align: center;
}

#mail td {
	
}
</style>
</head>

<body>
	<section id="mail">
		<form name="mailSendForm" action="./mailSend.mem" method="post">
			<input type="hidden" name="receiver" value="dnjsah1234@naver.com">
			<h1>고객 문의</h1>
			<table>

				<tr>
					<td>이름 :</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>보내는 사람 메일 :</td>
					<td><input type="email" name="sender"></td>
				</tr>
				<tr>
					<td>제목 :</td>
					<td><input type="text" name="subject"></td>
				</tr>
				<tr>
					<td><h3>내용 :</h3></td>
					<td><textarea name="content" cols=60 rows=20></textarea></td>
				</tr>
				<tr>
					<td align=center colspan=2><input type="submit" value="보내기">
						<button>
							<a href="index.jsp">홈으로</a>
						</button></td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>