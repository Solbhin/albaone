<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알바 등급 주기</title>
</head>
<body>
<form action="writeAlbarate" method="post" modelAttribute="Albarate">
	<p>알바명 : <input type="text" name="parttimename">
	<p>
		긍정적<input type="radio" name="rating" value="positive" id="positive"> 
		부정적<input type="radio" name="rating" value="negative" id="negative">
	</p>
	<p><input type="submit" value="등급주기">
</form>
</body>
</html>