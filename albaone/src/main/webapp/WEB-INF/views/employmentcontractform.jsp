<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근로계약서</title>
</head>
<body>
	<%@include file="menu.jsp" %>
	
    <form action="employmentcontract" method="post" modelAttribute="employment" enctype="multipart/form-data">
        <p>사업주명 : <input type="text" name="ownername" value="${id}" readonly></p>
        <p>사업자 번호 : <input type="text" name="businessNumber" value="${BusinessNumber}" readonly></p>
        <p>알바생명 : <input type="text" name="parttimename" maxlength="5" required></p>
        <p>근무 날짜 :
        	<input type="date" name="period_start">
        	<input type="date" name="period_end" required>
        </p>
        <p>근무장소 : <input type="text" name="place" required></p>
        <p>업무내용
        <p><textarea rows="2" cols="50" name="workdetail" placeholder="업무 내용을 입력하세요"></textarea>
        <p>근무 시간 : <input type="text" name="workinghours_start"><input type="text" name="workinghours_end" required></p>
        <p>주당 근무일 : <input type="text" name="workday" required></p>
        <p>임금 : <input type="number" name="money" required></p>
        <p>상여금 : <input type="number" name="bonus"></p>
        <p>보험 : <input type="text" name="insurance"></p>
        <p>작성 날짜 : <input type="date" name="createdate" required></p>
        <p>사인 : <input type="file" name="sinefile" required></p>
        <p><input type="submit" value="등록"></p>

        <input type="hidden" value="${apply_id}" name="apply_id">
        <input type="hidden" value="${status}" name="status">
        <input type="hidden" value="${postNumber}" name="postNumber">  
    </form>
    
     <script type="text/javascript">
        function validateFile()
        {
            var fileInput = document.querySelector('input[name="sinefile"]');
            var filePath = fileInput.value;
            var allowedExtensions = /(\.png|\.jpg|\.jpeg)$/i;

            if (!allowedExtensions.exec(filePath))
            {
                alert('유효한 이미지 파일만 업로드할 수 있습니다. (png, jpg, jpeg)');
                fileInput.value = ''; // 선택된 파일 초기화
                return false; // 제출 방지
            }
            return true; // 제출 허용
        }
        
        function validateDateStart()
        {
            var startDateInput = document.querySelector('input[name="period_start"]');
            var startDate = new Date(startDateInput.value);
            var today = new Date();
            today.setHours(0, 0, 0, 0); // 현재 날짜의 시간 부분을 0으로 설정

            if (startDate < today)
            {
                alert('근무 시작 날짜는 오늘 날짜 이후여야 합니다.');
                return false; // 제출 방지
            }
            return true; // 제출 허용
        }

        function validateDateEnd()
        {
            var startDateInput = document.querySelector('input[name="period_start"]');
            var endDateInput = document.querySelector('input[name="period_end"]');
            var startDate = new Date(startDateInput.value);
            var endDate = new Date(endDateInput.value);

            if (endDate < startDate)
            {
                alert('계약 종료 날짜는 계약 날짜 이후여야 합니다.');
                return false; // 제출 방지
            }
            return true; // 제출 허용
        }

        function validateCreateDate()
        {
            var createDateInput = document.querySelector('input[name="createdate"]');
            var createDate = new Date(createDateInput.value);
            var today = new Date();
            today.setHours(0, 0, 0, 0); // 현재 날짜의 시간 부분을 0으로 설정

            if (createDate < today)
            {
                alert('작성 날짜는 오늘 날짜 이후여야 합니다.');
                return false; // 제출 방지
            }
            return true; // 제출 허용
        }

        document.querySelector('form').onsubmit = function()
        {
            // 모든 유효성 검사를 통과해야 submit
            return validateFile() && validateDateStart() && validateDateEnd() && validateCreateDate(); 
        };
    </script>
</body>
</html>
