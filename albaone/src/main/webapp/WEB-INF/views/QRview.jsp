<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>QR 뷰</title>
</head>
<body>
    <h1>QR 코드</h1>
    <c:if test="${not empty qrCodeUrl}">
        <img src="${qrCodeUrl}" alt="QR Code" />
        
        <p><a href="${qrUrl}">QR 찍기 테스트 - QR 코드 URL로 요청</a></p>
    </c:if>
    <c:if test="${empty qrCodeUrl}">
        <p>QR을 받아오지 못했습니다.
    </c:if>
    <p>${id}
    <p>${datetime}
    <p><a href="./">홈으로 돌아가기</a>
</body>
</html>