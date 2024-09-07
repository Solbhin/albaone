<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/albaone/resources/css/resumeview.css">
    <title>이력서 상세보기</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container mt-5">
    <div class="header">아르바이트 지원서</div>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-bordered resume-table">
                <tbody>
                    <tr>
                        <th>성명</th>
                        <td colspan="3"><c:out value="${resume.name}" /></td>
                        <th>성별</th>
                        <td><c:out value="${resume.gender}" /></td>
                        <th rowspan="4" class="photo-cell">
                            <img src="resources/images/${resume.myimgName}" alt="사진">
                        </th>
                    </tr>
                    <tr>
                        <th>생년월일</th>
                        <td colspan="2"><c:out value="${resume.birthdate}" /></td>
                        <th>연락처</th>
                        <td colspan="2"><c:out value="${resume.contact}" /></td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td colspan="5"><c:out value="${resume.address}" /></td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td colspan="5"><c:out value="${resume.email}" /></td>
                    </tr>
                    <tr>
                        <th>학력사항</th>
                        <td colspan="6">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>학교명</th>
                                        <th>기간</th>
                                        <th>전공</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="index" items="${schools}" varStatus="status">
                                        <tr>
                                            <td><c:out value="${schools[status.index]}" /></td>
                                            <td><c:out value="${periods[status.index]}" /></td>
                                            <td><c:out value="${majors[status.index]}" /></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <th>경력사항</th>
                        <td colspan="6">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>직장명</th>
                                        <th>경력 기간</th>
                                        <th>주요 업무</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="index" items="${jopTitles}" varStatus="status">
                                        <tr>
                                            <td><c:out value="${jopTitles[status.index]}" /></td>
                                            <td><c:out value="${experiencePeriods[status.index]}" /></td>
                                            <td><c:out value="${mainWorks[status.index]}" /></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <th>지원 동기</th>
                        <td colspan="6" style="padding-top: 20px;"><c:out value="${resume.reason}" /></td>
                    </tr>
                    <tr>
                        <th>근무 시간</th>
                        <td colspan="2" style="padding-top: 20px;"><c:out value="${resume.work_hours}" /></td>
                        <th>희망 시급</th>
                        <td style="padding-top: 20px;"><c:out value="${resume.desired_salary}" /></td>
                        <th>희망 휴일</th>
                        <td style="padding-top: 20px;"><c:out value="${resume.desired_days}" /></td>
                    </tr>
                </tbody>
            </table>

            <div class="text-center mt-4">
                <a href="resume" class="btn btn-primary">새 이력서 작성</a>
                <a href="home" class="btn btn-secondary">홈으로</a>
                <a href="resumeupdate?number=${resume.number}" class="btn btn-primary">수정</a>
                <a href="resumedelete?number=${resume.number}" class="btn btn-danger" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
</div>
</body>
</html>
