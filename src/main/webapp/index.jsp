<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DailySports</title>
<style type="text/css">
* {
	margin: 10px;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: "돋움";
}

a:link, a:visited, a:hover, a:active {
	text-decoration: none;
	color: #000000;
}

a: link, a: visited, a: hover, a:active {
	text-decoration: none;
	color: #000000;
}

li {
	list-style-type: none;
}

table.t {
	margin: auto;
	width: 95%;
}

.top {
height: 200px;
}
.center1 {
	height: 400px;
}

@media only screen and (min-width:768px) {
	/* 테블릿  CSS */
}


@media only screen and (min-width : 1200px) {


}
</style>
</head>
<body>

	<table class="t">
		<tr class="top">
			<td align="center">


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
                <a href='loginForm.mem'>로그인</a> 
            <a href="memberJoin.mem">회원가입</a> 
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
			</td>
			<td>
			<br>
			</td>
		</tr>
		<tr class="center1">
			<td align="center">


<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<style>

.index {
   height: auto;
   display: block;
}

/* 슬라이드 배너 */
.slider {
   display: block;
   width: 98%;
   height: 400px;
   /*             background: linear-gradient( to bottom, #2E2E2E, #086A87, white ); */
   overflow: hidden;
   position: relative;
   text-align: center;
}

slider>* {
   position: absolute;
   display: block;
   width: 50%;
   height: 90%;
   /*background: linear-gradient( to bottom, #2E2E2E, #086A87, white );*/
   animation: slide 12s infinite;
   overflow: hidden;
}

slide:nth-child(1) {
   left: 100%;
   animation-delay: 0s;
   background-size: cover;
   background-position: center;
}

slide:nth-child(2) {
   left: 100%;
   animation-delay: 3s;
   background-image:
   background-size: cover;
   background-position: center;
}

slide:nth-child(3) {
   left: 100%;
   animation-delay: 6s;
   background-size: cover;
   background-position: center;
}

slide:nth-child(4) {
   left: 100%;
   animation-delay: 9s;
   background-size: cover;
   background-position: center;
}

slide p {
   font-family: Comfortaa;
   font-size: 70px;
   text-align: center;
   display: inline-block;
   width: 100%;
   margin-top: 30px;
   color: #fff;
}

 @keyframes slide {
            0% { left: 100%; width: 100%;}
            5% { left: 0%;}
            25% { left: 0%;}
            30% { left: -100%; width: 100%;}
            30.0001% { left: -100%; width: 0%;}
            100% { left: 100%; width: 0%;}
      }

.index border {
   width: 100%;
   position: relative
}

.index .item {
   width: 300px;
   height: 300px;
   margin: 0 auto;
   position: relative;
}

.item ul {
   list-style-type: none;
   border: 0px solid yellow;
   display: flex;
   justify-content: center;
   padding: 20px;
}

.index img {
   width: 80%;
}

@media only screen and (max-width : 960px) and (min-width : 701px) {
   /*데스크톱*/
    .item ul { 
   height: 1000px;  
   flex-wrap: wrap; 
   align-content: center;
   justify-content : center;
   } 
   
   .slider{
   top: 100px;
   }
}
 
@media only screen and (max-width:700px) {
   /* 테블릿  CSS */
   
    .item ul { 
   width: 40%;
   height: 1200px;  
   flex-wrap: wrap; 
   margin: auto;
   } 
}
</style>
</head>
<body>
<section id="index">
<div class="slider">
   <slider> 
   <slide>
      <p>
         <img src="./image/slide1.jpg">
      </p>
   </slide>
    <slide>
      <p>
         <img src="./image/slide2.jpg">
      </p>
   </slide> 
   <slide>
      <p>
         <img src="./image/slide3.jpg">
      </p>
   </slide> 
   <slide>
      <p>
         <img src="./image/slide4.jpg">
      </p>
   </slide>
    </slider>
</div>

<div class="item">
   <ul>
      <li><a href="itemList.pro?Category=1"> 
      <img src="./image/Football.png">
      </a></li>

      <li><a href="itemList.pro?Category=2"> 
      <img src="./image/Baseball.png">
      </a></li>

      <li><a href="itemList.pro?Category=3"> 
      <img src="./image/Tennis.png">
      </a></li>

      <li><a href="itemList.pro?Category=4"> 
      <img src="./image/Golf.png">
      </a></li>
   </ul>
</div>
</section>
</body>
</html></td>
		</tr>
		<tr class="footer">
			<td align="center">


<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<style>

#index_foot {
	/* 	color: block; */
	/* 	background-color: black; */
	padding-bottom: 80px;
	border-top: 2px solid #B7F0B1;
	margin: 0px;
	padding: 0px;
}

#index_foot .box {
	width: 100%;
	height: 150px;
	top: 20px;
	margin: 0px;
	padding: 0px;
}

#index_foot .box div {
	padding: 10px;
	display: flex;
	width: 100%;
	flex-direction: column;
	margin: 0px;
	padding: 0px;
}

/* #index_foot .box { */
/* 	width: 700px; */
/* 	height: 150px; */
/* 	padding: 20px; */
/* 	left: 100px; */
/* 	top: 20px; */
/* } */
/* #index_foot .box div { */
/* 	padding: 10px; */
/* 	display: flex; */
/* } */

/* #index_foot .box box1 { */
/* 	padding: 10px; */
/* 	border:  1px solid gray; */
/* } */

/* #index_foot .box box1 ul { */
/* 	padding: 10px; */
/* } */

.box {
	/* 	max-width:800px; */
/* 	height: 500px; */
/* 	position: relative; */
}
#index_foot  .left {

	widtht: 40%;
	margin: 0px;
	padding: 0px;

}

#index_foot .rigth {
	widtht: 40%;
	margin: 0px;
	padding: 0px;

}
#index_foot ul {
	list-style-type: none;
	width: 100%;

	margin: 0px;
	padding: 0px;
}


@media only screen and (min-width:768px) {
	/* 테블릿  CSS */
	#index_foot .box div {
margin: 0px;
	padding: 0px;
	display: flex;
	width: 100%;

	flex-direction: row;
}
}


@media only screen and (min-width : 1200px) {
#index_foot .box div {
margin: 0px;
	padding: 0px;
	display: flex;
	width: 100%;

	flex-direction: row;
}

}
</style>
</head>
<body>
<br><br>
	<footer id="index_foot">
		<div class="box">
			<div class="box1">
				<ul class="left">
					<li><h2>고객 센터</h2></li>
					<li><h2>Tel: 1588-1588</h2></li>
				</ul>
				<ul class="rigth">
					<li>주소: 대구시 <br> email: asdf@naver.com <br>
						COPYRIGHT @ 2021
					</li>
				</ul>
			</div>
		</div>
	</footer>
</body>
</html>
			</td>
		</tr>

	</table>
</body>
</html>