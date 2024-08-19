<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>이력서 수정</title>
</head>
<body>
<%@include file="menu.jsp" %>
<div class="container mt-5">
    <h2 class="text-center">이력서 수정</h2>
    <form action="resumeupdate?number=${resume.number}" method="post" enctype="multipart/form-data" modelAttribute="updateResume">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="name">성명</label>
                <input type="text" class="form-control" id="name" name="name" value="${resume.name}" required>
            </div>
            <div class="form-group col-md-6">
                <label for="photo">사진 (최근 6개월 이내)</label>
                <input type="file" class="form-control" name="myimg">
                <small>현재 사진: ${resume.myimgName}</small>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="birthdate">생년월일</label>
                <input type="date" class="form-control" id="birthdate" name="birthdate" value="${resume.birthdate}" required>
            </div>
            <div class="form-group col-md-6">
                <label for="gender">성별</label>
                <input type="text" class="form-control" id="gender" name="gender" value="${resume.gender}" required>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="contact">연락처</label>
                <input type="text" class="form-control" id="contact" name="contact" value="${resume.contact}" required>
            </div>
            <div class="form-group col-md-6">
                <label for="email">e-mail</label>
                <input type="email" class="form-control" id="email" name="email" value="${resume.email}" required>
            </div>
        </div>
        <div class="form-group">
            <label for="address">현 주소 (우편번호: - )</label>
            <input type="text" class="form-control" id="address" name="address" value="${resume.address}" required>
        </div>
        <div class="form-group">
            <label for="education">학력사항</label>
            <input type="text" class="form-control" id="school" name="school" value="${resume.school}" placeholder="학교명" required>
            <input type="text" class="form-control mt-2" id="period" name="period" value="${resume.period}" placeholder="기간" required>
            <input type="text" class="form-control mt-2" id="major" name="major" value="${resume.major}" placeholder="전공" required>
        </div>
        <div class="form-group">
            <label for="experience">아르바이트 경력사항</label>
            <input type="text" class="form-control" id="job_title" name="job_title" value="${resume.job_title}" placeholder="직장명" required>
            <input type="text" class="form-control mt-2" id="experience_period" name="experience_period" value="${resume.experience_period}" placeholder="기간" required>
            <input type="text" class="form-control mt-2" id="main_work" name="main_work" value="${resume.main_work}" placeholder="주요 업무" required>
        </div>
        <div class="form-group">
            <label for="reason">지원동기</label>
            <textarea class="form-control" id="reason" name="reason" rows="4" required>${resume.reason}</textarea>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="work_hours">근무시간</label>
                <input type="text" class="form-control" id="work_hours" name="work_hours" value="${resume.work_hours}" placeholder="예: 09:00 ~ 18:00" required>
            </div>
            <div class="form-group col-md-6">
                <label for="desired_salary">희망시급</label>
                <input type="text" class="form-control" id="desired_salary" name="desired_salary" value="${resume.desired_salary}" placeholder="원/시간" required>
            </div>
        </div>
        <div class="form-group">
            <label for="desired_days">희망휴일</label>
            <input type="text" class="form-control" id="desired_days" name="desired_days" value="${resume.desired_days}" required>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary">수정 완료</button>
            <a href="resumecancel" class="btn btn-danger">취소</a>
        </div>
    </form>
</div>
</body>
</html>
