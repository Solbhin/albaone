<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/albaone/resources/css/registerBP.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>기업회원</title>
</head>
<body>
	<%@include file="menu.jsp" %>
    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="card" style="width: 30rem;">
            <div class="card-body">
             	<i class="bi bi-people-fill"></i>
                <h5 class="card-title text-center">기업회원 가입 </h5>
                <form action="./" method="post" modelAttribute="user" onsubmit="return validateForm()">
                    <div class="form-group">
                        <label for="username">아이디</label>
                        <div class="input-group">
                            <input type="text" class="form-control" name="id" value="${user.id}" placeholder="아이디" required>
                            <button type="button" class="btn btn-secondary" onclick="checkId()">중복 체크</button>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password">비밀번호</label>
                        <input type="password" class="form-control" id="password" name="password" value="${user.password}" placeholder="비밀번호" required>
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">비밀번호 확인</label>
                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="비밀번호 확인" required>
                    </div>
                    <div class="form-group">
                        <label for="name">이름</label>
                        <input type="text" class="form-control" name="name" value="${user.name}" placeholder="이름" required max="5">
                    </div>
                    <div class="form-group">
                        <label for="email">이메일</label>
                        <input type="email" class="form-control" name="email" value="${user.email}" placeholder="이메일" required>
                    </div>
					<div class="form-group">
                        <label for="phone">휴대폰</label>
                        <input type="text" class="form-control" name="phone" value="${user.phone}" placeholder="휴대폰" required>
                        <button type="button" class="btn btn-secondary mt-2 sendVerificationCode" onclick="sendVerificationCode()">인증 요청</button>
                    </div>
						<div class="form-group" id="verificationSection" style="display:none;">
					    <label for="verificationCode">인증 코드</label><span class="certificationTime">05:00</span>
					    <input type="text" class="form-control" id="verificationCode" placeholder="인증 코드를 입력하세요" required>
					    <button type="button" class="btn btn-primary mt-2" onclick="verifyCode()">인증 확인</button>
					    <!-- 인증 메시지를 표시할 div -->
					    <div id="verificationMessage" style="margin-top: 10px;"></div> 
					</div>
					<div class="form-group">
                        <label for="businessNumber">사업자 등록번호</label>
                        <input type="text" class="form-control" name="businessNumber" id="businessNumber" value="${user.businessNumber}" placeholder="사업자 등록번호(-빼고 입력)" required maxlength="10">
                        <small id="businessNumberMessage" class="text-danger"></small>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block mt-3" id="submitButton" disabled>회원가입</button>
                </form>
            </div>
        </div>
    </div>
    
	<!-- 본인 인증 테스트시 위에 자바스크립트를 주석처리하고 아래 링크를 주석 해제하고 사용 -->
	<!-- 유료 api, 테스트시 유의 - key를 깃에 올리지 말것 -->
	<script type="text/javascript" src="/albaone/resources/js/registerBusiness.js"></script>
	<%@include file="footer.jsp"%>
</body>
</html>
