<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<%@include file="menu.jsp" %>
	
    <title>캘린더</title>
    <style>
        table {
            width: 100%;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="text-center">
    	<h1>캘린더</h1>
        <a href="?year=${currentYear - 1}&month=${currentMonth}" class="btn mb-2 btn-secondary">이전 년도</a>
        <a href="${pageContext.request.contextPath}/attendanceCalendar?month=${currentMonth - 1}&year=${currentYear}" class="btn mb-2 btn-secondary">이전 달</a>
        <span>${currentYear}년 ${currentMonth}월</span>
        <a href="${pageContext.request.contextPath}/attendanceCalendar?month=${currentMonth + 1}&year=${currentYear}" class="btn mb-2 btn-secondary">다음 달</a>
        <a href="?year=${currentYear + 1}&month=${currentMonth}" class="btn mb-2 btn-secondary">다음 년도</a>
    </div>
    
    
    <table class="container">
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
            <tr>
                <c:set var="dayCounter" value="0" />
                <c:forEach var="day" items="${days}">
                    <c:set var="dayOfWeek" value="${day.dayOfWeek}" />
                    <c:set var="dayOfMonth" value="${day.dayOfMonth}" />

                    <c:if test="${dayCounter == 0 && dayOfWeek > 1}">
                        <c:forEach begin="1" end="${dayOfWeek - 1}">
                            <td></td>
                        </c:forEach>
                    </c:if>

                    <td>
                        <p>${dayOfMonth}</p>
                        <c:forEach var="attendance" items="${listOfAttendance}">
                        	<c:if test="${attendance.date==day.date}">
								<c:choose>
		                        	<c:when test="${not empty sessionScope.businessNumber}">
		                        		<p>${attendance.name} |
		                        	</c:when>
	                        		<c:otherwise>
	                        			<p>${attendance.companyName} |
	                        		</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${attendance.checkOutTime==null}">
			                            근무시간 : ${attendance.formattedCheckInTime} ~
			                            <c:if test="${not empty sessionScope.businessNumber}">
				                            <a href="attendanceEdit?id=${attendance.id}&checkInTime=${attendance.checkInTime}" class="btn btn-warning">수정</a></p>
				                        </c:if> 
									</c:when>
		                            <c:otherwise>
			                            근무시간 : ${attendance.formattedCheckInTime} ~
		                            	${attendance.formattedCheckOutTime} | 
		                            	${attendance.time}
		                            	<c:if test="${not empty sessionScope.businessNumber}">
		                            		<a href="attendanceEdit?id=${attendance.id}&checkInTime=${attendance.checkInTime}" class="btn btn-warning">수정</a></p>
		                            	</c:if>
		                            </c:otherwise>
								</c:choose>
	                        </c:if>
                        </c:forEach>
                    </td>

                    <c:set var="dayCounter" value="${dayCounter + 1}" />
                    <c:if test="${dayOfWeek == 7}">
                        </tr><tr>
                        <c:set var="dayCounter" value="0" />
                    </c:if>
                </c:forEach>
                <c:if test="${dayCounter > 0}">
                    <c:forEach begin="${dayCounter + 1}" end="7">
                        <td></td>
                    </c:forEach>
                </c:if>
            </tr>
        </tbody>
    </table>
    
    <c:if test="${not empty sessionScope.businessNumber}">
	    <div class="text-center mt-3">
		    <a href="addAttendance" class="btn btn-primary">추가</a>
		</div>
	</c:if>
	
</body>
</html>
