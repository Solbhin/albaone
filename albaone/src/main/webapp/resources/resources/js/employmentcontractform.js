//시간 유효성 검사 - 직접 입력할 경우
function validateTimeFormat()
{
	var startInput = document.getElementById('workinghours_start_input');
	var endInput = document.getElementById('workinghours_end_input');
	var timePattern = /^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$/; // HH:MM 형식 정규 표현식

	// 시작 시간 유효성 검사
	if (startInput.style.display !== 'none')
	{
		if (!timePattern.test(startInput.value))
		{
			alert('근무 시작 시간은 HH:MM 형식이어야 합니다. (예: 12:00, 9:45)');
			return false;
		}
	}
	
	// 종료 시간 유효성 검사
	if (endInput.style.display !== 'none')
	{
		if (!timePattern.test(endInput.value))
		{
			alert('근무 종료 시간은 HH:MM 형식이어야 합니다. (예: 12:00, 9:45)');
			return false;
		}
	}
	return true; // 모든 유효성 검사를 통과한 경우
}
    
//근무시간 체크박스 함수 - 시작시간
function toggleWorkingHoursStart()
{
	var startSelect = document.getElementById('workinghours_start');
	var startInput = document.getElementById('workinghours_start_input');
	var checkbox = document.getElementById('startCheckbox');
	
	if (checkbox.checked)
	{
		startSelect.style.display = 'none';
		startInput.style.display = 'inline';
		startInput.value = ''; // 입력 필드 초기화
	}
	else
	{
		startSelect.style.display = 'inline';
		startInput.style.display = 'none';
		startSelect.selectedIndex = 0; // 선택된 항목 초기화
	}
}

//근무시간 체크박스 함수 - 종료시간
function toggleWorkingHoursEnd()
{
	var endSelect = document.getElementById('workinghours_end');
	var endInput = document.getElementById('workinghours_end_input');
	var checkbox = document.getElementById('endCheckbox');

	if (checkbox.checked)
	{
		endSelect.style.display = 'none';
		endInput.style.display = 'inline';
		startInput.value = ''; // 입력 필드 초기화
	}
	else
	{
		endSelect.style.display = 'inline';
		endInput.style.display = 'none';
		endSelect.selectedIndex = 0; // 선택된 항목 초기화
	}
}

//파일 확장자 유효성 검사 - 사장
function validateFileowner()
{
	var fileInput = document.querySelector('input[name="sinefileowner"]');
	var filePath = fileInput.value;
	var allowedExtensions = /(\.png|\.jpg|\.jpeg)$/i;

	if (!allowedExtensions.exec(filePath))
	{
		alert('유효한 이미지 파일만 업로드할 수 있습니다. (png, jpg, jpeg)');
		
		// 선택된 파일 초기화
		fileInput.value = '';
		
		// 제출 방지
		return false;
	}
	
	// 제출 허용
	return true;
}

//파일 확장자 유효성 검사 - 알바생
function validateFileparttime()
{
	var fileInput = document.querySelector('input[name="sinefileparttime"]');
	var filePath = fileInput.value;
	var allowedExtensions = /(\.png|\.jpg|\.jpeg)$/i;

	if (!allowedExtensions.exec(filePath))
	{
		alert('유효한 이미지 파일만 업로드할 수 있습니다. (png, jpg, jpeg)');
		
		// 선택된 파일 초기화
		fileInput.value = '';
		// 제출 방지
		return false; 
	}
	
	// 제출 허용
	return true; 
}

//근무 시작 날짜 유효성 검사
function validateDateStart()
{
	var startDateInput = document.querySelector('input[name="period_start"]');
	var startDate = new Date(startDateInput.value);
	var today = new Date();

	// 현재 날짜의 시간 부분을 0으로 설정
	today.setHours(0, 0, 0, 0); 
	
	if (startDate < today)
	{
		alert('근무 시작 날짜는 오늘 날짜 이후여야 합니다.');
		
		// 제출 방지
		return false; 
	}
	
	// 제출 허용
	return true; 
}

//계약 종료 날짜 유효성 검사
function validateDateEnd()
{
	var startDateInput = document.querySelector('input[name="period_start"]');
	var endDateInput = document.querySelector('input[name="period_end"]');
	var startDate = new Date(startDateInput.value);
	var endDate = new Date(endDateInput.value);
	
	if (endDate < startDate)
	{
		alert('계약 종료 날짜는 계약 날짜 이후여야 합니다.');
		
		// 제출 방지
		return false; 
	}

	// 제출 허용
	return true; 
}

// 계약 날짜 유효성 검사
function validateCreateDate()
{
	var createDateInput = document.querySelector('input[name="createdate"]');
	var createDate = new Date(createDateInput.value);
	var today = new Date();

	// 현재 날짜의 시간 부분을 0으로 설정
	today.setHours(0, 0, 0, 0); 

	if (createDate < today)
	{
		alert('작성 날짜는 오늘 날짜 이후여야 합니다.');
		
		//제출 방지
		return false; 
	}
	
	return true; // 제출 허용
}

document.querySelector('form').onsubmit = function()
{
	// 모든 유효성 검사를 통과해야 submit
	return validateTimeFormat() && validateFileowner() && validateFileparttime() && validateDateStart() && validateDateEnd() && validateCreateDate(); 
};