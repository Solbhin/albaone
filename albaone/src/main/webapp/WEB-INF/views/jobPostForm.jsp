<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>직업 공고 등록</title>
</head>
<body>
	<%@include file="menu.jsp" %>
	
   	<div class="mt-3 text-center">
        <a href="./jobposting" class="btn btn-success">공고 등록</a>
        <a href="./myJobPost?page=1" class="btn btn-info">내가 쓴 글 조회</a>
        <a href="./jobposts?page=1" class="btn btn-primary">전체 게시글 조회</a>
    </div>
    <div class="container mt-5">
        <h2 class="text-center">직업 공고 등록</h2>
        <form action="./jobposting" method="post" modelAttribute="jobPost" id="jobPostingForm">
            <div class="form-group">
                <label for="companyName">상호명</label>
                <input type="text" class="form-control" name="companyName" placeholder="상호명" required>
            </div>
            <div class="form-group">
                <label for="workLocation">근무지 주소</label>
                <input type="text" class="form-control" name="workLocation" placeholder="근무지 주소" required>
                <div id="addressError" class="text-danger" style="display:none;">유효한 주소를 입력하세요.</div>
            </div>
            <div class="form-group">
                <label for="contactNumber">연락처</label>
                <input type="text" class="form-control" name="contactNumber" placeholder="연락처" required>
            </div>
            <div class="form-group">
                <label for="salary">임금</label>
                <input type="number" class="form-control" name="salary" placeholder="임금" required>
            </div>
            <div class="form-group">
                <label for="workHours">근무시간</label>
                <input type="text" class="form-control" name="workHours" placeholder="근무시간" required>
            </div>
            <div class="form-group">
                <label for="workDays">근무요일</label>
                <input type="text" class="form-control" name="workDays" placeholder="근무요일" required>
            </div>
            <div class="form-group">
                <label for="workDuration">근무기간</label>
                <input type="text" class="form-control" name="workDuration" placeholder="근무기간" required>
            </div>
            <div class="form-group">
                <label for="jobDescription">하는 일</label>
                <textarea class="form-control" name="jobDescription" rows="4" placeholder="하는 일" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary btn-block">등록하기</button>
        </form>
    </div>

<!-- 주소 유효성 검사 - 치는게 빡세서 일단 주석처리함 - 읍이나 리 또는 도로명까지 쳐야 검색됨-->
<!-- <script type="text/javascript" src="/albaone/resources/js/jobPostForm.js"></script> -->
</body>
</html>