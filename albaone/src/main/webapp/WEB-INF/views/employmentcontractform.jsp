<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근로계약서</title>
</head>
<body>
    <form action="employmentcontract" method="post" modelAttribute="employment"  onsubmit="return validateWorkingHours();">
        <p>사업주명 : <input type="text" name="ownername" required ></p>
        <p>알바생명 : <input type="text" name="parttimename" required maxlength="5"></p>
        <p>근무 날짜 : <input type="date" name="period_start" required><input type="date" name="period_end" required></p>
        <p>근무장소 : <input type="text" name="place" maxlength="10"></p>
        <p>업무내용
        <p>
        	<textarea name="workdetail" rows="4" cols="50" placeholder="업무 내용을 입력하세요.">
        	</textarea>
        </p>
        <p>근무 시간 : <input type="text" name="workinghours_start"><input type="text" name="workinghours_end"></p>
        <p>주당 근무일 : <input type="text" name="workday" required></p>
        <p>임금 : <input type="number" name="money" required></p>
        <p>상여금 : <input type="number" name="bonus"></p>
        <p>보험 : <input type="text" name="insurance" maxlength="25"></p>
        <p>작성 날짜 : <input type="date" name="createdate" required></p>
        <p><input type="submit" value="등록"></p>
    </form>
    
    <script type="text/javascript">
	    function validateWorkingHours()
	    {
	        var startTime = document.querySelector('input[name="workinghours_start"]').value;
	        var endTime = document.querySelector('input[name="workinghours_end"]').value;
	
	     	// 00:00 ~ 23:59 패턴
	        var timePattern = /^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$/; 
	
	        if (!timePattern.test(startTime))
	        {
	            alert("시작 근무 시간은 00:00 형식으로 입력해야 합니다.");
	            return false; // 폼 제출 중단
	        }
	
	        if (!timePattern.test(endTime))
	        {
	            alert("종료 근무 시간은 00:00 형식으로 입력해야 합니다.");
	            return false; // 폼 제출 중단
	        }
	        return true; // 유효성 검사 통과
	    }
	</script>
</body>
</html>
