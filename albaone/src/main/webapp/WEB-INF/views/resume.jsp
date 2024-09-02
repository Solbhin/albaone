<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/albaone/resources/css/font.css">
<link rel="stylesheet" href="/albaone/resources/css/resume.css">
<title>이력서 등록</title>
</head>
<body>
<%@include file="menu.jsp" %>
<div class="container mt-5">
    <h2 class="text-center">아르바이트 지원서</h2>
    <form action="resume" method="post" enctype="multipart/form-data" modelAttribute="ResumeAdd" onsubmit="return validateFile();">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="name">성명</label>
                <input type="text" class="form-control" id="name" name="name" value="${ name.name }" readonly>
            </div>
            <div class="form-group col-md-6">
                <label for="photo">사진 (최근 6개월 이내)</label>
                <input type="file" class="form-control" name="myimg">
            </div>
        </div>
        
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="birthdate">생년월일</label>
                <input type="date" class="form-control" id="birthdate" name="birthdate" required>
            </div>
            <div class="form-group col-md-6">
                <label for="gender">성별</label>
                <!-- <input type="text" class="form-control" id="gender" name="gender" required> -->
                <div class="d-flex">
		            <div class="form-check mr-3">
		                <input type="radio" class="form-check-input" id="genderMale" name="gender" value="남성" required>
		                <label class="form-check-label" for="genderMale">남성</label>
		            </div>
		            <div class="form-check">
		                <input type="radio" class="form-check-input" id="genderFemale" name="gender" value="여성" required>
		                <label class="form-check-label" for="genderFemale">여성</label>
		            </div>
        		</div>
            </div>
        </div>
        
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="contact">연락처</label>
                <input type="text" class="form-control" id="contact" name="contact" required>
            </div>
            <div class="form-group col-md-6">
                <label for="email">e-mail</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
        </div>

        <div class="form-group">
            <label for="address">현 주소 (우편번호: - )</label>
            <input type="text" class="form-control" id="address" name="address" required maxlength="100">
        </div>
        
        <div class="form-group">
            <label for="education">학력사항</label>
            <input type="text" class="form-control" id="school" name="school" placeholder="학교명" required>
            <input type="text" class="form-control mt-2" id="period" name="period" placeholder="기간" required>
            <input type="text" class="form-control mt-2" id="major" name="major" placeholder="전공" required>
        </div>
        
        <div class="form-group">
            <label for="experience">아르바이트 경력사항</label>
            <input type="text" class="form-control" id="job_title" name="job_title" placeholder="직장명" required>
            <input type="text" class="form-control mt-2" id="experience_period" name="experience_period" placeholder="기간" required>
            <input type="text" class="form-control mt-2" id="main_work" name="main_work" placeholder="주요 업무" required>
        </div>
        
        <div class="form-group">
            <label for="reason">지원동기</label>
            <textarea class="form-control" id="reason" name="reason" rows="4" required></textarea>
        
        </div>
        
        <div class="form-row">
            <div id="worktime" class="form-group col-md-6">
                <label for="startCheckbox">근무 시작 시간</label>
                <input type="checkbox" id="startCheckbox" onchange="toggleWorkingHoursStart()"> 직접 입력
                <select id="workinghours_start" name="workinghours_start" class="form-select">
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

                <input type="text" id="workinghours_start_input" name="workinghours_start" placeholder="근무 시작 시간 00:00 형식으로 입력" class="form-control mt-2" style="display:none">
                <label for="endCheckbox">근무 종료 시간</label>
                    <input type="checkbox" id="endCheckbox" onchange="toggleWorkingHoursEnd()"> 직접 입력
                    <select id="workinghours_end" name="workinghours_end" class="form-select">
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
                    <input type="text" id="workinghours_end_input" name="workinghours_end" placeholder="근무 종료 시간 00:00 형식으로 입력" class="form-control mt-2" style="display:none">
            </div>

            <div class="form-group col-md-6">
                <label for="desired_salary">희망시급</label>
                <input type="number" class="form-control" id="desired_salary" name="desired_salary" placeholder="원/시간" required min="9860">
            </div>
        </div>
        
        <div class="form-group">
            <label for="desired_days">희망휴일</label>
            <input type="text" class="form-control" id="desired_days" name="desired_days" required maxlength="20">
        </div>


        <div class="text-center button">
            <button type="submit" class="btn btn-primary">저장</button>
            <a href="resumecancel" class="btn btn-danger">취소</a>
        </div>
    </form>
</div>
	
	<script type="text/javascript" src="/albaone/resources/js/resume.js"></script>
</body>
</html>