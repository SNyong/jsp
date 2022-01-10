<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
<%
	MemberBean member = (MemberBean) request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#Member_mod {
	width: 500px;
	margin: auto;
	border: 2px solid #B7F0B1;
}

#Member_mod table {
	width: 450px;
	margin: auto;
	text-align: center;
}

</style>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


</head>
<script>
	function searchAdress() {
		new daum.Postcode({
			oncomplete : function(data) {
				var addr = '';
				var extraAddr = '';

				if (data.userSelectedType === 'R') {
					addr = data.roadAddress;
				} else {
					addr = data.jibunAddress;
				}

				if (data.userSelectedType === 'R') {
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraAddr += data.bname;
					}

					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraAddr += (extraAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}

					if (extraAddr !== '') {
						extraAddr = ' (' + extraAddr + ')';
					}
				}

				$("#Post").val(data.zonecode);
				$("#Address").val(addr + extraAddr);
				$("#adresDet").focus();
			}
		}).open();
	}
</script>
<body>
	<section id="Member_mod">
		<form name="memberModform" action="./memberModifyAction.mem"
			method="post">
			<table>
				<tr>
					<td colspan="2">
						<h1>회원 정보 수정페이지</h1>
					</td>
				</tr>
				<tr>
					<td><label for="MemberId">아이디 : </label></td>
					<td><input type="text" name="MemberId" id="MemberId"
						value="<%=member.getMemberId()%>" required/></td>
				</tr>
				<tr>
					<td><label for="MemberPw">비밀번호 : </label></td>
					<td><input type="password" name="MemberPw" id="MemberPw"
						value="<%=member.getMemberPw()%>" required/></td>
				</tr>
				<tr>
					<td><label for="Name">이름 : </label></td>
					<td><input type="text" name="Name" id="Name"
						value="<%=member.getName()%>" required/></td>
				</tr>
				<tr>
					<td><label for="Number">전화 번호: </label></td>
					<td><input type="text" name="Number" maxlength="11"
						id="Number" value="<%=member.getNumber()%>" required /></td>
				</tr>
				<tr>
					<td><label for="Age">나이 : </label></td>
					<td><input type="text" name="Age" maxlength="2" id="Age"
						value="<%=member.getAge()%>" required/></td>
				</tr>
				<tr>
					<td><label for="Gender">성별 : </label></td>
					<td>
						<%
							if (member.getGender() == 1) {
						%> <input type="radio" id="Gender"
						name="Gender" value="1" checked />남자 <input type="radio"
						id="Gender" name="Gender" value="2" />여자 <%
 	}
 %> <%
 	if (member.getGender() == 2) {
 %>
						<input type="radio" id="Gender" name="Gender" value="1" />남자 <input
						type="radio" id="Gender" name="Gender" value="2" checked />여자 <%
							}
						%>
					</td>
				</tr>
				<tr>
					<td><label for="Email">이메일 주소 : </label></td>
					<td><input type="email" name="Email" id="Email"
						value="<%=member.getEmail()%>" required/></td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td>
						<div>
							<input type="number" id="Post" name="Post"
								onclick="searchAdress()" value="<%=member.getPost()%>"
								style="width: 100px;"> <input type="button"
								onclick="searchAdress()" value="우편번호 찾기">
						</div> <input type="text" name="Address" id="Address"
						value="<%=member.getAddress()%>" style="width: 300px;">
					</td>
				</tr>
				<tr>
					<td><label for="Address1">상세주소: </label></td>
					<td><input type="text" name="Address1" id="Address1"
						value="<%=member.getAddress1()%>" maxlength="60" required/></td>
				</tr>
				<tr>
					<td colspan="2"><a href="javascript:memberModform.submit()">수정하기</a>&nbsp;&nbsp;
						<a href="javascript:memberModform.reset()">다시작성</a>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>