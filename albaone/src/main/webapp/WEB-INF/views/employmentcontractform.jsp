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
        <p>사업주명 : <input type="text" name="ownername" value="${user.name}" readonly></p>
        <p>사업자 번호 : <input type="text" name="businessNumber" value="${BusinessNumber}" readonly></p>
        <p>사업주 전화번호 : <input type="text" name="ownerPhone" value="${ user.phone }">
        <p>사업주 주소 : <input type="text" name="owneraddr" maxlength="40">
        <p>알바생명 : <input type="text" name="parttimename" value="${parttimename }"></p>
        <p>알바생 전화번호 : <input type="text" name="parttimePhone" value="${parttimephone}" maxlength="11">
        <p>알바생 주소 : <input type="text" name="parttimeaddr" value="${parttimeaddress}" maxlength="40">
        <p>근무 날짜 :
        	<input type="date" name="period_start">
        	<input type="date" name="period_end" required>
        </p>
        <p>근무장소 : <input type="text" name="place" required></p>
        <p>업무내용
        <p><textarea rows="2" cols="50" name="workdetail" placeholder="업무 내용을 입력하세요"></textarea>
        <p>근무 시작 시간
        	<input type="checkbox" id="startCheckbox" onchange="toggleWorkingHoursStart()"> 직접 입력
	        <select id="workinghours_start" name="workinghours_start">
				<option value="00:00">00:00</option>
				<option value="00:30">00:30</option>
				<option value="01:00">01:00</option>
				<option value="02:30">02:30</option>
				<option value="02:00">02:00</option>
				<option value="03:30">03:30</option>
				<option value="03:00">03:00</option>
				<option value="04:00">04:00</option>
				<option value="04:30">04:30</option>
				<option value="05:00">05:00</option>
				<option value="05:30">05:30</option>
				<option value="06:30">06:30</option>
				<option value="06:00">06:00</option>
				<option value="07:00">07:00</option>
				<option value="07:30">07:30</option>
				<option value="08:00">08:00</option>
				<option value="08:30">08:30</option>
				<option value="09:00">09:00</option>
				<option value="09:30">09:30</option>
				<option value="10:00">10:00</option>
				<option value="10:30">10:30</option>
				<option value="11:00">11:00</option>
				<option value="11:30">11:30</option>
				<option value="12:00">12:00</option>
				<option value="12:30">12:30</option>
				<option value="13:00">13:00</option>
				<option value="13:30">13:30</option>
				<option value="14:00">14:00</option>
				<option value="14:30">14:30</option>
				<option value="15:00">15:00</option>
				<option value="15:30">15:30</option>
				<option value="16:00">16:00</option>
				<option value="16:30">16:30</option>
				<option value="17:00">17:00</option>
				<option value="17:30">17:30</option>
				<option value="18:00">18:00</option>
				<option value="18:00">18:30</option>
				<option value="19:00">19:00</option>
				<option value="19:30">19:30</option>
				<option value="20:00">20:00</option>
				<option value="20:30">20:30</option>
				<option value="21:00">21:00</option>
				<option value="21:30">21:30</option>
				<option value="22:00">22:00</option>
				<option value="22:30">22:30</option>
				<option value="23:00">23:00</option>
				<option value="23:30">23:30</option>
			</select>
			<input type="text" id="workinghours_start_input" name="workinghours_start" placeholder="근무 시작 시간" style="display:none">
        <p>근무 종료 시간
        	<input type="checkbox" id="endCheckbox" onchange="toggleWorkingHoursEnd()"> 직접 입력
        	<select id="workinghours_end" name="workinghours_end">
				<option value="00:00">00:00</option>
				<option value="00:30">00:30</option>
				<option value="01:00">01:00</option>
				<option value="02:30">02:30</option>
				<option value="02:00">02:00</option>
				<option value="03:30">03:30</option>
				<option value="03:00">03:00</option>
				<option value="04:00">04:00</option>
				<option value="04:30">04:30</option>
				<option value="05:00">05:00</option>
				<option value="05:30">05:30</option>
				<option value="06:30">06:30</option>
				<option value="06:00">06:00</option>
				<option value="07:00">07:00</option>
				<option value="07:30">07:30</option>
				<option value="08:00">08:00</option>
				<option value="08:30">08:30</option>
				<option value="09:00">09:00</option>
				<option value="09:30">09:30</option>
				<option value="10:00">10:00</option>
				<option value="10:30">10:30</option>
				<option value="11:00">11:00</option>
				<option value="11:30">11:30</option>
				<option value="12:00">12:00</option>
				<option value="12:30">12:30</option>
				<option value="13:00">13:00</option>
				<option value="13:30">13:30</option>
				<option value="14:00">14:00</option>
				<option value="14:30">14:30</option>
				<option value="15:00">15:00</option>
				<option value="15:30">15:30</option>
				<option value="16:00">16:00</option>
				<option value="16:30">16:30</option>
				<option value="17:00">17:00</option>
				<option value="17:30">17:30</option>
				<option value="18:00">18:00</option>
				<option value="18:00">18:30</option>
				<option value="19:00">19:00</option>
				<option value="19:30">19:30</option>
				<option value="20:00">20:00</option>
				<option value="20:30">20:30</option>
				<option value="21:00">21:00</option>
				<option value="21:30">21:30</option>
				<option value="22:00">22:00</option>
				<option value="22:30">22:30</option>
				<option value="23:00">23:00</option>
				<option value="23:30">23:30</option>
			</select>
			<input type="text" id="workinghours_end_input" name="workinghours_end" placeholder="근무 종료 시간" style="display:none">
        <p>주당 근무일 : <input type="text" name="workday" required></p>
        <p>임금 : <input type="number" name="money" min="9860" required></p>
        <p>상여금 : <input type="number" name="bonus"></p>
        <p>보험 : <input type="text" name="insurance"></p>
        <p>작성 날짜 : <input type="date" name="createdate" required></p>
        <p>사업주 사인 : <input type="file" name="sinefileowner" required></p>
        <!-- 사업주가 알바생 사인을 바로 받기는 힘들기 때문에 required 속성은 뺌 -->
        <p>알바생 사인 : <input type="file" name="sinefileparttime"></p>
        <p><input type="submit" value="등록"></p>

        <input type="hidden" value="${apply_id}" name="apply_id">
        <input type="hidden" value="${status}" name="status">
        <input type="hidden" value="${postNumber}" name="postNumber">  
    </form>
    
    <script type="text/javascript">
       function validateFile()
       {
           var fileInput = document.querySelector('input[name="sinefileowner"]');
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
       
       function toggleWorkingHoursStart()
       {
           var startSelect = document.getElementById('workinghours_start');
           var startInput = document.getElementById('workinghours_start_input');
           var checkbox = document.getElementById('startCheckbox');

           if (checkbox.checked)
           {
               startSelect.style.display = 'none';
               startInput.style.display = 'inline';
           }
           else
           {
               startSelect.style.display = 'inline';
               startInput.style.display = 'none';
           }
       }
       
       function toggleWorkingHoursEnd()
       {
           var endSelect = document.getElementById('workinghours_end');
           var endInput = document.getElementById('workinghours_end_input');
           var checkbox = document.getElementById('endCheckbox');

           if (checkbox.checked)
           {
               endSelect.style.display = 'none';
               endInput.style.display = 'inline';
           }
           else
           {
               endSelect.style.display = 'inline';
               endInput.style.display = 'none';
           }
       }
   </script>
</body>
</html>
