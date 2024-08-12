<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>캘린더</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>캘린더</h1>
    <div>
        <a href="${pageContext.request.contextPath}/calendar?month=${currentMonth - 1}&year=${currentYear}">이전 달</a>
        <span>${currentYear} - ${currentMonth}</span>
        <a href="${pageContext.request.contextPath}/calendar?month=${currentMonth + 1}&year=${currentYear}">다음 달</a>
    </div>
    
    <table>
        <thead>
            <tr>
                <th>일</th>
                <th>월</th>
                <th>화</th>
                <th>수</th>
                <th>목</th>
                <th>금</th>
                <th>토</th>
            </tr>
        </thead>
        <tbody>
            <c:set var="dayCounter" value="0" />
            <tr>
                <c:forEach var="day" items="${days}">
                    <c:set var="dayOfWeek" value="${day.dayOfWeek}" />
                    <c:set var="dayOfMonth" value="${day.dayOfMonth}" />

                    <c:if test="${dayCounter == 0}">
                        <c:if test="${dayOfWeek > 1}">
                            <c:forEach begin="1" end="${dayOfWeek - 1}">
                                <td></td>
                            </c:forEach>
                        </c:if>
                    </c:if>

                    <td>
                        <span>${dayOfMonth}</span>
                    </td>

                    <c:set var="dayCounter" value="${dayCounter + 1}" />
                    <c:if test="${dayOfWeek == 7}">
                        <tr></tr>
                        <c:set var="dayCounter" value="0" />
                    </c:if>
                </c:forEach>
            </tr>
        </tbody>
    </table>
</body>
</html>


