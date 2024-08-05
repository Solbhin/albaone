<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QR 조회</title>
</head>
<body>
	<h1>QR 조회</h1>
	<form action="QRread" method="post" modelAttribute="QRread">
		<p>알바생명 : <input type="text" name="id">
		<input type="submit" value="QR 조회하기">
	</form>
</body>
</html>