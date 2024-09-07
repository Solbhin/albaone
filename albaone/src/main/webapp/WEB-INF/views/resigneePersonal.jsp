<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<%@include file="menu.jsp" %>
	
	<div class="container mt-4">
	   	<c:if test="${not empty sessionScope.businessNumber}">
	   		<div class="mb-3 text-center">
	           <a href="employeeList?businessNumber=${sessionScope.businessNumber}" class="btn btn-success">내 직원 조회</a>
	           <a href="/albaone/attendanceCalendar" class="btn btn-info">직원 근태 관리</a>
	           <a href="/albaone/salaryBusiness" class="btn btn-primary">직원 급여 조회</a>
	           <a href="/albaone/resignee" class="btn btn-warning">퇴직금 조회</a>
	       </div>
	    </c:if>
	    
		<h2 class="text-center">퇴사자 목록</h2>
		<table class="table table-boardered">
			<thead>
				<tr>
					<th>회사명</th>
					<th>입사일자</th>
					<th>퇴사일자</th>
					<th>재직일자</th>
					<th>퇴직금 조회</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="resignee" items="${resignationHistory}">
					<tr>
						<td>${resignee.businessNumber}</td>
						<td>${resignee.hireDate}</td>
						<td>${resignee.resignationDate}</td>
						<td>${resignee.employmentPeriod}</td>
						<td>
							<c:choose>
								<c:when test="${resignee.employmentPeriod > 365}">
									<a href="./severance?id=${resignee.id}&businessNumber=${resignee.businessNumber}" class="btn btn-secondary">조회</a>
								</c:when>
								<c:otherwise>
									X
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
				
			</tbody>
	</table>
	</div>
</body>
</html>