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
        table-layout: fixed; /* 테이블 레이아웃 고정 */
        height: 400px; /* 원하는 높이값을 설정 */
    }
    
    th, td {
        border: 1px solid black;
        padding: 10px;
        text-align: center;
        white-space: nowrap; /* 텍스트 줄바꿈 방지 */
    }
    
    .sunday {
        background-color: red; /* 일요일 셀 빨간색 */
        color: white; /* 글자 색상 흰색 */
    }
    
    .saturday {
        background-color: blue; /* 토요일 셀 파란색 */
        color: white; /* 글자 색상 흰색 */
    }
</style>

</head>
<body>
	
    <div class="text-center mt-4">
    	<h1>캘린더</h1>
        <a href="?year=${currentYear - 1}&month=${currentMonth}" class="btn mb-2 btn-secondary">이전 년도</a>
        <a href="${pageContext.request.contextPath}/attendanceCalendar?month=${currentMonth - 1}&year=${currentYear}" class="btn mb-2 btn-secondary">이전 달</a>
        <span>${currentYear}년 ${currentMonth}월</span>
        <a href="${pageContext.request.contextPath}/attendanceCalendar?month=${currentMonth + 1}&year=${currentYear}" class="btn mb-2 btn-secondary">다음 달</a>
        <a href="?year=${currentYear + 1}&month=${currentMonth}" class="btn mb-2 btn-secondary">다음 년도</a>
    </div>
    
	<div class="table-container" style="width: 90%; margin: 0 auto;">
	    <table>
	        <thead>
	            <tr>
	                <th class="sunday">일</th>
	                <th>월</th>
	                <th>화</th>
	                <th>수</th>
	                <th>목</th>
	                <th>금</th>
	                <th class="saturday">토</th>
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
	                        		<!-- reason이 null이 아닐 경우 "결근"을 표시 -->
	                        		<c:if test="${not empty attendance.reason}">
	                        			<p>결근</p>
	                        			<a href="attendanceEdit?id=${attendance.id}&checkInTime=${attendance.checkInTime}" class="btn btn-warning">수정</a>
	                        		</c:if>
	                        		<!-- reason이 null일 경우만 나머지 내용을 표시 -->
            						<c:if test="${empty attendance.reason}">
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
					                            ${attendance.formattedCheckInTime} ~
					                            <c:if test="${not empty sessionScope.businessNumber}">
						                            <a href="attendanceEdit?id=${attendance.id}&checkInTime=${attendance.checkInTime}" class="btn btn-warning">보기</a>
						                        </c:if> 
											</c:when>
				                            <c:otherwise>
				                            	${attendance.time}
				                            	<c:if test="${not empty sessionScope.businessNumber}">
				                            		<a href="attendanceEdit?id=${attendance.id}&checkInTime=${attendance.checkInTime}&checkOutTime=${attendance.checkOutTime}" class="btn btn-warning">보기</a>
				                            	</c:if>
				                            </c:otherwise>
										</c:choose>
            						</c:if>
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
    </div>
    
    <c:if test="${not empty sessionScope.businessNumber}">
	    <div class="text-center mt-3">
		    <a href="addAttendance" class="btn btn-primary">추가</a>
		</div>
	</c:if>
	
</body>
</html>
