<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>근로계약서 조회 - 알바생 페이지</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/albaone/resources/css/employmentcontractlistcompany.css"> 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <%@include file="menu.jsp" %>
    
    <div class="container mt-5">
        <c:forEach var="contract" items="${contract}">
            <c:if test="${not empty contract}">
                <div class="list-group">
                    <div class="list-group-item">
                        <h5 class="mb-1">근무장소: ${contract.place}</h5>
                        <p class="mb-1">고용주 전화번호 : ${contract.ownerPhone}</p>
                        <p class="mb-1">임금: ${contract.money}</p>
                        <p class="mb-1">작성 날짜: ${contract.createdate}</p>
                        <button class="btn btn-primary" onclick="window.location.href='downloadcontractexam?num=${contract.num}'">
                            다운로드
                        </button>
                    </div>
                </div>
            </c:if>
        </c:forEach>
        <c:if test="${empty contract}">
            <div class="alert alert-warning" role="alert">
                등록된 근로 계약서가 없습니다.
            </div>
        </c:if>
    </div>
</body>
</html>

