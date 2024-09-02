//파일 확장자 유효성 검사
function validateFile()
{
	var fileInput = document.querySelector('input[name="myimg"]');
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