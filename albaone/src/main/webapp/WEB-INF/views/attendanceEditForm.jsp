<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>근무 기록 수정</title>
</head>
<body>
	<%@include file = "menu.jsp" %>

    <div class="container mt-5">
        <h2 class="text-center">근무 기록 수정</h2>
        <form action="attendanceEdit" method="post">
            <div class="form-group">
                <label for="date">날짜</label>
                <input type="date" class="form-control" name="selectDate" value="${localDate}" readonly>
            </div>
            <div class="form-group">
                <label for="workerName">알바생 이름</label>
                <input type="text" class="form-control" value="${name}" readonly>
                <input type="hidden" value="${id}" name="id">
            </div>
            <div class="form-group">
                <label for="checkInTime">출근 시간</label>
                <input type="time" class="form-control" name="inTime" value="${localTime}" required>
                <input type="hidden" name="checkInTime" value="${checkInTime}">
            </div>
            <div class="form-group">
                <label for="checkOutTime">퇴근 시간</label>
                <input type="time" class="form-control" name="outTime" value="${localOutTime}">
                <input type="hidden" name="checkOutTime" value="${checkOutTime}">
            </div>
            <button type="submit" class="btn btn-primary btn-block mt-3">수정</button>
        </form>
    </div>
</body>
</html>