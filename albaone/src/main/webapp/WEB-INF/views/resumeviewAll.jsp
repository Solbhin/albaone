<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>이력서 목록</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@include file="menu.jsp" %>
<div class="container mt-5">
    <h2 class="text-center">이력서 목록</h2>
    <table class="table table-bordered">
        <thead>
            <tr>
            	<th>no.</th>
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
                <th>상세보기</th>
                <th>수정</th>
                <th>삭제</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="resume" items="${resumeList}">
                <tr>
                	<td>${resume.number}</td>
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
                    <td><img src="resources/images/${resume.myimgName}" alt="사진" width="100"></td>
                    <td>
                        <a href="resumeread?number=${resume.number}" class="btn btn-primary">상세보기</a>
                    </td>
                    <td>
                        <a href="resumeupdate?number=${resume.number}" class="btn btn-primary">수정</a>
                    </td>
                    <td>
                        <a href="resumedelete?number=${resume.number}" class="btn btn-danger" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="text-center">
        <a href="resume" class="btn btn-primary">새 이력서 작성</a>
        <a href="home" class="btn btn-secondary">홈으로</a>
    </div>
</div>
</body>
</html>
