<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    .card {
        border: 1px solid #000;
        border-radius: 8px;
        padding: 15px;
        margin-bottom: 20px;
    }
    .card-header {
        font-weight: bold;
        margin-bottom: 10px;
    }
    .card-body {
        margin-bottom: 10px;
    }
    .card-footer {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
</style>
<title>공고 조회</title>
</head>
<body>
	<%@include file="menu.jsp" %>
	
    <div class="container mt-4">
        <h1>게시판</h1>
        <div class="row">
            <!-- 게시글 카드 시작 -->
            <div class="col-md-4 mb-3">
                <div class="card">
                    <div class="card-header">분류</div>
                    <div class="card-body">
                        <h5 class="card-title">상호명 | 지역 | 등록일자</h5>
                        <p class="card-text">근무요일 + 근무시간</p>
                    </div>
                    <div class="card-footer">
                        <span>급여</span>
                        <a href="#" class="btn btn-primary">읽기</a>
                    </div>
                </div>
            </div>
            <!-- 게시글 카드 끝 -->
            
            <!-- 추가 게시글 카드 -->
            <div class="col-md-4 mb-3">
                <div class="card">
                    <div class="card-header">분류</div>
                    <div class="card-body">
                        <h5 class="card-title">상호명 | 지역 | 등록일자</h5>
                        <p class="card-text">근무요일 + 근무시간</p>
                    </div>
                    <div class="card-footer">
                        <span>급여</span>
                        <a href="#" class="btn btn-primary">읽기</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <div class="card">
                    <div class="card-header">분류</div>
                    <div class="card-body">
                        <h5 class="card-title">상호명 | 지역 | 등록일자</h5>
                        <p class="card-text">근무요일 + 근무시간</p>
                    </div>
                    <div class="card-footer">
                        <span>급여</span>
                        <a href="#" class="btn btn-primary">읽기</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>