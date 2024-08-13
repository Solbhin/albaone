<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>지원할 이력서 목록</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@include file="menu.jsp" %>
<div class="container mt-5">
    <h2 class="text-center">지원할 이력서 목록</h2>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>성명</th>
                <th>생년월일</th>
                <th>성별</th>
                <th>연락처</th>
                <th>이메일</th>
                <th>주소</th>
                <th>학교명</th>
                <th>기간</th>
                <th>전공</th>
                <th>직장명</th>
                <th>경력 기간</th>
                <th>주요 업무</th>
                <th>지원 동기</th>
                <th>근무 시간</th>
                <th>희망 시급</th>
                <th>희망 휴일</th>
                <th>사진</th>
                <th>지원하기</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="resume" items="${resumes}">
                <tr>
                    <td>${resume.name}</td>
                    <td>${resume.birthdate}</td>
                    <td>${resume.gender}</td>
                    <td>${resume.contact}</td>
                    <td>${resume.email}</td>
                    <td>${resume.address}</td>
                    <td>${resume.school}</td>
                    <td>${resume.period}</td>
                    <td>${resume.major}</td>
                    <td>${resume.job_title}</td>
                    <td>${resume.experience_period}</td>
                    <td>${resume.main_work}</td>
                    <td>${resume.reason}</td>
                    <td>${resume.work_hours}</td>
                    <td>${resume.desired_salary}</td>
                    <td>${resume.desired_days}</td>
                    <td>${joppost.postNumber}</td>
                    <td><img src="${pageContext.request.contextPath}/resources/images/${resume.myimgName}" alt="사진" width="100"></td>
                    <td>
                        <td>
    					<a href="${pageContext.request.contextPath}/apply?postNumber=${postNumber}&resume_id=${resume.resume_id}">지원하기</a>
						</td>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="text-center">
        <button onclick="window.history.back();" class="btn btn-secondary">뒤로가기</button>
    </div>
</div>
</body>
</html>
