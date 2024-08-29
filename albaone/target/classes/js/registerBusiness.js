var isBusinessNumberValid = false;

//사업자 번호 api를 이용한 유효성검사 함수
function checkBusinessNumber()
{
	var businessNumber = $('#businessNumber').val();
	var businessNumberMessage = $('#businessNumberMessage');

	// 사업자 등록번호 형식 검사 (10자리 숫자)
	var businessNumberRegex = /^\d{10}$/;
	if (!businessNumberRegex.test(businessNumber))
	{
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
		success: function(result)
		{
			if (result.status_code === "OK")
			{
				if (result.data[0].tax_type !== "")
				{
					businessNumberMessage.text("유효한 사업자 등록번호입니다.");
					businessNumberMessage.removeClass("text-danger").addClass("text-success");
					isBusinessNumberValid = true;
				}
				else
				{
					businessNumberMessage.text("유효하지 않은 사업자 등록번호입니다.");
					businessNumberMessage.removeClass("text-success").addClass("text-danger");
					isBusinessNumberValid = false;
				}
			}
			else
			{
				businessNumberMessage.text("사업자 등록번호 확인 중 오류가 발생했습니다.");
				businessNumberMessage.removeClass("text-success").addClass("text-danger");
				isBusinessNumberValid = false;
			}
		},
		error: function(result)
		{
			businessNumberMessage.text("서버와 통신 중 오류가 발생했습니다.");
			businessNumberMessage.removeClass("text-success").addClass("text-danger");
			isBusinessNumberValid = false;
		}
	});
}

$(document).ready(
function()
{
	$('form').on('submit',
	function(e)
	{
		if (!isBusinessNumberValid)
		{
			e.preventDefault();
			alert("유효한 사업자 등록번호를 입력하세요.");
		}
	});
	
	$('#businessNumber').on('blur',
	function()
	{
		checkBusinessNumber();
	});
});

var idck = 0;
const submitButton = document.getElementById('submitButton');

//아이디 중복 검사
function checkId()
{
	var userId = document.querySelector('input[name="id"]').value;

	$.ajax({
		url : "idcheck.do",
		type : "post",
		data : userId,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data)
		{
			if(data.cnt > 0)
			{
				alert("아이디가 존재합니다. 다른 아이디를 입력해주세요");
				submitButton.disabled = true;
			}
			else
			{
				alert("사용 가능한 아이디입니다.");
				idck = 1;
				submitButton.disabled = false;
			}
		},
		error :
		function(error)
		{
			alert("error : " + error);
		}
	});
}
		
//비밀번호 확인
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
    return checkBusinessNumber() && checkId() && validateForm() && verifyCode();
};

// 버튼 상태 업데이트 함수
function updateSubmitButtonState()
{
    document.getElementById("submitButton").disabled = !(idCheckPassed && verificationCheckPassed);
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