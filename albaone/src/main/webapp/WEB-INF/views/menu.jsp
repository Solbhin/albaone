<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
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
	                <c:if test="${not empty sessionScope.businessNumber}">
	                    <li class="nav-item">
	                        <a class="nav-link" href="/albaone/jobposting">공고등록</a>
	                    </li>
              	        <li class="nav-item">
	                        <a class="nav-link" href="/albaone/myJobPost?page=1">내가 쓴 글 조회</a>
	                    </li>
	                    
	                </c:if>
                    <li class="nav-item">
                        <a class="nav-link" href="/albaone/jobposts?page=1">구인 게시글 조회</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/albaone/calendar">근태 관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">급여 조회</a>
                    </li>
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
</body>
</html>