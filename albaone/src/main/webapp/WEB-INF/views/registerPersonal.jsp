<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/albaone/resources/css/registerBP.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>개인회원</title>
</head>
<body>
	<%@include file="menu.jsp" %>
    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="card" style="width: 30rem;">
            <div class="card-body">
             	<i class="bi bi-person-fill"></i>
                <h5 class="card-title text-center">개인회원 가입</h5>
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
                        <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호" required>
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">비밀번호 확인</label>
                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="비밀번호 확인" required>
                    </div>
                    <div class="form-group">
                        <label for="name">이름</label>
                        <input type="text" class="form-control" name="name" placeholder="이름" required>
                    </div>
                    <div class="form-group">
                        <label for="email">이메일</label>
                        <input type="email" class="form-control" name="email" placeholder="이메일" required>
                    </div>
					<div class="form-group">
					    <label for="phone">휴대폰</label>
					    <input type="text" class="form-control" name="phone" placeholder="휴대폰" required>
					    <button type="button" class="btn btn-secondary mt-2 sendVerificationCode" onclick="sendVerificationCode()">인증 요청</button>
					</div>
					<div class="form-group" id="verificationSection" style="display:none;">
					    <label for="verificationCode">인증 코드</label><span class="certificationTime">05:00</span>
					    <input type="text" class="form-control" id="verificationCode" placeholder="인증 코드를 입력하세요" required>
					    <button type="button" class="btn btn-primary mt-2" onclick="verifyCode()">인증 확인</button>
					    <!-- 인증 메시지를 표시할 div -->
					    <div id="verificationMessage" style="margin-top: 10px;"></div> 
					</div>
                    <button type="submit" class="btn btn-primary btn-block mt-3" id="submitButton" disabled>회원가입</button>
                </form>
            </div>
        </div>
    </div>
    
<!-- <script>
   	var idck = 0;
   	const submitButton = document.getElementById('submitButton');
    function checkId() {
        var userId = document.querySelector('input[name="id"]').value;
        
        $.ajax({
        	url : "idcheck.do",
        	type : "post",
        	data : userId,
        	dataType : "json",
        	contentType : "application/json; charset=UTF-8",
        	success : function(data) {
        		if(data.cnt > 0) {
        			alert("아이디가 존재합니다. 다른 아이디를 입력해주세요");
        			submitButton.disabled = true;
        		} else {
        			alert("사용 가능한 아이디입니다.");
        			idck = 1;
        			submitButton.disabled = false;
        		}
        	},
        	error : function(error) {
        		alert("error : " + error);		
        	}
        });
    }
    
    function validateForm() {
        var password = document.getElementById("password").value;
        var confirmPassword = document.getElementById("confirmPassword").value;

        if (password !== confirmPassword) {
            alert("비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
            return false; // 제출 요청을 거절
        }
        return true; // 제출 요청 허용
    }
</script> -->

 <!--본인 인증 테스트시 위에 자바스크립트를 주석처리하고 아래 링크를 주석 해제하고 사용  -->
<!-- 유료 api, 테스트시 유의 - key를 깃에 올리지 말것 -->
<script type="text/javascript" src="/albaone/resources/js/registerPersonal.js"></script>
<%@include file="footer.jsp"%>
</body>
</html>