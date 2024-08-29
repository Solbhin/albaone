
    $(document).ready(function() {
        $(".delete-button").click(function() {
            var contractNum = $(this).attr("id"); // 버튼의 id를 통해 계약서 번호 가져오기

            // 확인 대화상자 표시
            if (confirm("정말로 이 계약서를 삭제하시겠습니까?")) {
                $.ajax({
                    url: '/albaone/empcomdel', // 삭제 요청을 보낼 URL
                    type: 'GET',
                    data: { num: contractNum }, // 계약서 번호 전송
                    success: function(response) {
                        alert(response); // 성공 메시지 표시
                        
                        // 계약서 삭제
                        $("#" + contractNum).remove(); // 계약서 행 삭제
                        $("#" + contractNum + "-details").remove(); // 상세 버튼 행 삭제
                    },
                    error: function(xhr, status, error) {
                        alert("삭제 중 오류가 발생했습니다. " + xhr.responseText); // 오류 메시지 표시
                    }
                });
            }
        });
    });
