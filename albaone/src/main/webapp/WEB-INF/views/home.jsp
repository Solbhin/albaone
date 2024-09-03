<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>알바원</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%@include file="menu.jsp"%>
    
    <div class="container">

        <h1 class="mt-4">소개 페이지</h1>
        <p>알바원은 구인구직, 근태관리, 급여 자동 생성, 퇴직금 자동 생성이 가능한 사이트입니다.</p>

        <div class="list-group mt-4">
            <a href="contracts" class="list-group-item list-group-item-action">알바생 근로계약서 조회 테스트</a>
            <a href="companyList?id=${sessionScope.id}" class="list-group-item list-group-item-action">개인 : 내 직장 조회</a>
            <a href="writeAlbarate" class="list-group-item list-group-item-action">사장 평가</a>
            <a href="ReadAlbarate" class="list-group-item list-group-item-action">내 평점 조회</a>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
