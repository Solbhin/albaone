<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이력서 삭제</title>
</head>
<body>
    <h1>근로 계약서 삭제</h1>
    <form action="deleteContract" method="post">
        알바생명: <input type="text" name="parttimename" required>
        <button type="submit">삭제</button>
    </form>
</body>
</html>