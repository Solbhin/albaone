<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>급여 계산 결과</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <%@include file="menu.jsp" %>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">급여 조회</h1>
        
        <div class="text-center">
	        <form method="GET" action="salaryPersonal">
	        	<label for="monthInput">연도 및 월 선택: </label>
	        	<input type="month" name="yearMonth" value="${yearMonth}">
	        	<input type="submit" class="btn btn-secondary" value="선택">
	        </form>
	        <div class="text-right mt-3">
	        	<a href="severancePersonal" class="btn btn-primary">퇴직금 조회</a>
	        </div>
        </div>
        
		<div class="card mt-4" id="salaryCard">
			<h3>${yearMonth.year}년 ${yearMonth.monthValue}월</h3>
			<p>총 근무시간: ${workHours}시간 ${workMinutes}분</p>
			<p>시급: ${wage} 원</p>
			<p>월급: ${salary}원</p>
			<p>주휴수당: ${benefit} 원</p>
			<p class="font-weight-bold">합계: ${totalSalary}원</p>
		</div>


	</div>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- <script>
    function submitMonth(){
        var monthInput = document.querySelector('input[name="yearMonth"]').value;
        
        $.ajax({
            url: 'salaryPersonal/data',
            type: 'GET',
            data: { yearMonth: monthInput },
            dataType: 'json', // JSON 형식으로 응답을 기대함
            success: function(response){
                console.log(response);
                $('.card').html(`
                    <h3>${response.yearMonth.year}년 ${response.yearMonth.monthValue}월</h3>
                    <p>총 근무시간: ${response.workHours}시간</p>
                    <p>시급: ${response.minimumWage} 원</p>
                    <p>월급: ${response.salary}원</p>
                    <p>주휴수당: ${response.benefit} 원</p>
                    <p class="font-weight-bold">합계: ${response.totalSalary}원</p>
                `);
            },
            error: function(xhr, status, error) {
                console.error('Error occurred:', status, error); // 상태와 오류 메시지 출력
                alert('급여 정보를 가져오는 데 실패했습니다: ' + xhr.responseText);
            }
        });
    }
</script> -->
</body>
</html>