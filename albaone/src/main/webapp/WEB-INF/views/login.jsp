<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/albaone/resources/css/login.css">
<title>로그인</title>
</head>
<body>
<%@include file="menu.jsp" %>
    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="card" style="width: 20rem;">
            <div class="card-body">
                <h5 class="card-title text-center">개인 / 기업 로그인</h5>
                <form action="login" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control" name="id" placeholder="아이디" required>
                    </div>
                    <div class="form-group mt-2">
                        <input type="password" class="form-control" name="password" placeholder="비밀번호" required>
                    </div>
                    <div class="d-flex justify-content-between mt-3">
                        <button type="submit" class="btn btn-primary">로그인</button>
                    </div>
                    <div>
                    	<a href="register" class="btn btn-secondary">회원가입</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
<%@include file="footer.jsp"%>
</body>
</html>