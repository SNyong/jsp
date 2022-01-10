<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#joinform {
	width: 700px;
	margin: auto;
	border: 2px solid #B7F0B1;
}

#joinform table {
	width: 650px;
	margin: auto;
	text-align: center;
}
#joinform table tr{
}
</style>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
    function check_pw(){
    	 
        var MemberPw = document.getElementById('MemberPw').value;
        var SC = ["!","@","#","$","%"];
        var check_SC = 0;

        if(MemberPw.length < 6 || MemberPw.length > 16){
            window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
            document.getElementById('MemberPw').value='';
        }
        for(var i=0;i<SC.length;i++){
            if(MemberPw.indexOf(SC[i]) != -1){
                check_SC = 1;
            }
        }
        if(check_SC == 0){
            window.alert('!,@,#,$,% 의 특수문자가 들어가 있지 않습니다.')
            document.getElementById('MemberPw').value='';
        }
        if(document.getElementById('MemberPw').value !='' && document.getElementById('MemberPw2').value!=''){
            if(document.getElementById('MemberPw').value==document.getElementById('MemberPw2').value){
                document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
                document.getElementById('check').style.color='blue';
            }
            else{
                document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
                document.getElementById('check').style.color='red';
            }
        }
    }
</script>
</head>
<body>
	<section id="joinform">
		<form name="joinform" action="./memberJoinAction.mem" method="post">
			<table>
				<tr>
					<td colspan="2">
						<h1>회원가입 페이지</h1>
					</td>
				</tr>
				<tr>
					<td><label for="MemberId">아이디 : </label></td>
					<td><input type="text" name="MemberId" id="MemberId" required/></td>
				</tr>
				<tr>
					<td><label for="MemberPw">비밀번호 : </label></td>
					<td><input type="password" placeholder="!,@,#,$,% 의 특수문자 필수" name="MemberPw" id="MemberPw" onchange="check_pw()" required/></td>
				</tr>
				           <tr>
                <td><label for="MemberPw2">비밀번호 확인 : </label></td>
                <td><input type="password" name="MemberPw2" id="MemberPw2" onchange="check_pw()" required><br><span id="check"></span></td>
            </tr>
				<tr>
					<td><label for="Name">이름 : </label></td>
					<td><input type="text" name="Name" id="Name" required/></td>
				</tr>
				<tr>
					<td><label for="Number">전화 번호: </label></td>
					<td><input type="text" name="Number" maxlength="11"
						id="Number" placeholder="-는 빼고 입력하세요" required /></td>
				</tr>
				<tr>
					<td><label for="Age">나이 : </label></td>
					<td><input type="text" name="Age" maxlength="2" id="Age" required /></td>
				</tr>
				<tr>
					<td><label for="Gender" >성별 : </label></td>
					<td><input type="radio" id="Gender" name="Gender" value="1" checked/>남자
						<input type="radio" id="Gender" name="Gender" value="2"/>여자
					</td>
				</tr>
				<tr>
					<td><label for="Email">이메일 주소 : </label></td>
					<td><input type="email" name="Email" id="Email" required/></td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td>
						<div>
							<input type="number" id="Post" name="Post"
								onclick="searchAdress()" placeholder="우편번호" style="width: 100px;"> <input
								type="button" onclick="searchAdress()" value="우편번호 찾기" required>
						</div> <input type="text" name="Address" id="Address" placeholder="주소" style="width: 200px; required">
					</td>
				</tr>
				<tr>
					<td><label for="Address1">상세주소: </label></td>
					<td><input type="text" name="Address1" id="Address1"
						maxlength="60" required/></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="회원가입"> &nbsp;&nbsp;
					<input type="reset" value="다시작성">
				</tr>
			</table>
		</form>
	</section>
</body>
</html>