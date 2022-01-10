<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="vo.MemberBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	MemberBean member = (MemberBean) request.getAttribute("memberFind");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#idpw {
	margin: auto;
	width: 500px;
	border: 2px solid #B7F0B1;
}

#idpw table {
	width: 450px;
	margin: auto;
	text-align: center;
}
</style>
</head>
<body>
	<section id="idpw">
		<form name="idpwform" action="memberLoginAction.mem" method="post">
			<table>
				<tr>
					<td colspan="2">
						<h1>귀하의 아이디, 비밀번호는</h1>
					</td>
				</tr>
				<tr>
					<td><label for="MemberId">아이디 : </label></td>
					<td><input type="text" name="MemberId" id="MemberId"
						value="${memberFind.memberId }" /></td>
				</tr>

				<tr>
					<td><label for="MemberPw">비밀번호 : </label></td>
					<td><input type="text" name="MemberPw" id="MemberPw"
						value="${memberFind.memberPw }" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="바로 로그인하기"/>
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>