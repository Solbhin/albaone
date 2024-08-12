<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등급 조회</title>
</head>
<body>
	<!-- 변수에 EL 담기 -->
	<c:set var="commute" value="${read.commute}" />
	<c:set var="absent" value="${read.absent}" />
	<c:set var="blinking" value="${read.blinking}" />

	<table border="1">
	<tbody>
		<tr>
			<th colspan="2">알바생 이름</th>
			<td>${ read.parttimename }</td>
		</tr>
		<tr>
			<td>출퇴근</td>
			<td>${ read.commute }</td>
			<c:set var="commuteresult" value="" />
			<td>생략</td>
		</tr>
		<tr>
			<td>결근</td>
			<td>${ read.absent }</td>
			<c:set var="absentresult" value="" />
			<td>생략</td>
		</tr>
		<tr>
			<td>QR 소홀</td>
			<td>${ read.blinking }</td>
			<c:set var="blinkingresult" value="" />
			<td>생략</td>
		</tr>
		<tr>
			<td>회사 평가</td>
			<td>${ read.company }</td>
				<!-- 20보다 작으면 -->
				<c:if test="${company >= 20}">
					<c:set var="companyresult" value="우수알바" />
				</c:if>
				<!-- -5 이상, 20 이하 -->
				<c:if test="${company < 20 and company >= -5}">
					<c:set var="companyresult" value="일반알바" />
				</c:if>
				<!-- -5 이상 -->
				<c:if test="${company < -5}">
					<c:set var="companyresult" value="노력필요" />
				</c:if>
			<td><c:out value="${companyresult}" /></td>
		</tr>
	</tbody>
</table>
</body>
</html>