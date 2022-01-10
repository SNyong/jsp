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
</html>