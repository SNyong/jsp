<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="vo.MemberBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	MemberBean member = (MemberBean) request.getAttribute("memberFind");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#findId {
	margin: auto;
	width: 500px;
	border: 2px solid #B7F0B1;
}

#findId table {
	width: 450px;
	margin: auto;
	text-align: center;
}
</style>
</head>
<script>
	
</script>
<body>
	<section id="findId">
		<form name="findIdForm" action="findId.mem" method="post">
			<table>
				<c:choose>
					<c:when test="${memberFind.memberId ne null}">
						<tr>
							<td colspan="2">
								<h1>비밀번호 찾기</h1>
							</td>
						</tr>
						<tr>
							<td style="text-align: right"><label for="memberId">아이디 : </label></td>
							<td><input type="text" style="float:left" name="memberId" id="memberId"
								value="${memberFind.memberId }" /></td>
						</tr>
						<tr>
							<td style="text-align: right"><label for="name">이름 : </label></td>
							<td><input type="text" style="float:left" name="name" id="name"
								value="${memberFind.name }" required /></td>
						</tr>
						<tr>
							<td style="text-align: right"><label for="email">이메일 : </label></td>
							<td><input type="email" style="float:left" name="email" id="email"
								value="${memberFind.email }" required /></td>
						</tr>
						<tr>
						<tr>
							<td colspan="2">
								<button type="submit">비밀번호 찾기</button>
								<button onclick="loginForm.mem">로그인</button>
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="2">
								<h1>아이디 찾기</h1>
							</td>
						</tr>
						<tr>
							<td style="text-align: right"><label for="name">이름 : </label></td>
							<td><input type="text" style="float:left" name="name" id="name" required /></td>
						</tr>
						<tr>
							<td style="text-align: right"><label for="email">이메일 : </label></td>
							<td><input type="email" style="float:left" name="email" id="email" required /></td>
						</tr>
						<tr>
							<td colspan="2">
								<button type="submit">아이디 확인 및 비밀번호 찾기</button>
							</td>
						</tr>

					</c:otherwise>
				</c:choose>



			</table>
		</form>
	</section>
</body>
</html>