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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
.card {
	border: 1px solid #000;
	border-radius: 8px;
	padding: 15px;
	margin-bottom: 20px;
}

.card-body {
	margin-bottom: 10px;
}

.card-footer {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.pagination-container {
	position: fixed;
	bottom: 20px;
	left: 50%;
	transform: translateX(-50%);
	z-index: 1000;
}
</style>
<title>공고 조회</title>
</head>
<body>
	<%@include file="menu.jsp"%>

	<div class="container mt-4">
		<c:if test="${not empty sessionScope.businessNumber}">
			<div class="mb-3 text-center">
				<a href="./jobposting" class="btn btn-success">공고 등록</a> 
				<a href="./myJobPost?page=1" class="btn btn-info">내가 쓴 글 조회</a> 
				<a href="./jobposts?page=1" class="btn btn-primary">전체 게시글 조회</a>
			</div>
		</c:if>
		
		<div class="container mt-4">
			<form id="searchForm">
				<div class="input-group mb-3">
					<input type="text" name="searchInput" id="searchInput" class="form-control" value="${query}" placeholder="주소나 사업장 입력해주세요.">
					<input type="submit" class="btn btn-secondary" value="검색">
				</div>
			</form>
		</div>
		
		<div class="row" id="jobPostsContainer">
			<c:forEach items="${jobPosts}" var="jobpost">
				<div class="col-md-4 mb-3">
					<div class="card">
						<div class="card-body">
							<h4 class="card-title">${jobpost.companyName}</h4>
							<hr>
							<p class="card-text">주소: ${jobpost.workLocation}</p>
							<p class="card-text">근무요일: ${jobpost.workDays}</p>
							<p class="card-text">근무시간: ${jobpost.workHours}</p>
							<p class="card-text">시급: ${jobpost.salary}</p>
						</div>
						<div class="d-flex justify-content-end">
							<a href="./jobpost?postNumber=${jobpost.postNumber}"
								class="btn btn-primary">상세보기</a>
						</div>
					</div>
				</div>
			</c:forEach>
			
			<!-- AJAX를 통한 페이지네이션 처리 -->
		</div>
		
	</div>

	<script>
		$(document).ready(function(){
			$('#searchForm').submit(function(event){
				event.preventDefault(); // 기본 폼 제출 방지
				
				let query = $('#searchInput').val();
				
				$.ajax({
					url: 'searchJobPosts',
					type: 'GET',
					data: { searchInput: query },
					success: function(response){
						$('#jobPostsContainer').html($(response).find('#jobPostsContainer').html());
						// 페이지네이션 업데이트가 필요하다면 여기서 처리
						$('.pagination-container').html($(response).find('.pagination-container').html());
					}
				});
			});
		});
	</script>
 
</body>
</html>
