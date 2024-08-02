<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<%@include file="menu.jsp" %>

    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="card" style="width: 25rem;">
            <div class="card-body text-center">
                <h5 class="card-title">회원가입 유형 선택</h5>
                <p class="card-text">원하는 회원 유형을 선택하세요.</p>
                <div class="d-flex justify-content-between">
                    <a href="register/personal" class="btn btn-primary btn-block mr-2">개인회원</a>
                    <a href="register/business" class="btn btn-secondary btn-block">기업회원</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>