<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>QR 뷰</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .card-container {
            display: flex;
            /* 수평 가운데 정렬 */
            justify-content: center; 
            /* 수직 가운데 정렬 */
            align-items: center;
            /* 화면 전체 높이로 설정 */
            height: 100vh; 
        }
        .card {
            padding: 15%;
        }
        .button-container {
        	/* 버튼과 이미지 사이의 간격 */
            margin-top: 20px; 
        }
    </style>
</head>
<body>

    <div class="container mt-5 card-container">
        <div class="card" style="width: 80%;">
            <div class="card-body">
                <h1 class="card-title text-center">QR 코드</h1>
                <c:if test="${not empty qrCodeUrl}">
                	<div class="text-center"><img src="${qrCodeUrl}" alt="QR Code" class="img-fluid" /></div>
	                <div class="button-container text-center">
	                	<button class="btn btn-primary" onclick="window.location.href='${qrUrl}'">QR 코드 URL로 요청</button>
	                	<button class="btn btn-primary" onclick="window.location.href='./'">홈으로</button>
	                	<button class="btn btn-primary" onclick="window.history.back()">뒤로가기</button>
	                </div>
                </c:if>
                <c:if test="${empty qrCodeUrl}">
                    <p>QR을 받아오지 못했습니다.</p>
                    <p><a href="./">홈으로 돌아가기</a></p>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>
