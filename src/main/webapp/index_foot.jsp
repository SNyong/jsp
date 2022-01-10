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
	line-height:25px;

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
					<li>주소: 달구벌대로251안길 15  
					<br><br> email <br> dnjsah1234@gmail.com <br> aksen0524@naver.com<br><br>
						COPYRIGHT @ 2021
					</li>
				</ul>
			</div>
		</div>
	</footer>
</body>
</html>