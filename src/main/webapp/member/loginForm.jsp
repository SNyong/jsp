<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style>
#loginform {
   margin: auto;
   width: 500px;
   border: 2px solid #B7F0B1;
}

#loginform table {
   width: 450px;
   margin: auto;
   text-align: center;
}

</style>
</head>
<script>
   window.onload = function() {

      if (getCookie("memberId")) {
         document.loginform.userID.value = getCookie("memberId");
         document.loginform.id_rem.checked = true;
      }

   }

   function setCookie(name, value, expiredays) {
      var todayDate = new Date();
      todayDate.setDate(todayDate.getDate() + expiredays);
      document.cookie = name + "=" + escape(value) + "; path=/; expires="
            + todayDate.toGMTString() + ";"
   }

   function getCookie(Name) {
      var search = Name + "=";
      if (document.cookie.length > 0) {
         offset = document.cookie.indexOf(search);
         if (offset != -1) {
            offset += search.length;
            end = document.cookie.indexOf(";", offset);
            if (end == -1)
               end = document.cookie.length;
            return unescape(document.cookie.substring(offset, end));
         }
      }
   }

   function chkForm() {
      var memberId = document.getElementById("memberId")
      var memberPw = document.getElementById("memberPw")
      if (memberId.value.trim() == "") {
         alert("아이디를 입력하세요.");
         MemberId.focus();
         return false;
      }
      if (memberPw.value.trim() == "") {
         alert("비밀번호를 입력하세요.");
         MemberPw.focus();
         return false;
      }
      document.loginForm.submit();
   }
</script>
<body>
   <section id="loginform">
      <form name="loginForm" action="./memberLoginAction.mem" method="post"
         onclick="chkForm()">
         <table>
            <tr>
               <td colspan="2">
                  <h1>로그인 페이지</h1>
               </td>
            </tr>
            <tr>
               <td style="text-align: right"><label for="MemberId" >아이디 : </label></td>
               <td>
               <input type="text" style="float:left" name="MemberId" id="MemberId"
                  required/></td>
            </tr>
            <tr>
               <td style="text-align: right"><label for="MemberPw" >비밀번호 : </label></td>
               <td><input type="password"  style="float:left" name="MemberPw" id="MemberPw"
                   required/></td>
            </tr>
            <tr>
               <td colspan="2">
                  <button type="submit" >로그인</button>
                   <a href="memberJoin.mem"><input type="button" value="회원가입"  /></a>
               </td>
            </tr>
            <tr>
            <td colspan = "2">
            <a href="findIdForm.mem">아이디 /비밀번호찾기</a>
            </td>
            </tr>
         </table>
      </form>
   </section>
</body>
</html>