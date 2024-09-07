<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>알바원</title>
    <link rel="stylesheet" href="/albaone/resources/css/home.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <%@include file="menu.jsp" %>
    <div class="image-container">
        <img class="img" src="${pageContext.request.contextPath}/resources/images/homemain.jpg" alt="사진">
        <div class="text-overlay">
            <h2>알바원 서비스</h2>
            <p>알바원은 구직자를 위한 다양한 서비스를 제공합니다.</p>
        </div>
    </div>
    <div class="container">
        <div class="my-5">
            <h3>최신 공고</h3>
            <c:choose>
                <c:when test="${empty recentJopPosts}">
                    <p class="text-center">죄송합니다 현재 공고가 없습니다.</p>
                </c:when>
                <c:otherwise>
                    <div class="row">
                        <c:forEach items="${recentJopPosts}" var="jobpost">
                            <div class="col-md-4 mb-3">
                                <div class="card card-custom">
                                    <div class="card-body">
                                        <h4 class="card-title">${jobpost.companyName}</h4><hr>
                                        <p class="card-text">주소: ${jobpost.workLocation}</p>
                                        <p class="card-text">근무요일: ${jobpost.workDays}</p>
                                        <p class="card-text">근무시간: ${jobpost.workHours}</p>
                                        <p class="card-text">시급: ${jobpost.salary}</p>
                                    </div>
                                    <div class="card-footer">
                                        <a href="./jobpost?postNumber=${jobpost.postNumber}">상세보기</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <footer>
        <%@include file="footer.jsp" %>
    </footer>
</body>
</html>
