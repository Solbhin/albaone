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
	    
		<h2 class="text-center">알바생 목록</h2>
		<table class="table table-boardered">
			<thead>
				<tr>
					<th>ID</th>
					<th>이름</th>
					<th>입사일자</th>
					<th>출석하기</th>
					<th>퇴사처리</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employee" items="${employeeList}">
					<tr>
						<td>${employee.id}</td>
						<td>${employee.name}</td>
						<td>${employee.hireDate}</td>
						<td><a href="QR?id=${employee.id}&businessNumber=${sessionScope.businessNumber}" class="btn btn-secondary">QR생성</a></td>
						<td>
							<input type="date" class="resignation-date" data-id="${employee.id}">
							<button data-id="${employee.id}" class="btn btn-danger">퇴사</button>
						</td>
					</tr>
				</c:forEach>
				<c:forEach var="company" items="${companyList}">
					<tr>
						<td><p>${company.businessNumber}</p></td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
	</div>
	<script>
		var buttons = document.querySelectorAll(".btn-danger");
		console.log(buttons);
		
		buttons.forEach(function(button) {
			button.addEventListener('click', function (event) {
				checkDelete(event);
			});
		});
		
		function checkDelete(event){
			var confirmation = confirm("정말로 퇴사 처리하시겠습니까?");
			if(confirmation) {
				var employeeId = event.target.getAttribute("data-id");
				var resignationDateInput = event.target.parentElement.querySelector(".resignation-date");
	            var resignationDate = resignationDateInput.value; // 퇴사일자 가져오기
				
	            if(resignationDate) {
		            console.log(employeeId);
		            console.log(resignationDate);
		            
					window.location.href="./resignation?id="+employeeId+"&resignationDate="+resignationDate;
	            } else {
					alert("퇴사일자를 입력해 주세요.");
				}
			}
		}
	</script>
</body>
</html>