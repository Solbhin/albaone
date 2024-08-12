<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
    .input-group {
        width: 100%;
    }
    .input-group-append {
        margin-left: -1px; /* 버튼과 경계가 겹치지 않도록 조정 */
    }
</style>
<title>기업회원</title>
</head>
<body>
	<%@include file="menu.jsp" %>
    
    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="card" style="width: 30rem;">
            <div class="card-body">
                <h5 class="card-title text-center">기업회원 가입</h5>
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
                        <label for="businessNumber">사업자 등록번호</label>
                        <input type="text" class="form-control" name="businessNumber" id="businessNumber" value="${user.businessNumber}" placeholder="사업자 등록번호(-빼고 입력)" required maxlength="10">
                        <small id="businessNumberMessage" class="text-danger"></small>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block mt-3" id="submitButton" disabled>회원가입</button>
                </form>
                <div class="text-center mt-3">
                    <a href="/albaone/login" class="btn btn-link">로그인 페이지로</a>
                </div>
            </div>
        </div>
    </div>
    
	<script>
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
	</script>
	
	<script>
    var isBusinessNumberValid = false;

    function checkBusinessNumber() {
        var businessNumber = $('#businessNumber').val();
        var businessNumberMessage = $('#businessNumberMessage');

        // 사업자 등록번호 형식 검사 (10자리 숫자)
        var businessNumberRegex = /^\d{10}$/;
        if (!businessNumberRegex.test(businessNumber)) {
            businessNumberMessage.text("올바른 사업자 등록번호를 입력하세요.");
            businessNumberMessage.removeClass("text-success").addClass("text-danger");
            isBusinessNumberValid = false;
            return;
        }

        var data = { "b_no": [businessNumber] };

        $.ajax({
            url: "https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=hJ4D%2F0pmhHozXC0XRoM5iOeccDvtvD0XdcRCaolcp5OGcxdpqyxqJj3wJuKkEQnBke%2F0NqLfl9W8CDCVvb7vOA%3D%3D",
            type: "POST",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            accept: "application/json",
            success: function(result) {
                if (result.status_code === "OK") {
                    if (result.data[0].tax_type !== "") {
                        businessNumberMessage.text("유효한 사업자 등록번호입니다.");
                        businessNumberMessage.removeClass("text-danger").addClass("text-success");
                        isBusinessNumberValid = true;
                    } else {
                        businessNumberMessage.text("유효하지 않은 사업자 등록번호입니다.");
                        businessNumberMessage.removeClass("text-success").addClass("text-danger");
                        isBusinessNumberValid = false;
                    }
                } else {
                    businessNumberMessage.text("사업자 등록번호 확인 중 오류가 발생했습니다.");
                    businessNumberMessage.removeClass("text-success").addClass("text-danger");
                    isBusinessNumberValid = false;
                }
            },
            error: function(result) {
                businessNumberMessage.text("서버와 통신 중 오류가 발생했습니다.");
                businessNumberMessage.removeClass("text-success").addClass("text-danger");
                isBusinessNumberValid = false;
            }
        });
    }

    $(document).ready(function() {
        $('form').on('submit', function(e) {
            if (!isBusinessNumberValid) {
                e.preventDefault();
                alert("유효한 사업자 등록번호를 입력하세요.");
            }
        });

        $('#businessNumber').on('blur', function() {
            checkBusinessNumber();
        });
    });
	</script>
</body>
</html>
