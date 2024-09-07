<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<link rel="stylesheet" href="/albaone/resources/css/resume.css">
<title>이력서 등록</title>
</head>
<body>
<%@include file="menu.jsp" %>
<div class="container resume">
    <div class="card">
        <div class="card-body">
        	<i class="bi bi-file-earmark-fill"></i>
        	<h2>아르바이트 지원서</h2>
            <form action="resume" method="post" enctype="multipart/form-data" modelAttribute="ResumeAdd" onsubmit="return validateFile();">
                <div class="row mb-3">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name">성명</label>
                            <input type="text" class="form-control" id="name" name="name" value="${ name.name }" readonly>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="photo">사진 (최근 6개월 이내)</label>
                            <input type="file" class="form-control" name="myimg">
                        </div>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="birthdate">생년월일</label>
                            <input type="date" class="form-control" id="birthdate" name="birthdate" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="gender">성별</label>
                            <div class="d-flex">
                                <div class="form-check me-3">
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
                </div>
                <div class="row mb-3">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="contact">연락처</label>
                            <input type="text" class="form-control" id="contact" name="contact" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="email">e-mail</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                    </div>
                </div>
                <div class="form-group mb-3">
                    <label for="address">현 주소 (우편번호: - )</label>
                    <input type="text" class="form-control" id="address" name="address" required maxlength="100">
                </div>
                <div class="form-group mb-3">
                    <label for="education">학력사항</label>
                    <div id="educationFields">
                        <div class="mb-3">
                            <input type="text" class="form-control" name="school[]" placeholder="학교명" required>
                            <input type="text" class="form-control mt-2" name="period[]" placeholder="기간" required>
                            <input type="text" class="form-control mt-2" name="major[]" placeholder="전공" required>
                        </div>
                    </div>
                    <button type="button" class="btn btn-outline-secondary" onclick="addEducationField()">+ 추가</button>
                </div>
                <div class="form-group mb-3">
                    <label for="experience">아르바이트 경력사항</label>
                    <div id="experienceFields">
                        <div class="mb-3">
                            <input type="text" class="form-control" name="job_title[]" placeholder="직장명" required>
                            <input type="text" class="form-control mt-2" name="experience_period[]" placeholder="기간" required>
                            <input type="text" class="form-control mt-2" name="main_work[]" placeholder="주요 업무" required>
                        </div>
                    </div>
                    <button type="button" class="btn btn-outline-secondary" onclick="addExperienceField()">+ 추가</button>
                </div>
                <div class="form-group mb-3">
                    <label for="reason">지원동기</label>
                    <textarea class="form-control" id="reason" name="reason" rows="4" required></textarea>
                </div>
                <div class="row mb-3">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="work_hours">근무시간</label>
                            <input type="text" class="form-control" id="work_hours" name="work_hours" placeholder="예: 09:00 ~ 18:00" required maxlength="20">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="desired_salary">희망시급</label>
                            <input type="text" class="form-control" id="desired_salary" name="desired_salary" placeholder="원/시간" required>
                        </div>
                    </div>
                </div>
                <div class="form-group mb-3">
                    <label for="desired_days">희망휴일</label>
                    <input type="text" class="form-control" id="desired_days" name="desired_days" required maxlength="20">
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">저장</button>
                    <a href="resumecancel" class="btn btn-danger">취소</a>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="/albaone/resources/js/resume.js"></script>
<%@include file="footer.jsp"%>
</body>
</html>
