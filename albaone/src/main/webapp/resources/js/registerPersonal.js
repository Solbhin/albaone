//인증
function sendVerificationCode()
{
    var phoneNumber = document.querySelector('input[name="phone"]').value;

    $.ajax({
        url: "/albaone/sendCode",
        type: "post",
        data: { phone: phoneNumber },
        dataType: "text", // 서버 응답이 문자열일 경우
        success: function(response)
		{
            alert(response);
            document.getElementById("verificationSection").style.display = "block"; // 인증 코드 입력 섹션 보이기
            document.getElementById("verificationCode").value = ""; // 입력 필드 초기화
            document.getElementById("submitButton").disabled = true; // 회원가입 버튼 비활성화
        },
        error: function(error)
		{
			console.log("Error:", error);ㅃ
			alert("문자 발송에 실패했습니다.");
        }
    });
}


var idCheckPassed = false; // 중복 확인 통과 여부
var verificationCheckPassed = false; // 인증 확인 통과 여부

// 중복 확인 함수
function checkId()
{
    var userId = document.querySelector('input[name="id"]').value;

    $.ajax({
        url: "idcheck.do",
        type: "post",
        data: userId,
        dataType: "json",
        contentType: "application/json; charset=UTF-8",
        success: function(data)
		{
            if (data.cnt > 0)
			{
                alert("아이디가 존재합니다. 다른 아이디를 입력해주세요");
                idCheckPassed = false; // 중복 확인 실패
                document.getElementById("submitButton").disabled = true; // 회원가입 버튼 비활성화
            }
			else
			{
                alert("사용 가능한 아이디입니다.");
                idCheckPassed = true; // 중복 확인 성공
                updateSubmitButtonState(); // 버튼 상태 업데이트
            }
        },
        error: function(error)
		{
            alert("error: " + error);
            idCheckPassed = false; // 중복 확인 실패
            document.getElementById("submitButton").disabled = true; // 회원가입 버튼 비활성화
        }
    });
}

// 인증 확인 함수
function verifyCode()
{
    var phoneNumber = document.querySelector('input[name="phone"]').value;
    var code = document.getElementById("verificationCode").value;

    $.post("/albaone/verifyCode",
        { phone: phoneNumber, code: code },
        function(response)
		{
            if (response.status === "success")
			{
                verificationCheckPassed = true; // 인증 성공
                document.getElementById("verificationMessage").innerHTML = response.message; // 성공 메시지
                document.getElementById("verificationMessage").style.color = "green"; // 성공 메시지 색상
                updateSubmitButtonState(); // 버튼 상태 업데이트
            }
			else
			{
                verificationCheckPassed = false; // 인증 실패
                document.getElementById("verificationMessage").innerHTML = response.message; // 실패 메시지
                document.getElementById("verificationMessage").style.color = "red"; // 실패 메시지 색상
                document.getElementById("submitButton").disabled = true; // 회원가입 버튼 비활성화
            }
        },
        "json" // 데이터 타입을 json으로 설정
    );
}

// 모든 유효성 검사를 통과해야 submit
document.querySelector('form').onsubmit = function()
{
    return validateIdCheck() && validateVerification() && validateForm();
};

// 버튼 상태 업데이트 함수
function updateSubmitButtonState()
{
    document.getElementById("submitButton").disabled = !(idCheckPassed && verificationCheckPassed);
}

// 비밀번호 확인 함수
function validateForm()
{
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;

    if (password !== confirmPassword)
	{
        alert("비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
        return false; // 제출 요청을 거절
    }

    return true; // 제출 요청 허용
}


var countTime = 0;
var intervalCall;

//시간 함수
$.time = function(time)
{
	countTime = time;
	intervalCall = setInterval(alertFunc, 1000);
}

$.closeTime = function()
{
	clearInterval(intervalCall);
}

function alertFunc()
{
	var min = Math.floor(countTime/60);
	var sec = countTime - (60 * min);
	
	if(sec > 9)
	{
		$('.certificationTime').text(min + ':' + sec + '');
	}
	else
	{
		$('.certificationTime').text(min + ':0' + sec + '');
	}
	if(countTime <= 0)
	{
		clearInterval(intervalCall);
	}
	
	countTime--;
};

//버튼 클릭시 셀 시간
$('.sendVerificationCode').on("click",
function()
{
    $.time(300);
});