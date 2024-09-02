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