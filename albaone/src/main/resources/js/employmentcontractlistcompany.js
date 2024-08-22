$(document).ready(function()
{
	$(".delete-link").on("click", function(event)
	{
		// 기본 링크 클릭 동작 방지
		event.preventDefault();
		var link = $(this);
		var num = link.data("num"); // 데이터 속성에서 num 가져오기
		if (confirm('정말 삭제하시겠습니까?'))
		{
			$.ajax
			({
				url: "empcomdel",
				type: "GET",
				data: { num: num },
				success: function(response)
				{
					// 삭제가 성공적으로 이루어졌다면 해당 행을 삭제
					link.closest("tr").remove(); // 삭제된 행을 테이블에서 제거
				},
				error: function()
				{
					alert('삭제 중 오류가 발생했습니다. 다시 시도해 주세요.');
				}
			});
		}
	});
});