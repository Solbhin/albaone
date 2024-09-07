<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>퇴직금 계산</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <form id="severanceForm" action="SeveranceCal" method="post" modelAttribute="Severance">
        <p>알바생명 : <input type="text" name="partname" value="${parttimename}" readonly></p>
        <p>임금 - 수정가능 : <input type="number" name="money" value="${money}"></p>
        <p>상여금 - 수정가능 : <input type="number" name="bonus" value="${bonus}"></p>
        <p>입사 날짜 : <input type="date" name="start" value="${periodStart}" readonly></p>
        <p>퇴직 날짜 - 수정가능 : <input type="date" name="day" value="${periodEnd}"></p>
        
        <p><input type="submit" value="지급"></p>
    </form>
    
    <script type="text/javascript">
        document.getElementById("severanceForm").addEventListener
        ("submit", function(event)
        	{
	        	var startDate = new Date(document.querySelector('input[name="start"]').value);
           		var endDate = new Date(endDateInput);
            
	            // 날짜 차이 계산
	            var timeDiff = endDate - startDate;
	         	// 밀리세컨드를 일로 변환
	            var dayDiff = timeDiff / (1000 * 3600 * 24); 
            
	            // 1년 미만일 경우
	            if (dayDiff < 365)
	            {
	                alert("퇴직 날짜가 입사 날짜로부터 1년이 되어야 합니다.");
	                event.preventDefault(); // 폼 제출 방지
	            }
        	});
    </script>
</body>
</html>