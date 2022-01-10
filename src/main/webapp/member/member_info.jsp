<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="vo.MemberBean"%>

<%
	MemberBean member = (MemberBean) request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드(회원 정보 보기)</title>
<style>

#memberInfo {
	width: 550px;
	margin: auto;
	border: 2px solid #B7F0B1;
}

#memberInfo table {
	width: 500px;
	margin: auto;
	text-align: center;
	padding:10px;
}
#memberInfo table tr td {
padding:4px;
}


#memberInfo tr:nth-child(even) {background-color: #EAEAEA;} 
</style>
</head>
<body>
	<section id="memberInfo">
		<table>
			<tr>
				<td>아이디 :</td>
				<td><%=member.getMemberId()%></td>
			</tr>
			<tr>
				<td>비밀번호 :</td>
				<td><%=member.getMemberPw()%></td>
			</tr>
			<tr>
				<td>가입일</td>
				<td><%=member.getM_Date()%></td>
			</tr>
			<tr>
				<td>이름 :</td>
				<td><%=member.getName()%></td>
			</tr>
			<tr>
				<td>전화번호 :</td>
				<td><%=member.getNumber()%></td>
			</tr>
			<tr>
				<td>나이 :</td>
				<td><%=member.getAge()%></td>
			</tr>

			<tr>
				<td>성별 :</td>
				<td>
					<%
						if (member.getGender() == 1) {
					%> 남자 <%
						}
					%> <%
 	if (member.getGender() == 2) {
 %>
					여자 <%
 	}
 %>
				</td>
			</tr>
			<tr>
				<td>이메일 주소 :</td>
				<td><%=member.getEmail()%></td>
			</tr>

			<tr>
				<td>우편번호</td>
				<td><%=member.getPost()%></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><%=member.getAddress()%></td>
			</tr>
			<tr>
				<td>상세주소</td>
				<td><%=member.getAddress1()%></td>
			</tr>
			<tr>
				<td colspan=2><a href="memberListAction.mem">리스트로 돌아가기</a></td>
			</tr>
		</table>
	</section>
</body>
</html>