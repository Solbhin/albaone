<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>퇴직금 조회 결과</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="menu.jsp" %>

    <div class="container mt-5">
        <h2 class="text-center">퇴직금 조회 결과</h2>
        <div class="card mt-4">
            <div class="card-body">
                <h5 class="card-title">조회된 정보</h5>
                <ul class="list-group">
                    <li class="list-group-item"><strong>이름:</strong> ${name}</li>
                    <li class="list-group-item"><strong>퇴직전 3개월간 총 급여:</strong> ${total3MonthSalary}원</li>
                    <li class="list-group-item"><strong>1일 평균 임금:</strong> ${averageWage}원</li>
                    <li class="list-group-item"><strong>퇴직금:</strong> ${severance}원</li>
                </ul>
            </div>
        </div>
        <div class="text-center mt-4">
            <button onclick="window.history.back();" class="btn btn-secondary">돌아가기</button>
        </div>
    </div>
</body>
</html>
