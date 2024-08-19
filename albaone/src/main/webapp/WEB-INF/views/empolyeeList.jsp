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

		<div class="container">
			<h2 class="text-center">알바생 목록</h2>
			<table class="table table-boardered">
				<thead>
					<tr>
						<th>ID</th>
						<th>이름</th>
						<th>출석하기</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="empolyee" items="${empolyeeList}">
						<tr>
							<td>${empolyee.id}</td>
							<td>${empolyee.name}</td>
							<td><a href="QR?id=${empolyee.id}&businessNumber=${sessionScope.businessNumber}">QR</a></td>
						</tr>
					</c:forEach>						
				</tbody>
			</table>
		</div>
	
	<c:forEach var="company" items="${companyList}">
		<p>${company.businessNumber}</p>
	</c:forEach>
</body>
</html>