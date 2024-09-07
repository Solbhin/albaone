<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>근무 기록 입력</title>
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">근무 기록 입력</h2>
        <form action="attendanceAdd" method="post">
            <div class="form-group">
                <label for="date">날짜</label>
                <input type="date" class="form-control" name="selectDate" required>
            </div>
            <div class="form-group">
                <label for="workerName">알바생 이름</label>
                <select class="form-control" name="id" required>
                	<option value="" >알바생 선택</option>
                	<c:forEach var="empolyee" items="${empolyeeList}">
                		<option value="${empolyee.id}">${empolyee.name}</option>
                	</c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="checkInTime">출근 시간</label>
                <input type="time" class="form-control" name="inTime" required>
            </div>
            <div class="form-group">
                <label for="checkOutTime">퇴근 시간</label>
                <input type="time" class="form-control" name="outTime" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block mt-3">등록하기</button>
        </form>
    </div>
</body>
</html>
