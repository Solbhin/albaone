<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QR 입력폼</title>
</head>
<body>
	<h1>QR 입력폼</h1>
	<form action="QRcreate" method="post" modelAttribute="QRcreate">
		<p>알바생명 : <input type="text" name="id"></p>
		<%
			// 현재 시각을 가져오기 로컬 데이트 타임
			LocalTime currentTime = LocalTime.now();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			String formattedTime = currentTime.format(formatter);
		%>
		<input type="hidden" name="today" value="<%= formattedTime %>">
		<p><input type="submit" value="QR 생성"></p>
	</form>
</body>
</html>

