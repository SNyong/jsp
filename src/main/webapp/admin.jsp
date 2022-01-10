<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<style>
* {
	margin: 10px;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: "돋움"
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

#admin {
	width: 1200px;
}

#adminl { /* 사이드 바 */
	float: left;
	width: 250px;
	height: 600px;
	padding: 15px;
   border: 2px solid #B7F0B1;
	/* 	position: relative; */
}

#adminl li {
	margin: 0px 0px 10px 0px;
	font-size: 2.0em;
}

#admins { /* 본문 */
	float: right;
	width: 900px;
	height: 600px;
	padding: 15px;
   border: 2px solid #B7F0B1;
	/* 	position: relative; */
}
#adminl .mini{
text-align : left;
font-size : 1.3em;
padding-left: 60px;
}
</style>
</head>
<body>
	<section id="admin">
		<aside id="adminl">
			<ul>
				<li><a href="memberListAction.mem">회원관리</a></li>
				<li></li>
				<li><a href="./productList.pro">물품관리</a></li>
				<li class="mini"><a href="./productList.pro?category=1">- 축구</a></li>
				<li class="mini"><a href="./productList.pro?category=2">- 야구</a></li>
				<li class="mini"><a href="./productList.pro?category=3">- 골프</a></li>
				<li class="mini"><a href="./productList.pro?category=4">- 테니스</a></li>
			</ul>
		</aside>

		<section id="admins">
			<c:choose>
				<c:when test="${pagefile2 ne null }">
					<jsp:include flush="true" page='${pagefile2}' />
				</c:when>
				<c:otherwise>
					<h1>메뉴를 선택해 주세요.</h1>
				</c:otherwise>
			</c:choose>
		</section>
	</section>
</body>
</html>