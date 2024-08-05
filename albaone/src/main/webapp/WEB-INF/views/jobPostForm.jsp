<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>직업 공고 등록</title>
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">직업 공고 등록</h2>
        <form action="./jobposting" method="post" modelAttribute="jobPost">
            <div class="form-group">
                <label for="companyName">상호명</label>
                <input type="text" class="form-control" name="companyName" placeholder="상호명" required>
            </div>
            <div class="form-group">
                <label for="workLocation">근무지 주소</label>
                <input type="text" class="form-control" name="workLocation" placeholder="근무지 주소" required>
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
</body>
</html>