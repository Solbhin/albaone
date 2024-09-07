<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/albaone/resources/css/register.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<%@include file="menu.jsp" %>
	<div class="container register">
		<div class="row">
			<h3>알바원 회원가입을 환영합니다.</h3>
		  <div class="col-sm-6">
		    <div class="card">
		      <div class="card-body">
		        <h2 class="card-title">개인회원</h5>
		        <i class="bi bi-person-fill"></i>
		        <p class="card-text">이력서를 등록하고 알바를 찾아보세요</p>
		        <a href="./register/personal" class="btn btn-personal">회원가입</a>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-6">
		    <div class="card">
		      <div class="card-body">
		        <h2 class="card-title">기업회원</h5>
		        <i class="bi bi-people-fill"></i>
		        <p class="card-text">공고를 등록하고 인재를 찾아보세요</p>
		        <a href="./register/business" class="btn btn-business">회원가입</a>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>