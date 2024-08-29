<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>근로 계약서 목록(사업주 전용 페이지)</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/albaone/resources/css/employmentcontractlistcompany.css"> 
</head>
<body>
    <%@include file="menu.jsp" %>

    <div id="title"><h1>근로 계약서 목록</h1></div>
    <c:if test="${not empty contract}">
        <table>
            <thead>
                <tr>
                    <th>알바생 이름</th>
                    <th>전화번호</th>
                    <th>근무 시작</th>
                    <th>근무 종료</th>
                    <th>근로 장소</th>
                    <th>업무 내용</th>
                    <th>근로 시작</th>
                    <th>근로 종료</th>
                    <th>근무일</th>
                    <th>임금</th>
                    <th>상여금</th>
                    <th>보험</th>
                    <th>작성날짜</th>
                    <th>사측사인</th>
                    <th>알바사인</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="contract" items="${contract}">
                    <tr id="${contract.num}">
                        <td>${contract.parttimename}</td>
                        <td>${contract.parttimePhone}</td>
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
                        <td>${contract.createdate}</td>
                        <td><img src="resources/images/${contract.sinefilenameowner}" alt="사장 사인" width="50"></td>
                        <td><img src="resources/images/${contract.sinefilenameparttime}" alt="알바생 사인" width="50"></td>
                    </tr>
                    <!-- 버튼 행 -->
                    <tr id="${contract.num}-details">
                    	<!-- 모든 열을 합쳐서 버튼을 추가할 공간을 생성 -->
                        <td colspan="14" style="text-align: left;"> 
                            <button onclick="window.location.href='downloadcontractexam?num=${contract.num}'">다운로드</button>
                            <button class="delete-button" id="${contract.num}">삭제</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty contract}">
        <p>등록된 근로 계약서가 없습니다.</p>
    </c:if>

    <script type="text/javascript" src="/albaone/resources/js/employmentcontractlistcompany.js">
    </script>

</body>
</html>