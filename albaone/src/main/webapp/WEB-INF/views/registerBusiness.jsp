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
        <div class="card" style="width: 30rem;">
            <div class="card-body">
                <h5 class="card-title text-center">기업회원 가입</h5>
                <form action="./" method="post" modelAttribute="user">
                                   <div class="form-group">
                        <label for="username">아이디</label>
                        <input type="text" class="form-control" name="id" value="${user.id}" placeholder="아이디" required>
                    </div>
                    <div class="form-group">
                        <label for="password">비밀번호</label>
                        <input type="password" class="form-control" name="password" value="${user.password}" placeholder="비밀번호" required>
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">비밀번호 확인</label>
                        <input type="password" class="form-control" name="confirmPassword" placeholder="비밀번호 확인" required>
                    </div>
                    <div class="form-group">
                        <label for="name">이름</label>
                        <input type="text" class="form-control" name="name" value="${user.name}" placeholder="이름" required>
                    </div>
                    <div class="form-group">
                        <label for="email">이메일</label>
                        <input type="email" class="form-control" name="email" value="${user.email}" placeholder="이메일" required>
                    </div>
					<div class="form-group">
                        <label for="phone">휴대폰</label>
                        <input type="text" class="form-control" name="phone" value="${user.phone}" placeholder="휴대폰" required>
                    </div>
					<div class="form-group">
                        <label for="phone">사업자 등록번호</label>
                        <input type="text" class="form-control" name="businessNumber" value="${user.businessNumber}" placeholder="사업자 등록번호" required>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">회원가입</button>
                </form>
                <div class="text-center mt-3">
                    <a href="/base/login" class="btn btn-link">로그인 페이지로</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>