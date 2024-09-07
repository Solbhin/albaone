<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>근로 계약서 목록(사업주 전용 페이지)</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/albaone/resources/css/employmentcontractlistcompany.css" rel="stylesheet">
</head>
<style>

</style>
<body>
     <%@include file="menu.jsp" %>

    <div class="container mt-5">
        <c:forEach var="contract" items="${contract}">
            <c:if test="${not empty contract}">
                <div class="list-group">
                    <div class="list-group-item">
                        <h5 class="mb-1">알바생 이름: ${contract.parttimename}</h5>
                        <p class="mb-1">전화번호: ${contract.parttimePhone}</p>
                        <p class="mb-1">임금: ${contract.money}</p>
                        <p class="mb-1">작성 날짜: ${contract.createdate}</p>
                        <button class="btn" onclick="window.location.href='downloadcontractexam?num=${contract.num}'">다운로드</button>
                        <button class="btn delete-button ml-2" id="${contract.num}">삭제</button>
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

    <footer>
        <%@include file="footer.jsp" %>
    </footer>
    <script type="text/javascript" src="/albaone/resources/js/employmentcontractlistcompany.js"></script>
</body>
</html>