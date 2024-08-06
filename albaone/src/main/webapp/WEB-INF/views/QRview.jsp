<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>QR 코드 보기</title>
</head>
<body>
    <h1>QR 코드</h1>
    <img src="data:image/png;base64,${qrCode}" alt="QR Code">
    <p><a href="QRform">다시 입력</a></p>
</body>
</html>
