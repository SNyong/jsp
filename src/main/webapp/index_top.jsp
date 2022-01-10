<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   String MemberId = null;
if (session.getAttribute("MemberId") != null) {
   MemberId = ((String) session.getAttribute("MemberId")).trim();
}
%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<style>
#index_top {
   /*    position: relative; */
   height: 210px;
/*      border-bottom: 1px solid #B7F0B1; */
}

#index_top .top1 {
   height: 100px;
}

#index_top .top1 ul {
   padding-top: 0px;
}

#index_top .left {
   /*    padding: 10px; */
   float: right;
   display: flex;
   margin: 10px;
}

#index_top .logo {
   left: 20px;
   font-size: 2.0em;
   float: left;
}

#index_top .logo span {
   color: #B7F0B1;
   font-weight: bold;
}

#index_top .menu {
   width: 100%;
   padding: 5px;
   display: flex;
   margin: 0px;
   /*    position: relative; */
   font:  1.2em;
   justify-content: center;
}

#index_top .menu li {
   width: 150px;
   margin: 0px 0px 0px 5px;
   font-size: 1.0em;
}

.menu2 {
   width: 100%;
   padding: 5px;
   display: flex;
   margin: 0px;
   /*    position: relative; */
   font:  1.2em;
   justify-content: center;
   background-color: #B7F0B1; 
}

.menu2 li {
   width: 150px;
   margin: 0px 0px 0px 5px;
   font-size: 1.2em;
}

@media only screen and (max-width : 960px) and (min-width : 701px) {
   /*데스크톱*/
    #index_top .menu {  
   flex-wrap: wrap; 
   align-content: center;
   justify-content : center;
   }
   
   .menu2 { 
   flex-wrap: wrap; 
   align-content: center;
   justify-content : center;
   margin: auto;   
   }
}
 
@media only screen and (max-width:700px) {
   /* 테블릿  CSS */
    #index_top .menu {  
   width: 400px;
   flex-wrap: wrap; 
   margin: auto;
    justify-content: center;
   } 
   
   .menu2{
   width: 400px; 
   flex-wrap: wrap; 
   margin: auto;
   }
}
</style>
</head>
<body>
   <header id="index_top">
      <div class="top1">
         <ul>
            <li class="logo">
               <h1>
                  <a href="main.pro"><span>Daily Sports</span></a>
               </h1>
            </li>
            <li class="left">
               <%
                  if (MemberId != null) {
               %> <a href="memberLogout.mem">로그아웃</a>&nbsp;&nbsp;
                  <a href="orderOkList.or?MemberId=<%=MemberId%>">내 주문목록</a>    
               <%
                   if (MemberId != null && MemberId.equals("smart21kph")) {
                %> <a href="admin.pro">관리자모드 접속</a> <%
                  }
            } else {
            %> <a href='loginForm.mem'>로그인</a> 
            <a href="memberJoin.mem">회원가입</a> <%
            }
            %>
         </li>
         </ul>
      </div>

      <div>

         <aside>
            <ul class="menu">
               <li><a href="">사이트 소개</a></li>
               <li><a href="itemList.pro?Category=1">물품구매</a></li>
               <li><a href="bucketList.buc">장바구니</a></li>
               <li><a href="mailSendForm.mem">고객문의</a></li>
               <%
                  if (MemberId != null) {
               %>
               <li><a href="memberModifyFormAction.mem?id=<%=MemberId%>">회원정보수정</a></li>
               <%
                  }
               %>
            </ul>
         </aside>
      </div>
         <ul class="menu2">
               <li><a href="itemList.pro?Category=1" name="c" id="c">축구</a></li>
               <li><a href="itemList.pro?Category=2" name="b" id="b">야구</a></li>
               <li><a href="itemList.pro?Category=3" name="g" id="g">골프</a></li>
               <li><a href="itemList.pro?Category=4" name="t" id="t">테니스</a></li>
         </ul>
   </header>

            <br><br>
</body>
</html>