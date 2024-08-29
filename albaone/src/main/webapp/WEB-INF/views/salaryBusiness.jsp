<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>직원 급여 조회</title>
</head>
<body>
	<%@include file="menu.jsp"%>

	<div class="container mt-4">
   		<div class="mb-3 text-center">
           <a href="employeeList?businessNumber=${sessionScope.businessNumber}" class="btn btn-success">내 직원 조회</a>
           <a href="/albaone/attendanceCalendar" class="btn btn-info">직원 근태 관리</a>
           <a href="/albaone/salaryBusiness" class="btn btn-primary">직원 급여 조회</a>
           <a href="/albaone/resignee" class="btn btn-warning">퇴직금 조회</a>
        </div>
	
		<h1 class="text-center">직원 급여 조회</h1>

		<div class="text-center">
			<form method="GET" action="salaryBusiness">
				<label for="monthInput">연도 및 월 선택: </label> <input type="month"
					name="yearMonth" value="${yearMonth}"> <input type="submit"
					class="btn btn-secondary" value="선택">
			</form>
		</div>
	
		<div class="row mt-4">
			<c:forEach var="salary" items="${listOfSalary}">
				<div class="col-md-3">
					<div class="card mb-4" id="salaryCard">
						<div class="card-body">
							<h3>${salary.name}</h3>
							<p>ID: ${salary.id}</p>
							<p>총 근무시간: ${salary.workHours}시간 ${salary.workMinutes}분</p>
							<p>시급: 9860원</p>
							<p>월급: ${salary.salary}원</p>
							<p>주휴수당: ${salary.benefit} 원</p>
							<p class="font-weight-bold">합계: ${salary.totalSalary}원</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		
		<c:if test="${empty listOfSalary}">
			<div class="card mb-4 text-center">
				<h3>근무 기록이 없습니다.</h3>
			</div>
		</c:if>

	</div>
</body>
</html>