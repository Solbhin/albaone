<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근로계약서</title>
</head>
<body>
    <form action="employmentcontract" method="post" modelAttribute="employment" enctype="multipart/form-data" onsubmit="return validateFile()">
        <p>사업주명 : <input type="text" name="ownername" value="${id}" readonly></p>
        <p>사업자 번호 : <input type="text" name="businessNumber" value="${BusinessNumber}" readonly></p>
        <p>알바생명 : <input type="text" name="parttimename"></p>
        <p>근무 날짜 : <input type="date" name="period_start"><input type="date" name="period_end"></p>
        <p>근무장소 : <input type="text" name="place"></p>
        <p>업무내용 : <input type="text" name="workdetail"></p>
        <p>근무 시간 : <input type="text" name="workinghours_start"><input type="text" name="workinghours_end"></p>
        <p>주당 근무일 : <input type="text" name="workday"></p>
        <p>임금 : <input type="text" name="money"></p>
        <p>상여금 : <input type="text" name="bonus"></p>
        <p>보험 : <input type="text" name="insurance"></p>
        <p>작성 날짜 : <input type="date" name="createdate"></p>
        <p>사인 : <input type="file" name="sinefile"></p>
        <p><input type="submit" value="등록"></p>

        <input type="hidden" value="${apply_id}" name="apply_id">
        <input type="hidden" value="${status}" name="status">
        <input type="hidden" value="${postNumber}" name="postNumber">  
    </form>
    
    <!-- 이미지 파일인 경우에만 sumbmit -->
    <script>
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
    </script>
</body>
</html>
