<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<td align="center"><jsp:include page="index_top.jsp"></jsp:include>
			</td>
			<td>
			<br>
			</td>
		</tr>
		<tr class="center1">
			<td align="center"><jsp:include page='${pagefile}' /></td>
		</tr>
		<tr class="footer">
			<td align="center"><jsp:include page="index_foot.jsp"></jsp:include>
			</td>
		</tr>

	</table>
</body>
</html>