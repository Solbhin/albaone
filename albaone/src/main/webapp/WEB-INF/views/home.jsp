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
	<p><a href="employmentcontract">근로계약서 테스트</a>
	<p><a href="employmentcontractUpdate">근로계약서 재작성 테스트</a>
	<p><a href="searchcontract">근로계약서 조회</a>
	<p><a href="deletecontract">근로계약서 삭제</a>

	<!-- QR a태크, 임시 -->
	<p><a href="QRform">QR 생성 폼</a>
	<p><a href="QRread">QR 조회</a>
	
	<p><a href="resume">이력서 작성</a>
	<p><a href="resumereadAll">이력서 목록</a>
    <p><a href="myApplications">신청 내역</a> 
	
	<p><a href="Severance">퇴직금 계산</a>
	<p><a href="SeveranceRead">퇴직금 조회</a>
</body>
</html>
