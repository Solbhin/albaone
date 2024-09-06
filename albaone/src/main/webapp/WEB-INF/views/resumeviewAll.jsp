<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>이력서 목록</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="/albaone/resources/css/resumeAll.css">
</head>
<body>
<%@include file="menu.jsp" %>
<div class="container mt-5">
    <h2 class="text-center mb-4">이력서 목록</h2>
    <table class="table table-hover table-bordered">
        <thead class="thead-light">
            <tr>
                <th>성명</th>
                <th>연락처</th>
                <th>지원동기</th>
                <th>이메일</th>
                <th>사진</th>
                <th>상세보기</th>
                <th>수정</th>
                <th>삭제</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="resume" items="${resumeList}">
                <tr>
                    <td>${resume.name}</td>
                    <td>${resume.contact}</td>
                    <td>${resume.reason}</td>
                    <td>${resume.email}</td>
                    <td>
                        <img src="resources/images/${resume.myimgName}" alt="사진">
                    </td>
                    <td>
                        <a href="resumeread?number=${resume.number}" class="btn btn-info btn-sm">상세보기</a>
                    </td>
                    <td>
                        <a href="resumeupdate?number=${resume.number}" class="btn btn-warning btn-sm">수정</a>
                    </td>
                    <td>
                        <a href="resumedelete?number=${resume.number}" class="btn btn-danger btn-sm" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="text-center">
        <a href="resume" class="btn btn-primary">이력서 작성</a>
        <a href="myApplications" class="btn btn-secondary">신청 내역</a>
        <a href="home" class="btn btn-secondary">홈으로</a>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
