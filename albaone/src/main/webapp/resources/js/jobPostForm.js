$(document).ready(function()
{
	$('#jobPostingForm').on('submit', function(e)
	{
		e.preventDefault(); // 기본 제출 방지

        var workLocation = $('#workLocation').val();
		//ea5f195126c1462756ec14f150335455*/ //자바스크립트 키
		//ee07c830d492acf369ddf9a5a6a4ad54 //admin 키
        var apiKey = 'ee07c830d492acf369ddf9a5a6a4ad54';
        var geocodeUrl = 'https://dapi.kakao.com/v2/local/search/address.json?query=' + encodeURIComponent(workLocation);

		console.log("AJAX 요청 확인 : " + workLocation);
		
        $.ajax({
            url: geocodeUrl,
            type: 'GET',
            headers:
            {
                'Authorization': 'KakaoAK ' + apiKey
            },
            success: function(data)
			{
                if (data.documents.length > 0)
				{
                    // 주소가 유효한 경우
                    $('#addressError').hide(); // 오류 메시지 숨기기
                    $('#jobPostingForm').off('submit').submit(); // 폼 제출
                }
				else
				{
                    // 주소가 유효하지 않은 경우
                    $('#addressError').show(); // 오류 메시지 표시
                }
            },
            error: function()
			{
                $('#addressError').show(); // AJAX 요청 실패 시 오류 메시지 표시
            }
        });
    });
});