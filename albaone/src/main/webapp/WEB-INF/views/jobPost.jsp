<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>게시글 상세보기</title>
<style>
    .card {
        margin: 20px auto;
        max-width: 600px;
    }
</style>
</head>
<body>
    <%@include file="menu.jsp" %>
    
    <div class="container mt-4">
        <div class="card">
            <div class="card-header d-flex justify-content-between align-items-center">
                <h5>${jobPost.companyName}의 상세정보</h5>
                <div>
                	<c:if test="${jobPost.id == sessionScope.id}">
	                    <button class="btn btn-danger btn-sm" onclick="if(confirm('정말 삭제하시겠습니까?')) { location.href='deleteJobPost?postNumber=${jobPost.postNumber}'; }">삭제</button>
	                    <button class="btn btn-primary btn-sm" onclick="location.href='editJobPost?postNumber=${jobPost.postNumber}'">수정</button>
					</c:if>
                </div>
            </div>
            <div class="card-body">
                <h6 class="card-title">근무지: ${jobPost.workLocation}</h6>
                <p><strong>연락처:</strong> ${jobPost.contactNumber}</p>
                <p><strong>임금:</strong> ${jobPost.salary} 원</p>
                <p><strong>근무시간:</strong> ${jobPost.workHours}</p>
                <p><strong>근무요일:</strong> ${jobPost.workDays}</p>
                <p><strong>근무기간:</strong> ${jobPost.workDuration}</p>
                <p><strong>업무내용:</strong> ${jobPost.jobDescription}</p>
            </div>
            <div class="card-footer text-center">
            	<button>지원하기</button>
            </div>
        </div>
            <div class="text-center">
                <button onclick="window.history.back();" class="btn btn-secondary">목록으로 돌아가기</button>
            </div>
    </div>
</body>
</html>
