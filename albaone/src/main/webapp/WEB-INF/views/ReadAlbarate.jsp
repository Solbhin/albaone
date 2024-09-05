<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등급 조회</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    .custom-background {
        background-color: #D8CAB8 !important;
    }
</style>
</head>
<body>
	<%@include file="menu.jsp" %>

	<div class="container mt-5">
		<c:if test="${not empty readList}">
			<c:set var="currentCompany" value="" />
			
			<c:forEach var="read" items="${readList}">
				<c:if test="${not empty read}">
					<c:if test="${currentCompany != read.companyName}">
						<c:if test="${not empty currentCompany}">
							<!-- 이전 회사의 결과를 출력하는 부분 -->
							<c:if test="${workingDays > 0}">
								<c:set var="totalDays" value="${workingDays + absentDays}" />
								<c:set var="attendanceRate" value="${(workingDays / totalDays) * 100}" />
								<div class="custom-background">
									근무 일수: ${workingDays}일, 출석률: ${attendanceRate}%<br>
									<p class="mb-1">QR 미체크 횟수: ${qrMissedCount}</p>
								</div>
							</c:if>
							<c:if test="${workingDays == 0}">
								<div class="alert alert-warning" role="alert">
									근무 기록이 없습니다.
								</div>
							</c:if>
						</c:if>
						
						<!-- 새로운 회사에 대한 초기화 -->
						<c:set var="currentCompany" value="${read.companyName}" />
						<c:set var="workingDays" value="0" />
						<c:set var="absentDays" value="0" />
						<c:set var="qrMissedCount" value="0" />
						
						<h4>${currentCompany}</h4>
					</c:if>
					
					<!-- 근무일수 및 QR 미체크 횟수 계산 -->
					<c:if test="${not empty read.checkOutTime}">
						<c:set var="workingDays" value="${workingDays + 1}" />
					</c:if>
					<c:if test="${empty read.checkOutTime}">
						<c:if test="${empty read.reason}">
							<c:set var="absentDays" value="${absentDays + 1}" />
						</c:if>
					</c:if>
					<c:if test="${not empty read.edit}">
						<c:set var="qrMissedCount" value="${qrMissedCount + 1}" />
					</c:if>
				</c:if>
			</c:forEach>
			
			<!-- 마지막 회사의 결과를 출력 -->
			<c:if test="${workingDays > 0}">
				<c:set var="totalDays" value="${workingDays + absentDays}" />
				<c:set var="attendanceRate" value="${(workingDays / totalDays) * 100}" />
				<div class="alert alert-success" role="alert">
					근무 일수: ${workingDays}일, 출석률: ${attendanceRate}%<br>
					<p class="mb-1">QR 미체크 횟수: ${qrMissedCount}</p>
				</div>
			</c:if>
			<c:if test="${workingDays == 0}">
				<div class="alert alert-warning" role="alert">
					근무 기록이 없습니다.
				</div>
			</c:if>
		</c:if>
		
		<c:if test="${empty readList}">
			<div class="alert alert-warning" role="alert">
				근무 기록이 없습니다.
			</div>
		</c:if>
		
		<a class="btn btn-block mt-3 custom-background" href="./">홈으로</a>
	</div>
</body>
</html>
