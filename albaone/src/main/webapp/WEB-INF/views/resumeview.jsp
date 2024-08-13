<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>이력서 상세보기</title>
</head>
<body>
<%@include file="menu.jsp" %>
 <div class="container mt-5">
        <h2 class="text-center mb-4">아르바이트 지원서</h2>
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <table class="table table-bordered resume-table">
                    <tbody>
                        <tr>
                            <th>항목</th>
                            <th>정보</th>
                        </tr>
                        <tr>
                            <td>이력서 번호</td>
                            <td>${resume.number}</td>
                        </tr>
                        <tr>
                            <td>성명</td>
                            <td>${resume.name}</td>
                        </tr>
                        <tr>
                            <td>생년월일</td>
                            <td>${resume.birthdate}</td>
                        </tr>
                        <tr>
                            <td>성별</td>
                            <td>${resume.gender}</td>
                        </tr>
                        <tr>
                            <td>연락처</td>
                            <td>${resume.contact}</td>
                        </tr>
                        <tr>
                            <td>이메일</td>
                            <td>${resume.email}</td>
                        </tr>
                        <tr>
                            <td>주소</td>
                            <td>${resume.address}</td>
                        </tr>
                        <tr>
                            <td>학교명</td>
                            <td>${resume.school}</td>
                        </tr>
                        <tr>
                            <td>기간</td>
                            <td>${resume.period}</td>
                        </tr>
                        <tr>
                            <td>전공</td>
                            <td>${resume.major}</td>
                        </tr>
                        <tr>
                            <td>직장명</td>
                            <td>${resume.job_title}</td>
                        </tr>
                        <tr>
                            <td>경력 기간</td>
                            <td>${resume.experience_period}</td>
                        </tr>
                        <tr>
                            <td>주요 업무</td>
                            <td>${resume.main_work}</td>
                        </tr>
                        <tr>
                            <td>지원 동기</td>
                            <td>${resume.reason}</td>
                        </tr>
                        <tr>
                            <td>근무 시간</td>
                            <td>${resume.work_hours}</td>
                        </tr>
                        <tr>
                            <td>희망 시급</td>
                            <td>${resume.desired_salary}</td>
                        </tr>
                        <tr>
                            <td>희망 휴일</td>
                            <td>${resume.desired_days}</td>
                        </tr>
                        	<img src="resources/images/${resume.myimgName}" alt="사진" width="100">
                    </tbody>
                </table>
                     <a href="resume" class="btn btn-primary">새 이력서 작성</a>
       				 <a href="home" class="btn btn-secondary">홈으로</a>
       				  <a href="resumeupdate?number=${resume.number}" class="btn btn-primary">수정</a>
       				 <a href="resumedelete?number=${resume.number}" class="btn btn-danger" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
            </div>
        </div>
    </div>
</body>
</html>
