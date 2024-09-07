function handleClick(event, element)
{
	// 현재 상태 가져오기
    var status = element.getAttribute("data-status");

    // 상태가 '수락'일 경우 클릭 이벤트를 취소
    if (status === '수락')
    {
        event.preventDefault(); // 기본 동작 차단
        alert("이미 수락된 상태입니다."); // 사용자에게 알림
        return; // 함수를 종료
    }

    // AJAX 요청을 통해 상태 업데이트
    var url = element.getAttribute("href");

    // Fetch API를 사용하여 AJAX 요청
    fetch(url)
        .then(response =>
        {
            if (response.ok)
            {
                // 요청이 성공하면 페이지 이동
                window.location.href = url; // 페이지 이동
            }
            else
            {
                alert("상태 업데이트에 실패했습니다.");
            }
        })
        .catch(error =>
        {
            console.error('Error:', error);
            alert("오류가 발생했습니다.");
        });
	// 기본 동작 차단 (링크 이동 방지)
    event.preventDefault(); 
}