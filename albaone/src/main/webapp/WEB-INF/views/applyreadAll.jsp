<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>지원 내역 조회</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@include file="menu.jsp" %>
<div class="container">
    <h2>나의 지원 내역</h2>
    
    <c:if test="${not empty applications}">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>이력서 제목</th>
                    <th>회사명</th>
                    <th>근무지</th>
                    <th>급여</th>
                    <th>근무 시간</th>
                    <th>근무 일수</th>
                    <th>직무 설명</th>
                    <th>이력서 이름</th>
                    <th>연락처</th>
                    <th>이메일</th>
                    <th>주소</th>
                    <th>지원 상태</th>
                    <th>지원 취소</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="application" items="${applications}">
                    <tr>
                        <td>${application.resumetitle}</td>
                        <td>${application.companyName}</td>
                        <td>${application.workLocation}</td>
                        <td>${application.salary}</td>
                        <td>${application.workHours}</td>
                        <td>${application.workDays}</td>
                        <td>${application.jobDescription}</td>
                        <td>${application.name}</td>
                        <td>${application.contact}</td>
                        <td>${application.email}</td>
                        <td>${application.address}</td>
						<td>
						    <!-- 지원 상태를 표시 -->
						    <c:choose>
						        <c:when test="${application.status == '지원 중'}">
						            <span class="badge badge-warning">지원 중</span>
						        </c:when>
						        <c:when test="${application.status == '수락'}">
						            <span class="badge badge-success">수락</span>
						        </c:when>
						        <c:when test="${application.status == '거절'}">
						            <span class="badge badge-danger">거절</span>
						        </c:when>
						        <c:when test="${application.status == '공고 없음'}">
						            <span class="badge badge-dark">공고 마감</span>
						        </c:when>
						    </c:choose>
						</td>
                        <td>
                            <!-- 지원 취소 링크 -->
                            <a href="applydelete?apply_id=${application.apply_id}" class="btn btn-danger" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty applications}">
        <div class="alert alert-info" role="alert">
            지원 내역이 없습니다.
        </div>
    </c:if>

    <button onclick="window.history.back();" class="btn btn-secondary">뒤로가기</button>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
