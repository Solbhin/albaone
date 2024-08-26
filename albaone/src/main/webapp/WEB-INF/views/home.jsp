<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알바원</title>
</head>
<body>
	<%@include file="menu.jsp"%>

	<h1>소개 페이지</h1>
	<!-- 근로 계약서 a태그, 임시 -->
	<p><a href="contracts">알바생 근로계약서 조회 테스트</a>
	
	<p><a href="companyList?id=${sessionScope.id}">개인 : 내 직장 조회</a></p>
    
    <!-- 퇴직금 테스트 -->
    <p><a href="Severance">퇴직금 계산</a>
	<p><a href="SeveranceRead">퇴직금 조회</a>
    
    <!-- 등급 테스트 -->
    <p><a href="writeAlbarate">사장 평가</a>
    <p><a href="ReadAlbarate">내 평점 조회</a>
</body>
</html>
