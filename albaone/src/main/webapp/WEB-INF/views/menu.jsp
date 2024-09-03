<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/albaone/resources/css/font.css">
    <link rel="stylesheet" href="/albaone/resources/css/menu.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Insert title here</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg">
        <div class="container">
            <a class="navbar-brand" href="./">알바원</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
             <div class="collapse navbar-collapse d-flex justify-content-end" id="navbarNav">
                <ul class="navbar-nav">
 	                <c:if test="${not empty sessionScope.id}">
	                	<li class="nav-item">
	                		<p class="nav-link">안녕하세요 <strong>${id}님</strong></p>
	                	</li>
	                </c:if>
	                <c:if test="${not empty sessionScope.businessNumber && not empty sessionScope.id}">
	               		<li class="nav-item dropdown">
						    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" onclick="toggleDropdown(event)" data-bs-auto-close="true" >공고</a>
						    <div class="dropdown-menu" style="">
						     	<a class="dropdown-item" href="jobposting">공고 등록</a>
						        <a class="dropdown-item" href="/albaone/jobposts?page=1">전체 공고 보기</a>		     
						        <a class="dropdown-item" href="./myJobPost?page=1">내 공고 보기</a>
						    </div>
						</li>
	               		<li class="nav-item dropdown">
						    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" onclick="toggleDropdown(event)" data-bs-auto-close="true" >직원</a>
						    <div class="dropdown-menu" style="">
						     	<a class="dropdown-item" href="employeeList?businessNumber=${sessionScope.businessNumber}">내 직원 보기</a>
						        <a class="dropdown-item" href="attendanceCalendar">직원 근태 관리</a>		     
						        <a class="dropdown-item" href="salaryBusiness">직원 급여 조회</a>
						        <a class="dropdown-item" href="resignee">직원 퇴직금 조회</a>
						    </div>
						</li>
	                </c:if>
                   	<c:if test="${empty sessionScope.businessNumber && not empty sessionScope.id}">
						<li class="nav-item dropdown">
						    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" onclick="toggleDropdown(event)">이력서</a>
						    <div class="dropdown-menu" style="">
						        <a class="dropdown-item" href="resume">이력서 작성</a>
						        <a class="dropdown-item" href="resumereadAll">이력서 조회</a>
						    </div>
						</li>
						<li class="nav-item dropdown">
						    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" onclick="toggleDropdown(event)" data-bs-auto-close="true" >근무</a>
						    <div class="dropdown-menu" style="">
						     	<a class="dropdown-item" href="/albaone/attendanceCalendar">근무 기록</a>
						        <a class="dropdown-item" href="/albaone/salaryPersonal">급여 조회</a>		     
						    </div>
						</li>
	                    <li class="nav-item">
	                    	<a class="nav-link" href="/albaone/jobposts?page=1">채용 정보</a>
	                    </li>
					</c:if>
                	<c:if test="${not empty sessionScope.id}">
	                    <li class="nav-item">
	                        <a class="nav-link" href="/albaone/update">회원 정보 수정</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link" href="/albaone/logout?id=${id}">로그아웃</a>
	                    </li>
	                </c:if>
	                <c:if test="${empty sessionScope.id}">
         		        <li class="nav-item">
	                    	<a class="nav-link" href="/albaone/jobposts?page=1">채용 정보</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link" href="/albaone/login">로그인</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link" href="/albaone/register">회원가입</a>
	                    </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
<script src="/albaone/resources/js/menu.js"></script>
</body>
</html>