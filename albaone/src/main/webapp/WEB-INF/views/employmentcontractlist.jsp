<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>근로 계약서 목록</title>
</head>
<body>
    <h1>근로 계약서 목록</h1>
    <c:if test="${not empty contracts}">
        <table border="1">
            <thead>
                <tr>
                    <th>사업주명</th>
                    <th>알바생명</th>
                    <th>근무 시작</th>
                    <th>근무 종료</th>
                    <th>근로 장소</th>
                    <th>업무 내용</th>
                    <th>근로 시작 시간</th>
                    <th>근로 종료 시간</th>
                    <th>주당 근무일</th>
                    <th>임금</th>
                    <th>상여금</th>
                    <th>보험</th>
                    <th>작성 날짜</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="contract" items="${contracts}">
                    <tr>
                        <td>${contract.ownername}</td>
                        <td>${contract.parttimename}</td>
                        <td>${contract.period_start}</td>
                        <td>${contract.period_end}</td>
                        <td>${contract.place}</td>
                        <td>${contract.workdetail}</td>
                        <td>${contract.workinghours_start}</td>
                        <td>${contract.workinghours_end}</td>
                        <td>${contract.workday}</td>
                        <td>${contract.money}</td>
                        <td>${contract.bonus}</td>
                        <td>${contract.insurance}</td>
                        <td>${contract.date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty contracts}">
        <p>등록된 근로 계약서가 없습니다.</p>
    </c:if>
</body>
</html>