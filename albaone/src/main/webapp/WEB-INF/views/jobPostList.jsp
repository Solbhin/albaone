<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    .card {
        border: 1px solid #000;
        border-radius: 8px;
        padding: 15px;
        margin-bottom: 20px;
    }
    .card-header {
        font-weight: bold;
        margin-bottom: 10px;
    }
    .card-body {
        margin-bottom: 10px;
    }
    .card-footer {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
    .pagination-container {
        position: fixed;
        bottom: 20px;
        left: 50%;
        transform: translateX(-50%);
        z-index: 1000;
    }
</style>
<title>공고 조회</title>
</head>
<body>
	<%@include file="menu.jsp" %>
	
    <div class="container mt-4">
    	<c:if test="${not empty sessionScope.businessNumber}">
	    	<div class="mb-3 text-center">
	            <a href="./jobposting" class="btn btn-success">공고 등록</a>
	            <a href="./myJobPost?page=1" class="btn btn-info">내가 쓴 글 조회</a>
	            <a href="./jobposts?page=1" class="btn btn-primary">전체 게시글 조회</a>
	        </div>
	    </c:if>
        <div class="row">
       		<c:forEach items="${jobPosts}" var="jobpost">
	            <div class="col-md-4 mb-3">
	                <div class="card">
	                    <div class="card-header">${jobpost.postNumber}</div>
	                    <div class="card-body">
	                        <h5 class="card-title">${jobpost.companyName} | 지역 | 등록일자</h5>
	                        <p class="card-text">근무요일 + 근무시간</p>
	                    </div>
	                    <div class="card-footer">
	                        <span>${jobpost.salary}</span>
	                        <a href="./jobpost?postNumber=${jobpost.postNumber}" class="btn btn-primary">읽기</a>
	                    </div>
	                </div>
	            </div>
            </c:forEach>
            <div class="pagination-container text-center">
		    	<c:if test="${currentPage > 1}">
	    			<a href="./jobposts?page=${currentPage -1}" class="btn btn-secondary">이전 페이지</a>
		    	</c:if>
		    	<c:if test="${currentPage < (totalPosts / 9)}">
	    			<a href="./jobposts?page=${currentPage +1}" class="btn btn-secondary">다음 페이지</a>
	    		</c:if>
    		</div>
   		</div>
    </div>
</body>
</html>